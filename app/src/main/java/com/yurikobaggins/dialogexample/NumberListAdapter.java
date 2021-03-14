package com.yurikobaggins.dialogexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NumberListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    String[] numberArray;

    public NumberListAdapter(Context context, String[] numberArray) {
        this.context = context;
        this.numberArray = numberArray;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return numberArray.length;
    }

    @Override
    public String getItem(int position) {
        return numberArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_number_list, parent, false);
        TextView numberTextView = convertView.findViewById(R.id.numberTextView);
        numberTextView.setText(numberArray[position]);
        return convertView;
    }
}
