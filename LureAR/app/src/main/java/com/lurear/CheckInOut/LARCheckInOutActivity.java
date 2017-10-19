package com.lurear.checkinout;

import android.os.Bundle;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;



public class LARCheckInOutActivity extends LARBaseActivity {

    @Override
    public boolean supportOffline() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_out);
    }
}
