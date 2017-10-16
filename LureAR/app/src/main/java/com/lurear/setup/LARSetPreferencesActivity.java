package com.lurear.setup;

import android.os.Bundle;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARSetPreferencesActivity extends LARBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_preference);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
