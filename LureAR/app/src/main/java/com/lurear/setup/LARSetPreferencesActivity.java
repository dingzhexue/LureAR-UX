package com.lurear.setup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeActivity;
import com.lurear.signup.ui.LARSignInActivity;
import com.lurear.signup.ui.LARSignUpActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARSetPreferencesActivity extends LARBaseActivity {
    @BindView(R.id.btBack)
    ImageButton mIBBack;

    @BindView(R.id.btMale)
    ImageView mIBMale;

    @BindView(R.id.btFemail)
    ImageView mIBFemale;

    @BindView(R.id.btTransGender)
    ImageView mIBTransGender;

    @BindView(R.id.btSave)
    ImageView mIBSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_preference);
    }

    @OnClick(R.id.btBack)
    void backClickListener() {
        finish();
    }

    @OnClick(R.id.btMale)
    void maleClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_ena);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
    }

    @OnClick(R.id.btFemail)
    void femaleClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_ena);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
    }

    @OnClick(R.id.btTransGender)
    void selectGeoFenceClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_ena);
    }

    @OnClick(R.id.btSave)
    void onSaveClicked(View view) {
        Intent intent = new Intent(LARSetPreferencesActivity.this, LARHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
