package com.example.abhi.pocketattendence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends AppCompatActivity {

    RecyclerView studentList;
    RecyclerView.Adapter ad;
    List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        studentList=findViewById(R.id.list);
        studentList.setHasFixedSize(true);
        studentList.setLayoutManager(new LinearLayoutManager(this));
        listItems=new ArrayList<>();
        String names[]={"Alpha Clasher","Hydra Dynamo","Soul Mortal"};
        for(int i=0;i<names.length;i++)
        {
            ListItem listItem=new ListItem(i,names[i]);
            listItems.add(listItem);
        }
        ad=new MyAdapter(listItems,this);
        studentList.setAdapter(ad);
    }
}
