package com.example.love.jundao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText edt1;
    private EditText edt2;
    private CheckBox rad1;
    private CheckBox rad2;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText3);
        rad1 = (CheckBox) findViewById(R.id.radio1);
        rad2 = (CheckBox) findViewById(R.id.radio2);

        boolean isRem = pref.getBoolean("rem_pass", false);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acount = edt1.getText().toString();
                String password = edt2.getText().toString();
                if (acount.equals("15212134") && password.equals("15212134")) {
                    editor = pref.edit();
                    if (rad1.isChecked() && (!rad2.isChecked())) {
                        editor.putBoolean("rem_pass", true);
                        editor.putString("account", acount);
                        editor.putString("password", password);
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else if (rad2.isChecked()) {
                        Toast.makeText(MainActivity.this, "请找回密码", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "账户不对，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "内测阶段，暂未开放！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}