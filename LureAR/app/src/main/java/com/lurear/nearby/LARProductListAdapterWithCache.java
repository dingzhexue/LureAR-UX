// ProductListAdapterWithCache.java
package com.lurear.nearby;


import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lurear.R;

import java.util.List;



public class LARProductListAdapterWithCache extends ArrayAdapter<LARProduct> {
    private final Context mContext;
    List<LARProduct> mylist;
    public LARProductListAdapterWithCache(Activity  _context, List<LARProduct> _mylist) {
        super(_context, R.layout.fragment_lurenearbylist_cell, _mylist);

        mContext = _context;
        this.mylist = _mylist;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LARProduct product = getItem(position);

        ProductViewHolder holder;

        if (convertView == null) {
            convertView = new LinearLayout(getContext());
//            String inflater = Context.LAYOUT_INFLATER_SERVICE;
//            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
//            convertView = vi.inflate(R.layout.lurenearbylist_cell, parent, false);
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.fragment_lurenearbylist_cell, null,true);
            //
            holder = new ProductViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.image);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            holder.imgring=(ImageView)convertView.findViewById(R.id.imagering);
            //
            convertView.setTag(holder);
        }
        else{
            holder = (ProductViewHolder) convertView.getTag();
        }

        int resId = getContext().getResources().getIdentifier(product.title.toLowerCase(), "drawable", getContext().getPackageName());
        //
        holder.populate(product,resId);

        //
        return convertView;
    }


    static class ProductViewHolder {
        public ImageView img;
        public TextView title;
        public ImageView imgring;

        void populate(LARProduct p,int resId) {
            title.setText(p.title);


            img.setImageResource(resId);
            if (p.title!="Selena"){
                imgring.setImageResource(R.drawable.ic_ring);
            }
        }
    }

}