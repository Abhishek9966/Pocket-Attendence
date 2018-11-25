package com.example.abhi.pocketattendence;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginPage extends Fragment implements View.OnClickListener{

    Button btnLogin;
    public LoginPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login_page, container, false);
        btnLogin=v.findViewById(R.id.login);
        /*
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginPage","OnClick method");
                Intent intent=new Intent(getActivity(),StudentList.class);
                startActivity(intent);
            }
        });
        */
        return v;
    }
    @Override
    public void onStart()
    {
        super.onStart();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginPage","OnClick method");
                Intent intent=new Intent(getActivity(),StudentList.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Intent intent=new Intent(getActivity(),StudentList.class);
        startActivity(intent);
        Button newBlockButton =view.findViewById(R.id.login);
        newBlockButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.d("LoginPage","OnClick method");

    }
}
