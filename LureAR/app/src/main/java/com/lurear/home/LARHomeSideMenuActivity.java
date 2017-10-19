package com.lurear.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;

public class LARHomeSideMenuActivity extends LARBaseActivity {
    @BindView(R.id.btHomeMenu)
    TextView mIBHomeMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);

        mIBHomeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
