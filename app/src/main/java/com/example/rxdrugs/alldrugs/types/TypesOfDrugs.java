package com.example.rxdrugs.alldrugs.types;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rxdrugs.MainActivity;
import com.example.rxdrugs.R;
import com.example.rxdrugs.account.Login;
import com.example.rxdrugs.alldrugs.DrugsMain;
import com.example.rxdrugs.emergency.Emergency;
import com.example.rxdrugs.inventory.Inventory;
import com.example.rxdrugs.settings.Settings;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TypesOfDrugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_drugs);

        ImageButton menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog buttonSheetDialog = new BottomSheetDialog(
                        TypesOfDrugs.this, R.style.BottomSheetDialogTheme
                );
                View buttonSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottom_sheet_container)
                        );
                buttonSheetView.findViewById(R.id.homeText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TypesOfDrugs.this, MainActivity.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.drugText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TypesOfDrugs.this, DrugsMain.class);
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
                        Intent intent = new Intent(TypesOfDrugs.this, Emergency.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zombie("");
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.settingsText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TypesOfDrugs.this, Settings.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetDialog.setContentView(buttonSheetView);
                buttonSheetDialog.show();
            }
        });
    }
    public void zombie(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TypesOfDrugs.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TypesOfDrugs.this).inflate(
                R.layout.layout_zombie_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
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
    public void alert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TypesOfDrugs.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TypesOfDrugs.this).inflate(
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
    public void onWSClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rxdrugs.herokuapp.com/drugs.html"));
        startActivity(intent);
    }
    public void onDeClick(View view) {
        Intent intent = new Intent(this, Depressants.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onStClick(View view) {
        Intent intent = new Intent(this, Stimulants.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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