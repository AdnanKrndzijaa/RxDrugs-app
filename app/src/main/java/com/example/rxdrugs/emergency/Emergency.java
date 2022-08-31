package com.example.rxdrugs.emergency;

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
import com.example.rxdrugs.inventory.Inventory;
import com.example.rxdrugs.settings.Settings;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_calls);

        ImageButton menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog buttonSheetDialog = new BottomSheetDialog(
                        Emergency.this, R.style.BottomSheetDialogTheme
                );
                View buttonSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottom_sheet_container)
                        );
                buttonSheetView.findViewById(R.id.homeText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Emergency.this, MainActivity.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.drugText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Emergency.this, DrugsMain.class);
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
                        Toast message = Toast.makeText(getApplicationContext(), "Emergency", Toast.LENGTH_SHORT);
                        message.show();
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
                        Intent intent = new Intent(Emergency.this, Settings.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Emergency.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Emergency.this).inflate(
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Emergency.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Emergency.this).inflate(
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

    public void onBACKemClick (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onPoliceDeptClick (View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + "122"));
        startActivity(intent);
    }
    public void onFireDeptClick (View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + "123"));
        startActivity(intent);
    }
    public void onAmbulanceClick (View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + "124"));
        startActivity(intent);
    }
    public void onEmailClick (View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "udruga@proslavi-oporavak.ba");
        intent.putExtra(Intent.EXTRA_SUBJECT, "RxDrugs App - Info");
        startActivity(intent);
    }
    public void onPhoneClick (View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + "38733201761"));
        startActivity(intent);
    }
    public void onUPNClick (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://sarajevo.travel/en/tourist-info/basic-information/useful-phone-numbers/31"));
        startActivity(intent);
    }
}