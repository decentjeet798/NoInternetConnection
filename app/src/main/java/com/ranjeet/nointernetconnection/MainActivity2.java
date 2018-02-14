package com.ranjeet.nointernetconnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends Activity {

    // Declare a button
    Button visitbtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Call isNetworkAvailable class
        if (!isNetworkAvailable()) {
            // Create an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // Set the Alert Dialog Message
            builder.setMessage("Internet Connection Required")
                    .setCancelable(false)
                    .setPositiveButton("Retry",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // Restart the Activity
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            // Locate the button in check_internet_connection.xml
            visitbtn = (Button) findViewById(R.id.visit);
            // Set the button visibility
            visitbtn.setVisibility(View.VISIBLE);
            // Capture Button click
            visitbtn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    // Recheck Network Connection
                    if (!isNetworkAvailable()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                MainActivity2.this);
                        builder.setMessage("Internet Connection Required")
                                .setCancelable(false)
                                .setPositiveButton("Retry",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int id) {
                                                visitbtn.setVisibility(View.GONE);
                                                // Restart the activity
                                                Intent intent = new Intent(
                                                        MainActivity2.this,
                                                        MainActivity2.class);
                                                finish();
                                                startActivity(intent);

                                            }

                                        });
                        AlertDialog alert = builder.create();
                        alert.show();

                    } else {
                        // Open Android Browser
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri
                                .parse("http://www.AndroidBegin.com"));
                        startActivity(intent);
                    }

                }
            });
        }
    }

    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

}