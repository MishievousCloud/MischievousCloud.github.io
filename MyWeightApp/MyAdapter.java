package com.zybooks.MyWeight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
/*
 *==================================================================================================
 * The MyAdapter class is used to inflate the list view in the home activity. This will populate
 * the list with the items in the database for dates and weights. See list_item.xml to adjust the
 * items layout in the view.
 *
 * BEFORE CHANGES:
 * There were some minor error messages.
 *
 * AFTER CHANGES:
 * Error messages were handled and suppressed. Redundancies removed.
 *
 *==================================================================================================
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<User> arrayList;

    public MyAdapter(Context context, ArrayList<User> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Inflate view with custom list view
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView itemDate = convertView.findViewById(R.id.item_date);
        TextView itemWeight = convertView.findViewById(R.id.item_weight);

        User user = arrayList.get(position);

        //Set text views to user inputs for data and weight
        itemDate.setText(user.getDate());
        itemWeight.setText(user.getWeight());

        return convertView;
    }
}
