package com.example.androiddynamicversion;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        //button.setOnClickListener((View.OnClickListener) this);
    }

    public void BtnOne(View view) {
        try {
            
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            int versionCode = pInfo.versionCode;
            Log.d("MyApp", "Version Name : " + version + "\n Version Code : " + versionCode);
            TextView VerionTextView = (TextView)findViewById(R.id.VerionTextView);
            VerionTextView.setText("Version Name : " + version + "\n Version Code : " + versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.d("MyApp", "PackageManager Catch : " + e.toString());
        }

    }
}
