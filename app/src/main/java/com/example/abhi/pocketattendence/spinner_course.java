package com.example.abhi.pocketattendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class spinner_course extends AppCompatActivity{

        Spinner spn1;
        public void submit(View view){
            String s1=String.valueOf(spn1.getSelectedItem());
            Intent intent=new Intent(this,detail.class);
            intent.putExtra("course",s1);
            startActivity(intent);

        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.spinner_course);
            List<String> course=new ArrayList<String>();
            spn1=findViewById(R.id.spn1);
            //select course_list from tablename where faculty_name="";
            course.add("B.Tech-Civil Ist");
            course.add("MCA Ist");
            course.add("M.Sc-MATH Ist");
            course.add("MBA Ist");
            course.add("B.Tech-CSE IInd");
            course.add("MCA IInd");
            course.add("M.Sc-MATH IInd");

            ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,   course);
            spn1.setAdapter(data);

        }
    }

