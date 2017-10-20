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
    }

    @OnClick(R.id.btHomePin)
    void homePinClickListener() {
        LARCommon.showDistancePickerDialog(LARHomeActivity.this);
    }

    @OnClick(R.id.btSelectGeoFence)
    void selectGeoFenceClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARSelectLocationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btHomeSide)
    void homeSideClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
