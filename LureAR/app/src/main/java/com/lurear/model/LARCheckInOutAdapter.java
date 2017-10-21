package com.lurear.model;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.lurear.R;

import java.util.ArrayList;
        import java.util.HashMap;

public class LARCheckInOutAdapter extends ArrayAdapter<LARCheckInOutModel> {

    ArrayList<LARCheckInOutModel> animalList = new ArrayList<>();

    public LARCheckInOutAdapter(Context context, int textViewResourceId, ArrayList<LARCheckInOutModel> objects) {
        super(context, textViewResourceId, objects);
        animalList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_list_cell, null);
        TextView txtViewName = (TextView) v.findViewById(R.id.textViewName);
        txtViewName.setText(animalList.get(position).getName());
        TextView txtViewDate = (TextView) v.findViewById(R.id.textViewDate);
        txtViewDate.setText(animalList.get(position).getDate());
        TextView txtViewTime = (TextView) v.findViewById(R.id.textViewTime);
        txtViewTime.setText(animalList.get(position).getTime());
        return v;

    }

}
