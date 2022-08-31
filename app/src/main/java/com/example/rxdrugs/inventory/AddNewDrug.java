package com.example.rxdrugs.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxdrugs.Database;
import com.example.rxdrugs.MainActivity;
import com.example.rxdrugs.R;
import com.example.rxdrugs.alldrugs.DrugsDB;
import com.example.rxdrugs.alldrugs.DrugsList;
import com.example.rxdrugs.alldrugs.DrugsMain;

import org.w3c.dom.Text;

public class AddNewDrug extends AppCompatActivity {

    EditText id, brandName, genericName, manufacturer, date, quantity, dose, type;
    ImageView back;
    TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_drug);

        brandName = findViewById(R.id.brandNameText);
        genericName = findViewById(R.id.genericNameText);
        manufacturer = findViewById(R.id.manuText);
        date = findViewById(R.id.dateText);
        quantity = findViewById(R.id.quantityText);
        dose = findViewById(R.id.doseText);
        type = findViewById(R.id.typeText);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            long iddd = extras.getLong(Inventory.EXTRA_WORK_ID);
            InventoryDB inventoryDB = Database.getInstance(this).inventoryyDAO().getById(iddd);
            brandName.setText(inventoryDB.getBrandName());
            genericName.setText(inventoryDB.getGeneric());
            manufacturer.setText(inventoryDB.getManufacturer());
            date.setText(inventoryDB.getDate());
            quantity.setText(inventoryDB.getQuantity());
            dose.setText((int) inventoryDB.getDose());
            type.setText(inventoryDB.getType());
        }
    }
    public void onSave(View view){
        String quantityValue = quantity.getText().toString();
        String doseValue = dose.getText().toString();
        InventoryDB inventoryDB = new InventoryDB(
                brandName.getText().toString(),
                genericName.getText().toString(),
                manufacturer.getText().toString(),
                date.getText().toString(),
                Integer.parseInt(quantityValue),
                Integer.parseInt(doseValue),
                type.getText().toString());
        Database.getInstance(this).inventoryyDAO().add(inventoryDB);
        Intent intent = new Intent(this, Inventory.class);
        startActivity(intent);

    }
    public void onCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}