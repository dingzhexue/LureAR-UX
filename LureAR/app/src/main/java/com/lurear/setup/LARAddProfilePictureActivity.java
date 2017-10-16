package com.lurear.setup;

import android.content.Intent;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile_picture);
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
