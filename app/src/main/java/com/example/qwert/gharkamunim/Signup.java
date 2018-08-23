package com.example.qwert.gharkamunim;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final Fragment_signup_cstm fragment_signupcstm =new Fragment_signup_cstm();
        setfragment(fragment_signupcstm);

        final Button bt1,bt2;
        bt1=(Button)findViewById(R.id.btn_frag_cstm);               //button for fragment customer
        bt2=(Button)findViewById(R.id.btn_frag_shpkpr);             //button for fragment shopkeeper


        Button bt=(Button)findViewById(R.id.link_signup);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Signup.this,Navigatin_main.class);
                startActivity(i);
            }
        });

        bt1.setBackgroundColor(Color.LTGRAY);
        bt2.setBackgroundColor(Color.WHITE);
        bt1.setTextColor(Color.WHITE);
        bt2.setTextColor(Color.DKGRAY);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfragment(fragment_signupcstm);
                bt1.setBackgroundColor(Color.LTGRAY);
                bt2.setBackgroundColor(Color.WHITE);
                bt1.setTextColor(Color.WHITE);
                bt2.setTextColor(Color.DKGRAY);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Fragment_signup_shpkpr fragment_signupshpkpr =new Fragment_signup_shpkpr();
                setfragment(fragment_signupshpkpr);
                bt2.setBackgroundColor(Color.LTGRAY);
                bt1.setBackgroundColor(Color.WHITE);
                bt2.setTextColor(Color.WHITE);
                bt1.setTextColor(Color.DKGRAY);
            }
        });


    }
    void setfragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_registeration,fragment);
        fragmentTransaction.commit();
    }
}
