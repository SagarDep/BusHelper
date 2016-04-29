package com.android.bushelper;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.android.bushelper.bean.UserBean;

import org.xutils.x;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyApplication extends Application {

    public static final String DB_NAME = "bus_helper.db";
    public static final String DB_PATH = "/data/data/com.android.bushelper/databases";
    public static SQLiteDatabase db;

    public static String City = "南京";

    public static UserBean user;

    @Override
    public void onCreate() {
        super.onCreate();
        getDB();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

    public void getDB() {
        String databaseFilename = DB_PATH + "/" + DB_NAME;
        File dir = new File(DB_PATH);
        if (!dir.exists())
            dir.mkdir();
        if (!(new File(databaseFilename)).exists()) {
            InputStream is = getResources().openRawResource(R.raw.bus_helper);
            try {
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[8192];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        db = SQLiteDatabase.openOrCreateDatabase(databaseFilename, null);
    }

    public static void setCity(String city) {
        City = city;
    }

    public static void setUser(UserBean user) {
        MyApplication.user = user;
    }
}
