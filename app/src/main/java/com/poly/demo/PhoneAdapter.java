package com.poly.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {

    private ArrayList<Phone> arrayList;

    public PhoneAdapter(ArrayList<Phone> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row, parent, false);
        TextView tv = view.findViewById(R.id.textView);
        Phone phone = arrayList.get(position);
        String data = phone.ID + " - " + phone.NAME + " - " + phone.PRICE + " - " + phone.PRO_ID;
        tv.setText(data);

        return view;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
