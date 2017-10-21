package com.lurear.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lurear.R;

import java.util.ArrayList;

/**
 * Created by security on 10/21/2017.
 */



public class LARAddInterestAdapter extends ArrayAdapter<LARAddInterestsModel> {

    ArrayList<LARAddInterestsModel> itemslList = new ArrayList<>();

    public LARAddInterestAdapter(Context context, int textViewResourceId, ArrayList<LARAddInterestsModel> objects) {
        super(context, textViewResourceId, objects);
        itemslList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_add_interest_cell, null);
        TextView txtViewInterestItemName = (TextView) v.findViewById(R.id.textViewInterestItem);
        txtViewInterestItemName.setText(itemslList.get(position).getName());

        return v;

    }

}

