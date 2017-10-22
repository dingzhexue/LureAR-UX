package com.lurear.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.BottomSheetDialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.gpit.android.logger.RemoteLogger;
import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.model.LARAddInterestAdapter;
import com.lurear.model.LARAddInterestsModel;
import com.lurear.model.LARCheckInOutAdapter;
import com.lurear.model.LARCheckInOutModel;
import com.splunk.mint.Mint;

import java.util.ArrayList;

/**
 * Created by administrator on 8/6/17.
 */

public class LARCommon {
    private static LARCommon instance;

    public static LARCommon getInstance() {
        if (instance == null) {
            instance = new LARCommon();
        }

        return instance;
    }

    private LARCommon() {
    }

    public void handleError(LARBaseActivity activity, String tag, Exception e) {
        RemoteLogger.e(tag, e.getLocalizedMessage());
        Mint.logException(e);
        e.printStackTrace();

        if (activity != null) {
            Toast.makeText(activity, R.string.something_went_wrong, Toast.LENGTH_LONG).show();

            activity.finish();
        }
    }

    public void updateStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        Window window = activity.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(activity.getColor(R.color.colorPrimary));
    }

    private static Dialog pickerDistanceDialog;
    private static Dialog pickerAddGeoFenceDialog;
    private static Dialog pickerHomeGeoFenceDialog;
    private static Dialog pickerAddInterestsDialog;

    public static void hidePickerDialog() {
        if (pickerDistanceDialog != null && pickerDistanceDialog.isShowing()) {
            pickerDistanceDialog.hide();
            pickerDistanceDialog = null;
        }
    }

    public static void hideAddGeoFencePickerDialog() {
        if (pickerAddGeoFenceDialog != null && pickerAddGeoFenceDialog.isShowing()) {
            pickerAddGeoFenceDialog.hide();
            pickerAddGeoFenceDialog = null;
        }
    }

    public static void hideHomeGeoFencePickerDialog() {
        if (pickerHomeGeoFenceDialog != null && pickerHomeGeoFenceDialog.isShowing()) {
            pickerHomeGeoFenceDialog.hide();
            pickerHomeGeoFenceDialog = null;
        }
    }
    public static void hideAddInterestsPickerDialog() {
        if (pickerAddInterestsDialog != null && pickerAddInterestsDialog.isShowing()) {
            pickerAddInterestsDialog.hide();
            pickerAddInterestsDialog = null;
        }
    }

    public static void showDistancePickerDialog(final Context context) {
        hidePickerDialog();

        pickerDistanceDialog = new Dialog(context);

        pickerDistanceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerDistanceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerDistanceDialog.setContentView(R.layout.activity_save_distance_picker);
        pickerDistanceDialog.setCancelable(true);
        pickerDistanceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerDistanceDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerDistanceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnCL = (Button)pickerDistanceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hidePickerDialog();
            }
        });

        pickerDistanceDialog.show();
    }

    public static void showAddGeoFenceDialog(final Context context) {
        //hideAddGeoFencePickerDialog();

        pickerAddGeoFenceDialog = new Dialog(context);
        pickerAddGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddGeoFenceDialog.setContentView(R.layout.activity_add_geo_fence);
        pickerAddGeoFenceDialog.setCancelable(true);
        pickerAddGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddGeoFenceDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerAddGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnCL = (Button)pickerAddGeoFenceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showHomeGeoFenceDialog(context);
                hideAddGeoFencePickerDialog();

            }
        });

        pickerAddGeoFenceDialog.show();
    }

    public static void showHomeGeoFenceDialog(final Context context) {

        pickerHomeGeoFenceDialog = new Dialog(context);
        pickerHomeGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerHomeGeoFenceDialog.setContentView(R.layout.activity_home_geo_fence);
        pickerHomeGeoFenceDialog.setCancelable(true);
        pickerHomeGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerHomeGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerHomeGeoFenceDialog.getWindow().setGravity(Gravity.BOTTOM);
        Button btnCL = (Button)pickerHomeGeoFenceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideHomeGeoFencePickerDialog();
            }
        });
        Button btnAddNewGeoFence = (Button)pickerHomeGeoFenceDialog.findViewById(R.id.btAddNewGeoFence);
        btnAddNewGeoFence.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideHomeGeoFencePickerDialog();
            }
        });
        pickerHomeGeoFenceDialog.show();
    }

    public static void showAddInterestsDialog(final Context context) {



        pickerAddInterestsDialog = new Dialog(context);
        pickerAddInterestsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddInterestsDialog.setContentView(R.layout.activity_add_interest);
        pickerAddInterestsDialog.setCancelable(true);
        pickerAddInterestsDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddInterestsDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerAddInterestsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnCL = (Button)pickerAddInterestsDialog.findViewById(R.id.btAddInterests);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideAddInterestsPickerDialog();
            }
        });
        pickerAddInterestsDialog.show();

        ListView itemsList;
        ArrayList<LARAddInterestsModel> addItemsList=new ArrayList<>();
        itemsList = (ListView) pickerAddInterestsDialog.findViewById(R.id.addInterestsItemListView);
        addItemsList.add(new LARAddInterestsModel("Soccer"));
        addItemsList.add(new LARAddInterestsModel("Gymming"));
        addItemsList.add(new LARAddInterestsModel("Trying New Things"));
        addItemsList.add(new LARAddInterestsModel("Foodie"));
        addItemsList.add(new LARAddInterestsModel("BasketBall"));
        addItemsList.add(new LARAddInterestsModel("Long Drives"));
        addItemsList.add(new LARAddInterestsModel("Partying"));
        addItemsList.add(new LARAddInterestsModel("Night Outs"));
        addItemsList.add(new LARAddInterestsModel("Trekking"));
        addItemsList.add(new LARAddInterestsModel("Swimming"));

        LARAddInterestAdapter myAdapter=new LARAddInterestAdapter(context,R.layout.fragment_add_interest_cell,addItemsList);
        itemsList.setAdapter(myAdapter);

    }
}
