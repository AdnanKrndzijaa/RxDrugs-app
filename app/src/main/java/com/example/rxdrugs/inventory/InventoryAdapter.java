package com.example.rxdrugs.inventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxdrugs.R;
import com.example.rxdrugs.alldrugs.DrugsDB;

import java.util.List;

public class InventoryAdapter extends BaseAdapter {
    private Context context;
    private List<InventoryDB> inventoryDBList;

    public InventoryAdapter(Context context, List<InventoryDB> inventoryDBList) {
        this.context = context;
        this.inventoryDBList = inventoryDBList;
    }

    @Override
    public int getCount() {
        return inventoryDBList.size();
    }

    @Override
    public Object getItem(int i) {
        return inventoryDBList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return inventoryDBList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.inventory_list_item, viewGroup,false);
        InventoryDB inventoryDB = inventoryDBList.get(i);

        TextView brandNameTextView = view.findViewById(R.id.drugNameInv);
        TextView genericTextView = view.findViewById(R.id.drugGenInv);
        TextView manuTextView = view.findViewById(R.id.drugManuInv);
        TextView quantityTextView = view.findViewById(R.id.drugQuantityInv);
        TextView doseTextView = view.findViewById(R.id.drugDoseInv);
        TextView typeTextView = view.findViewById(R.id.drugTypeInv);

        brandNameTextView.setText(inventoryDB.getBrandName());
        manuTextView.setText(inventoryDB.getManufacturer());
        quantityTextView.setText(String.valueOf(inventoryDB.getQuantity()));
        genericTextView.setText(inventoryDB.getGeneric());
        doseTextView.setText(String.valueOf(inventoryDB.getDose()) + "mg / ml");
        typeTextView.setText(inventoryDB.getType());

        return view;
    }
}


