package com.example.rxdrugs.alldrugs.types;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rxdrugs.R;

public class Stimulants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stimulants);
    }

    public void onDashClick(View view) {
        Intent intent = new Intent(this, TypesOfDrugs.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void onDeClick(View view) {
        Intent intent = new Intent(this, Depressants.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void onOpClick(View view) {
        Intent intent = new Intent(this, Opioids.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onHaClick(View view) {
        Intent intent = new Intent(this, Hallucinogens.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onInClick(View view) {
        Intent intent = new Intent(this, Inhalants.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}