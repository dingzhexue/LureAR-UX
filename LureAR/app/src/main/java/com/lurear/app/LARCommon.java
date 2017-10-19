package com.lurear.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.gpit.android.logger.RemoteLogger;
import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.splunk.mint.Mint;

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

    public static void showDistancePickerDialog(final Context context) {
        hidePickerDialog();

        pickerDistanceDialog = new Dialog(context);
        pickerDistanceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerDistanceDialog.setContentView(R.layout.activity_save_distance_picker);
        pickerDistanceDialog.setCancelable(false);
        pickerDistanceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
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
        hideAddGeoFencePickerDialog();

        pickerAddGeoFenceDialog = new Dialog(context);
        pickerAddGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddGeoFenceDialog.setContentView(R.layout.activity_add_geo_fence);
        pickerAddGeoFenceDialog.setCancelable(false);
        pickerAddGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        pickerAddGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnCL = (Button)pickerAddGeoFenceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                hideAddGeoFencePickerDialog();

                showHomeGeoFenceDialog(context);
            }
        });

        pickerAddGeoFenceDialog.show();
    }

    public static void showHomeGeoFenceDialog(final Context context) {
        hideHomeGeoFencePickerDialog();

        pickerHomeGeoFenceDialog = new Dialog(context);
        pickerHomeGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerHomeGeoFenceDialog.setContentView(R.layout.activity_home_geo_fence);
        pickerHomeGeoFenceDialog.setCancelable(false);
        pickerHomeGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        pickerHomeGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        Button btnCL = (Button)pickerHomeGeoFenceDialog.findViewById(R.id.btSave);
//        btnCL.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                hideHomeGeoFencePickerDialog();
//
//
//            }
//        });

        pickerHomeGeoFenceDialog.show();
    }
}
