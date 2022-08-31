package com.example.rxdrugs.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxdrugs.MainActivity;
import com.example.rxdrugs.R;
import com.example.rxdrugs.alldrugs.DrugsList;
import com.example.rxdrugs.alldrugs.DrugsMain;
import com.example.rxdrugs.alldrugs.SelectedDrug;
import com.example.rxdrugs.emergency.Emergency;
import com.example.rxdrugs.inventory.Inventory;
import com.example.rxdrugs.settings.Settings;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Login extends AppCompatActivity {
    EditText code;
    String codeMessage;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog buttonSheetDialog = new BottomSheetDialog(
                        Login.this, R.style.BottomSheetDialogTheme
                );
                View buttonSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottom_sheet_container)
                        );
                buttonSheetView.findViewById(R.id.homeText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.drugText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, DrugsMain.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.inventoryText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert("");
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.emergencyText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Emergency.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast message = Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT);
                        message.show();
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.settingsText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Settings.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetDialog.setContentView(buttonSheetView);
                buttonSheetDialog.show();
            }
        });

        code = (EditText) findViewById(R.id.codeText);
        codeMessage = code.getText().toString();
        String str = code.getText().toString();
        Log.i(str, "SUCCESS");
        continueButton = findViewById(R.id.continueButoon);
        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String myCode = "admin";
                if (codeMessage == myCode) {
                    Intent i = new Intent(Login.this, Account.class);
                    startActivity(i);
                } else if (codeMessage != myCode) {
                    Toast message = Toast.makeText(getApplicationContext(), "Code is invalid!", Toast.LENGTH_SHORT);
                    message.show();
                } else {
                    Toast error = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                    error.show();

                }
            }
        });
    }
    public void alert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Login.this).inflate(
                R.layout.layout_premium_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        view.findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rxdrugs.herokuapp.com/app.html"));
                startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
    public void newScreen(){
        Intent i = new Intent(this, Account.class);
        startActivity(i);
    }
    public void onBACKlClick (View View){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void onLoginClick (View View){
        Intent i = new Intent(this, Account.class);
        startActivity(i);
    }
}