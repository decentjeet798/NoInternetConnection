package com.ranjeet.nointernetconnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends Activity {

    Boolean isConnectionExist = false;
    InternetDetector3 cd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btnStatus = (Button) findViewById(R.id.btn_check);
        cd = new InternetDetector3(getApplicationContext());
        btnStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                isConnectionExist = cd.checkMobileInternetConn();
                if (isConnectionExist) {
                    showAlertDialog(MainActivity3.this, "Internet Connection",
                            "Yeah ! Internet Found !!", true);
                } else {

                    showAlertDialog(MainActivity3.this, "No Internet Connection",
                            "Your device doesn't have mobile internet", false);
                }
            }

        });

    }

    @SuppressWarnings("deprecation")
    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.success);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }
}