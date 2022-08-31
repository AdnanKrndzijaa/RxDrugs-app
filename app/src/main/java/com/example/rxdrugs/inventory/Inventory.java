package com.example.rxdrugs.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxdrugs.Database;
import com.example.rxdrugs.MainActivity;
import com.example.rxdrugs.R;
import com.example.rxdrugs.account.Login;
import com.example.rxdrugs.alldrugs.DrugsMain;
import com.example.rxdrugs.emergency.Emergency;
import com.example.rxdrugs.settings.Settings;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends AppCompatActivity {
    public static final String EXTRA_WORK_ID = "Inventory/EXTRA_WORK_ID";
    ListView listView;
    ImageView back;
    TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        ImageButton menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog buttonSheetDialog = new BottomSheetDialog(
                        Inventory.this, R.style.BottomSheetDialogTheme
                );
                View buttonSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottom_sheet_container)
                        );
                buttonSheetView.findViewById(R.id.homeText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Inventory.this, MainActivity.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.drugText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Inventory.this, DrugsMain.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.inventoryText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast message = Toast.makeText(getApplicationContext(), "Inventory", Toast.LENGTH_SHORT);
                        message.show();
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.emergencyText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Inventory.this, Emergency.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Inventory.this, Login.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.settingsText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Inventory.this, Settings.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetDialog.setContentView(buttonSheetView);
                buttonSheetDialog.show();
            }
        });

        listView = findViewById(R.id.inventory_list);
        List<InventoryDB> inv = Database.getInstance(this).inventoryyDAO().getAll();
        InventoryAdapter adapter = new InventoryAdapter(this, inv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long idd = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), AddNewDrug.class);
                intent.putExtra(EXTRA_WORK_ID, idd);
                startActivity(intent);
            }
        });
    }

    public void onBACKkClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onADDClick(View view){
        Intent intent = new Intent(this, AddNewDrug.class);
        startActivity(intent);
    }


}