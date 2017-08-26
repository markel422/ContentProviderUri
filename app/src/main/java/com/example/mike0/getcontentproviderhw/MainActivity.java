package com.example.mike0.getcontentproviderhw;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri myUri = Uri.parse("content://com.example.mike0.w5d3_ex01/genre");
        ContentProviderClient myCR = getContentResolver().acquireContentProviderClient(myUri);

        Cursor cursor = null;

        try {
            cursor = myCR.query(
                    myUri,
                    null,
                    null,
                    null,
                    null
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        while (cursor.moveToNext()) {
            Log.d(TAG, "onCreate: " + cursor.getString(cursor.getColumnIndex("name")));
        }
    }
}
