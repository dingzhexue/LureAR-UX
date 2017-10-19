package com.lurear.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARHomeActivity extends LARBaseActivity {
    @BindView(R.id.btHomeSide)
    ImageView mIBHomeSide;

    @BindView(R.id.btHomePin)
    ImageView mIBHomePin;

    @BindView(R.id.btSelectGeoFence)
    ImageView mIBSelectGeoFence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mIBHomeSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LARHomeActivity.this, LARHomeSideMenuActivity.class);
                startActivity(intent);
            }
        });

        mIBHomePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LARCommon.showDistancePickerDialog(LARHomeActivity.this);
            }
        });

        mIBSelectGeoFence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LARHomeActivity.this, LARSelectLocationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
