package com.example.pjt_inbuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class add_in4 extends AppCompatActivity {

    Button btn_check;
    Spinner spinner_sk_ant,spinner_kt_ant,spinner_lg_ant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in4);

        btn_check = (Button)findViewById(R.id.btn_add_complete);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "등록 완료 서버 업로드 중 입니다.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(),HomeFragment.class);
                startActivity(intent);
            }
        });

        spinner_sk_ant = (Spinner)findViewById(R.id.spinner_sk_ant);
        spinner_kt_ant = (Spinner)findViewById(R.id.spinner_kt_ant);
        spinner_lg_ant = (Spinner)findViewById(R.id.spinner_lg_ant);
        ArrayAdapter antAdapter  = ArrayAdapter.createFromResource(this,R.array.ant_type,android.R.layout.simple_spinner_dropdown_item);

        spinner_sk_ant.setAdapter(antAdapter);
        spinner_kt_ant.setAdapter(antAdapter);
        spinner_kt_ant.setAdapter(antAdapter);



    }
}
