package com.lurear.app;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
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
}
