package com.ranjeet.nointernetconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by HP on 12/6/2017.
 */

public class InternetDetector3 {
    private Context mcontext;

    public InternetDetector3(Context context) {
        this.mcontext = context;
    }

    public boolean checkMobileInternetConn() {
        ConnectivityManager connectivity = (ConnectivityManager) mcontext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (info != null) {
                if (info.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }
}