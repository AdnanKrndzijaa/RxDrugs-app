package com.example.rxdrugs.alldrugs;

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

public class DrugsAdapter extends BaseAdapter {
    private Context context;
    private List<DrugsDB> drugsDBList;

    public DrugsAdapter(Context context, List<DrugsDB> drugsDBList) {
        this.context = context;
        this.drugsDBList = drugsDBList;
    }

    @Override
    public int getCount() {
        return drugsDBList.size();
    }

    @Override
    public Object getItem(int i) {
        return drugsDBList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return drugsDBList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.drug_list_item, viewGroup,false);
        DrugsDB drugsDB = drugsDBList.get(i);

        ImageView imageView = view.findViewById(R.id.drug_image);
        TextView brandNameTextView = view.findViewById(R.id.drug_name);
        TextView manuTextView = view.findViewById(R.id.drug_manufacturer);

        imageView.setImageResource(drugsDB.getImage());
        brandNameTextView.setText(drugsDB.getBrandName());
        manuTextView.setText(drugsDB.getManufacturer());

        return view;
    }
}

