package com.example.pjt_inbuilding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class add_in2 extends AppCompatActivity {

    Button btn_go_add_3;
    Spinner spinner_danmal;
    Spinner spinner_c_tool;
    Spinner spinner_sk_s_type,spinner_kt_s_type,spinner_lg_s_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in2);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
       //actionbar.setHomeButtonEnabled(true);

        btn_go_add_3= (Button)findViewById(R.id.btn_go_add_3);

        btn_go_add_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),add_in3.class);
                startActivity(intent);

            }
        });

        spinner_danmal = (Spinner)findViewById(R.id.spinner_danmal);
        ArrayAdapter danmalAdapter = ArrayAdapter.createFromResource(this,R.array.danmal,android.R.layout.simple_spinner_dropdown_item);
        danmalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_danmal.setAdapter(danmalAdapter);


        spinner_c_tool = (Spinner)findViewById(R.id.spinner_c_tool);
        ArrayAdapter ctoolAdapter = ArrayAdapter.createFromResource(this,R.array.c_tool,android.R.layout.simple_spinner_dropdown_item);
        ctoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_c_tool.setAdapter(ctoolAdapter);


        spinner_sk_s_type = (Spinner)findViewById(R.id.spinner_sk_s_type);
        spinner_kt_s_type = (Spinner)findViewById(R.id.spinner_kt_s_type);
        spinner_lg_s_type = (Spinner)findViewById(R.id.spinner_lg_s_type);

        ArrayAdapter stypeAdapter  = ArrayAdapter.createFromResource(this,R.array.s_tyoe,android.R.layout.simple_spinner_dropdown_item);
        spinner_sk_s_type.setAdapter(stypeAdapter);
        spinner_kt_s_type.setAdapter(stypeAdapter);
        spinner_lg_s_type.setAdapter(stypeAdapter);



    }
}
