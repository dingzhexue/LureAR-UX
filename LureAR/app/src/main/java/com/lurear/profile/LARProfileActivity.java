package com.lurear.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeSideMenuActivity;
import com.lurear.powershop.LARPowerShopActivity;
import com.lurear.signup.ui.LARSignInActivity;

import java.util.ArrayList;

import butterknife.OnClick;

public class LARProfileActivity extends LARBaseActivity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_profile);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(LARProfileActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        //Set False ListView
        ExpandList.expandGroup(0);
        ExpandList.expandGroup(1);
        //Set Group Indicator...
        ExpandList.setGroupIndicator(null);
    }
    @OnClick(R.id.tvlogout)
    public void logoutclick()
    {
        Intent intent = new Intent(LARProfileActivity.this, LARSignInActivity.class);
        startActivity(intent);
    }
    //Set Data to ExpandableListView..
    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = { "PERSONAL INFO", "PREFERENCES" };

        String personal_item[] = {"Age", "Gender", "Interests", "Offers"};
        String prefference_item[] = {"Gender, Distance, Age"};
        int image = R.mipmap.ic_arrow;
        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;



        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            int j = 0;
            if (gru.getName().equals("PERSONAL INFO")){
                for (; j < personal_item.length; j++) {
                    Child ch = new Child();
                    ch.setName(personal_item[j]);
                    ch.setImage(image);
                    ch_list.add(ch);
                }
            }else{
                for (; j < prefference_item.length; j++) {
                    Child ch = new Child();
                    ch.setName(prefference_item[j]);
                    ch.setImage(image);
                    ch_list.add(ch);
                }
            }
            gru.setItems(ch_list);
            list.add(gru);

        }

        return list;
    }
    @Override
    public boolean supportOffline() {
        return false;
    }
}
