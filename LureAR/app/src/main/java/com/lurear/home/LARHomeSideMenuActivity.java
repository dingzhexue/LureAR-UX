package com.lurear.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.checkinout.LARCheckInOutActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARHomeSideMenuActivity extends LARBaseActivity {
    @BindView(R.id.btHomeMenu)
    TextView mIBHomeMenu;

    @BindView(R.id.btCheckInOut)
    TextView mIBCheckInOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);
    }

    @OnClick(R.id.btHomeMenu)
    void homeMenuClickListener() {
        finish();

        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }

    @OnClick(R.id.btCheckInOut)
    void checkInOutClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARCheckInOutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @Override
    public boolean supportOffline() {
        return false;
    }
}
