package com.lurear.onboard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.MenuItem;

import com.gpit.android.ui.common.BaseActivity;
import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import butterknife.ButterKnife;

/**
 * Created by administrator on 8/3/17.
 */

public class LAROnboardActivity extends LARBaseActivity {
    @Override
    public boolean supportOffline() {
        return false;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_onboard);

    }
}