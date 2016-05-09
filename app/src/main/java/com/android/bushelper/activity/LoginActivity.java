package com.android.bushelper.activity;

import android.content.Intent;
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
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.bean.UserBean;
import com.android.bushelper.db.MyDatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText accountET;
    private EditText passwordET;
    private Button loginBtn;
    private Button registerBtn;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountET = (EditText)findViewById(R.id.user_account);
        passwordET = (EditText)findViewById(R.id.user_password);
        loginBtn = (Button)findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
        registerBtn = (Button)findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);
    }

    public void userLogin() {
        String account = accountET.getText().toString();
        String password = passwordET.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, R.string.user_account_hint, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.user_password_hint, Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
            try {
                String sql = "SELECT * FROM users WHERE account = ? AND password = ?";
                Cursor cursor = db.rawQuery(sql, new String[]{account, password});
                if(cursor.moveToFirst()){
                    UserBean userBean = new UserBean();
                    userBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                    userBean.setAccount(cursor.getString(cursor.getColumnIndex("account")));
                    userBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                    MyApplication.setUser(userBean);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
