package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowEmployeeActivity extends AppCompatActivity {
    private Button ShowEmployee;
    private Button SearchEmployee;
    private Button btnregisteremp;
    private Button btnupdeleteemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_show_employee);

        ShowEmployee = findViewById (R.id.btnshowemp);
        ShowEmployee.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowEmployeeActivity.this, MainActivity.class);
                startActivity (intent);
            }
        });
        SearchEmployee= findViewById (R.id.btnsearchemp);
        SearchEmployee.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowEmployeeActivity.this, SearchEmployeeActivity.class);
                startActivity (intent);
            }
        });
        btnregisteremp = findViewById (R.id.btnregisteremp);
        btnregisteremp.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowEmployeeActivity.this, RegisterEmployeeActivity.class);
                startActivity (intent);
            }
        });
        btnupdeleteemp=findViewById (R.id.btnupdeleteemp);
        btnupdeleteemp.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowEmployeeActivity.this, UpdateEmployeeActivity.class);
                startActivity (intent);
            }
        });


    }
}
