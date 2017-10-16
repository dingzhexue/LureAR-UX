package com.lurear.setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARAddProfilePictureActivity extends LARBaseActivity {
    @BindView(R.id.btTakePhoto)
    ImageView mIBTakePhoto;

    @BindView(R.id.toolbar)
    Toolbar mIBToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile_picture);

        if (mIBToolbar != null) {
            setSupportActionBar(mIBToolbar);
            getSupportActionBar().setTitle("Profile Picture");
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick(R.id.btTakePhoto)
    void onTakePhotoClicked(View view) {
        Intent intent = new Intent(LARAddProfilePictureActivity.this, LARPersonalInfoActivity.class);
        startActivity(intent);
    }
}
