package com.android.bushelper.activity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.app.Activitys;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.db.MyDatabaseHelper;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText oldPasswordET;
    private EditText newPasswordET;
    private Button submitBtn;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);
        oldPasswordET = (EditText)findViewById(R.id.old_password_et);
        newPasswordET = (EditText)findViewById(R.id.new_password_et);
        submitBtn = (Button)findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

        Activitys.addActivity(this);
    }

    public void resetPassword() {
        String oldPwd = oldPasswordET.getText().toString();
        String newPwd = newPasswordET.getText().toString();
        if (TextUtils.isEmpty(oldPwd)) {
            Toast.makeText(this, getResources().getString(R.string.old_password_text_hint), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(newPwd)) {
            Toast.makeText(this, getResources().getString(R.string.new_password_text_hint), Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
            try {
                String sql = "SELECT * FROM users WHERE account = ? AND password = ?";
                Cursor cursor = db.rawQuery(sql, new String[]{MyApplication.user.getAccount() + "", oldPwd});
                if (cursor.moveToFirst()) {
                    ContentValues values = new ContentValues();
                    values.put("password", newPwd);
                    db.update("users", values, "user_id = ?", new String[]{MyApplication.user.getUser_id() + ""});
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("password", newPwd);
                    editor.commit();
                    Toast.makeText(this, R.string.reset_password_success, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, R.string.old_password_error, Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitys.removeActivity(this);
    }
}
