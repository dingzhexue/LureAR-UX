package com.lurear.setup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARPersonalInfoActivity extends LARBaseActivity {
    @BindView(R.id.btSave)
    TextView mIBSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick(R.id.btSave)
    void onSaveClicked(View view) {
        Intent intent = new Intent(LARPersonalInfoActivity.this, LARSetPreferencesActivity.class);
        startActivity(intent);
    }
}
