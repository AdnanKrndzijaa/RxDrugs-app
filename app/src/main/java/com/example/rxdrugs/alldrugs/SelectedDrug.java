package com.example.rxdrugs.alldrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxdrugs.Database;
import com.example.rxdrugs.R;

public class SelectedDrug extends AppCompatActivity {
    private TextView brandName, desc, manu, dose, gen, type, amount;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_drug);

        brandName = findViewById(R.id.selected_brandname);
        gen = findViewById(R.id.selected_genericname);
        image = findViewById(R.id.selected_image);
        manu = findViewById(R.id.selected_manufacturer);
        dose = findViewById(R.id.selected_dose);
        type = findViewById(R.id.selected_type);
        amount = findViewById(R.id.selected_amount);
        desc = findViewById(R.id.selected_desc);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            long id = extras.getLong(DrugsList.EXTRA_WORK_ID);
            DrugsDB drugsDB = Database.getInstance(this).drugsDAO().getDrugById(id);
            brandName.setText(drugsDB.getBrandName());
            gen.setText(drugsDB.getGeneric());
            manu.setText(drugsDB.getManufacturer());
            dose.setText(drugsDB.getDose() + "mg");
            type.setText(drugsDB.getType());
            amount.setText(drugsDB.getAmount() + " tbl / pack");
            desc.setText(drugsDB.getDesc());

            image.setImageResource(drugsDB.getImage());;
        }
    }
}