package com.lurear.setup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_preference);

        mIBBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mIBMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIBMale.setImageResource(R.mipmap.ic_btn_male_ena);
                mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
                mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
            }
        });

        mIBFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
                mIBFemale.setImageResource(R.mipmap.ic_btn_femail_ena);
                mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
            }
        });

        mIBTransGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
                mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
                mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_ena);
            }
        });
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
