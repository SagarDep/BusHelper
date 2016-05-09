package com.android.bushelper.activity;

import android.content.ContentValues;
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
import com.android.bushelper.db.MyDatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText accountET;
    private EditText nicknameET;
    private EditText passwordET;
    private EditText repasswordET;
    private Button registerBtn;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        accountET = (EditText)findViewById(R.id.user_account);
        nicknameET = (EditText)findViewById(R.id.user_nickname);
        passwordET = (EditText)findViewById(R.id.user_password);
        repasswordET = (EditText)findViewById(R.id.user_re_password);
        registerBtn = (Button)findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });
        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);
    }

    public void userRegister() {
        String account = accountET.getText().toString();
        String nickname = nicknameET.getText().toString();
        String password = passwordET.getText().toString();
        String repassword = repasswordET.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, R.string.user_account_hint, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(nickname)) {
            Toast.makeText(this, R.string.user_nickname_hint, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.user_password_hint, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(repassword)) {
            Toast.makeText(this, R.string.user_re_password_hint, Toast.LENGTH_SHORT).show();
        } else if (!repassword.equals(password)) {
            Toast.makeText(this, R.string.re_password_error, Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
            try {
                String sql = "SELECT * FROM users WHERE account = ?";
                Cursor cursor = db.rawQuery(sql, new String[]{account});
                if(cursor.moveToFirst()){
                    Toast.makeText(this, R.string.re_account_exist, Toast.LENGTH_SHORT).show();
                    accountET.setText("");
                    accountET.requestFocus();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("account", account);
                    values.put("nickname", nickname);
                    values.put("password", password);
                    db.insert("users", null, values);
                    Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show();
                    finish();
                }
                cursor.close();
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
