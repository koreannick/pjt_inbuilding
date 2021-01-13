package com.example.pjt_inbuilding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

public class add_in extends AppCompatActivity {

    static final String KEY_DATA = "KEY_DATA";

    EditText edt_juso;

    Button btn_go_add_2;
    Spinner spinner_chasu;
    Spinner spinner_bonbu;
    Spinner spinner_team;
    Spinner spinner_si;
    Spinner spinner_gu;
    Spinner spinner_sisulgun;
    Button btn_juso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_in);



        //뒤로가기버튼
        //Toolbar mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
  //     actionbar.setHomeButtonEnabled(true);

        btn_juso = (Button)findViewById(R.id.btn_juso);

        btn_juso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_juso = new Intent(getApplicationContext(),SearchAddress.class);
                startActivity(intent_juso);
            }
        });




        spinner_chasu = findViewById(R.id.spinner_chasu);
        ArrayAdapter chasuAdapter = ArrayAdapter.createFromResource(this,R.array.chasu,android.R.layout.simple_spinner_dropdown_item);
        chasuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_chasu.setAdapter(chasuAdapter);

//        spinner_chasu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 차수 : "+spinner_chasu.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        spinner_bonbu = findViewById(R.id.spinner_bonbu);
        ArrayAdapter bonbuAdapter = ArrayAdapter.createFromResource(this,R.array.bonbu,android.R.layout.simple_spinner_dropdown_item);
        bonbuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_bonbu.setAdapter(bonbuAdapter);
//
//        spinner_bonbu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 본부 : "+spinner_bonbu.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        spinner_team = findViewById(R.id.spinner_team);
        ArrayAdapter teamAdapter = ArrayAdapter.createFromResource(this,R.array.team,android.R.layout.simple_spinner_dropdown_item);
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_team.setAdapter(teamAdapter);

//        spinner_team.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 팀 : "+spinner_team.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        spinner_si = findViewById(R.id.spinner_si);
        ArrayAdapter siAdapter = ArrayAdapter.createFromResource(this,R.array.si,android.R.layout.simple_spinner_dropdown_item);
        siAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_si.setAdapter(siAdapter);

//        spinner_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 시 : "+spinner_si.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        spinner_gu = findViewById(R.id.spinner_gu);
        ArrayAdapter guAdapter = ArrayAdapter.createFromResource(this,R.array.gu,android.R.layout.simple_spinner_dropdown_item);
        guAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gu.setAdapter(guAdapter);

//        spinner_gu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 구 : "+spinner_gu.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        spinner_sisulgun = findViewById(R.id.spinner_sisulgun);
        ArrayAdapter sisulgunAdapter = ArrayAdapter.createFromResource(this,R.array.sisulgun,android.R.layout.simple_spinner_dropdown_item);
        sisulgunAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sisulgun.setAdapter(sisulgunAdapter);

//        spinner_sisulgun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"선택 시설 군 : "+spinner_sisulgun.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        //#########
        //주소입력
        //#########

        edt_juso = (EditText)findViewById(R.id.edt_juso);

        Intent intent = getIntent();
        String a = intent.getStringExtra("addr");
        if(intent.hasExtra("addr"))
            edt_juso.setText(a);

        btn_go_add_2= (Button)findViewById(R.id.btn_go_add_2);

        btn_go_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),add_in2.class);
                startActivity(intent);
            }
        });


    }
}
