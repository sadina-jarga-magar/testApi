package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import API.Employee_API;
import Model.Employee;
import Model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateEmployeeActivity extends AppCompatActivity {
    private final static String BASE_URL="http://dummy.restapiexample.com/api/v1/";
    private EditText etEmpNo;
    private EditText etEmpName, etEmpSalary, etEmpAge;
    private Button btnSearch, btnUpdate, btnDelete;
    Retrofit retrofit;
    Employee_API employee_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_update_employee);

        btnSearch= findViewById (R.id.btnSearch);
        btnUpdate= findViewById (R.id.btnUpdate);
        btnDelete= findViewById (R.id.btnDelete);
        etEmpNo= findViewById (R.id.etEmpNo);
        etEmpName=findViewById (R.id.etEmpName);
        etEmpSalary= findViewById (R.id.etEmpSalary);
        etEmpAge= findViewById (R.id.etEmpAge);
        btnSearch.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoadData();
            }
        });
        btnUpdate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                updateEmployee();
            }
        });
        btnDelete.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                deleteEmployee();
            }
        });
    }
    private void CreateInstance(){
        retrofit = new Retrofit.Builder ()
                .baseUrl (BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();
        employee_api = retrofit.create (Employee_API.class);
    }
    private void LoadData(){
        CreateInstance ();
        Call<Employee>listCall = employee_api.getEmployeeByID (Integer.parseInt (etEmpNo.getText ().toString ()));
        listCall.enqueue (new Callback<Employee> () {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                etEmpName.setText (response.body ().getEmployee_name ());
                etEmpSalary.setText (Float.toString(response.body ().getEmployee_salary ()));
                etEmpAge.setText (Integer.toString (response.body ().getEmployee_age ()));


            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText (UpdateEmployeeActivity.this, "Error" + t.getMessage (), Toast.LENGTH_SHORT).show ();

            }
        });
    }
    private void updateEmployee() {
        CreateInstance ();
        EmployeeCUD employee = new EmployeeCUD (
                Float.parseFloat (etEmpSalary.getText ().toString ()),
                etEmpName.getText ().toString (),
                Integer.parseInt (etEmpAge.getText ().toString ())
        );
        Call<Void> voidCall = employee_api.updateEmployee (Integer.parseInt (etEmpNo.getText ().toString ()), employee);
        voidCall.enqueue (new Callback<Void> () {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText (UpdateEmployeeActivity.this, "Updated", Toast.LENGTH_SHORT).show ();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText (UpdateEmployeeActivity.this, "Error" + t.getMessage (), Toast.LENGTH_SHORT).show ();

            }
        });

    }

    private void deleteEmployee(){
        CreateInstance ();
        Call<Void>voidCall = employee_api.deleteEmployee(Integer.parseInt (etEmpNo.getText ().toString ()));

        voidCall.enqueue (new Callback<Void> () {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText (UpdateEmployeeActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show ();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText (UpdateEmployeeActivity.this, "Error" + t.getLocalizedMessage (), Toast.LENGTH_SHORT).show ();

            }
        });
    }
}
