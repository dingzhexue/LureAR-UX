package com.lurear.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;

public class LARSelectLocationActivity extends LARBaseActivity {
    @BindView(R.id.btSelectLocation)
    Button mIBSelectLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        mIBSelectLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LARCommon.showAddGeoFenceDialog(LARSelectLocationActivity.this);
            }
        });
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
