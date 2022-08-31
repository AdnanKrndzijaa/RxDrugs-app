package com.example.rxdrugs.alldrugs;

import android.content.Intent;
import android.os.Bundle;

import com.example.rxdrugs.Database;
import com.example.rxdrugs.R;
import com.example.rxdrugs.inventory.AddNewDrug;
import com.example.rxdrugs.inventory.Inventory;
import com.example.rxdrugs.inventory.InventoryAdapter;
import com.example.rxdrugs.inventory.InventoryDB;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DrugsList extends AppCompatActivity {
    public static final String EXTRA_WORK_ID = "DrugsList/EXTRA_WORK_ID";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_list);
        Bundle extras = getIntent().getExtras();

        listView = findViewById(R.id.drug_list_container);
        setupListAdapter(extras.getString(DrugsMain.EXTRA_TYPE));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long todoId = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(DrugsList.this, SelectedDrug.class);
                intent.putExtra(EXTRA_WORK_ID, todoId);
                startActivity(intent);
            }
        });
    }

    private void setupListAdapter(String type){
        List<DrugsDB> work = Database.getInstance(this).drugsDAO().getByType(type);
        DrugsAdapter adapter = new DrugsAdapter(this,work);
        listView.setAdapter(adapter);
    }
    public void onBACKClick (View view) {
        Intent intent = new Intent(this, DrugsMain.class);
        startActivity(intent);
    }
}