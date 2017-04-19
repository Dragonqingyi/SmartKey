package com.example.love.jundao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private RadioButton rad3;
    private RadioButton rad4;
    private Button adk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rad3 = (RadioButton) findViewById(R.id.rad3);
        rad4 = (RadioButton) findViewById(R.id.rad4);
        adk = (Button) findViewById(R.id.addkey);
        rad3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rad3.isChecked()){
                    Toast.makeText(Main2Activity.this,"您选择蓝牙连接钥匙",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this,"您选择WIFI连接钥匙",Toast.LENGTH_SHORT).show();
                }
            }
        });
        adk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"添加钥匙",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
