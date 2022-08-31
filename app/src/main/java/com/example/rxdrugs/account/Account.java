package com.example.rxdrugs.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rxdrugs.MainActivity;
import com.example.rxdrugs.R;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void onBackAccClick (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}