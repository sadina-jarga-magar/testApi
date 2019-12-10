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

public class RegisterEmployeeActivity extends AppCompatActivity {
    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etName, etSalary, etEmpAge;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register_employee);

        etName= findViewById (R.id.etName);
        etSalary= findViewById (R.id.etSalary);
        etEmpAge=findViewById (R.id.etEmpAge);
        btnRegister= findViewById (R.id.btnRegister);
        btnRegister.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }
    private void Register(){
        String name = etName.getText().toString ();
        Float salary = Float.parseFloat (etSalary.getText ().toString ());
        int age = Integer.parseInt(etEmpAge.getText ().toString ());

  EmployeeCUD employee = new EmployeeCUD (salary,name,age);
        Retrofit retrofit= new Retrofit.Builder ()
                .baseUrl (BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        Employee_API employee_api = retrofit.create (Employee_API.class);
        Call<Void> voidCall = employee_api.registerEmployee(employee);
        voidCall.enqueue (new Callback<Void> () {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText (RegisterEmployeeActivity.this,"You have been registered successfully" , Toast.LENGTH_SHORT).show ();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText (RegisterEmployeeActivity.this,"Error : " + t.getLocalizedMessage (), Toast.LENGTH_SHORT).show ();
            }
        });
    }
}
