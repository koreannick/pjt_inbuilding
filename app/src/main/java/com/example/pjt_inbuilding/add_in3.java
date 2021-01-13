package com.example.pjt_inbuilding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class add_in3 extends AppCompatActivity {

    Button btn_go_add_4;
    Spinner spinner_sk_mimo,spinner_kt_mimo,spinner_lg_mimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in3);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);

        btn_go_add_4= (Button)findViewById(R.id.btn_go_add_4);

        btn_go_add_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),add_in4.class);
                startActivity(intent);

            }
        });




        spinner_sk_mimo = (Spinner)findViewById(R.id.spinner_sk_mimo);
        spinner_kt_mimo = (Spinner)findViewById(R.id.spinner_kt_mimo);
        spinner_lg_mimo = (Spinner)findViewById(R.id.spinner_lg_mimo);
        ArrayAdapter mimoAdapter = ArrayAdapter.createFromResource(this,R.array.mimo_type,android.R.layout.simple_spinner_dropdown_item);
        mimoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sk_mimo.setAdapter(mimoAdapter);
        spinner_kt_mimo.setAdapter(mimoAdapter);
        spinner_lg_mimo.setAdapter(mimoAdapter);
    }
}
