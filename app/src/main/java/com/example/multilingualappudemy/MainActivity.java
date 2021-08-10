package com.example.multilingualappudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView helloTxt;
    Button engBtn, frBtn, araBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale(PreferenceManager.getDefaultSharedPreferences(this).getString("locale", "en"));
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        this.getResources().updateConfiguration(configuration, this.getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);

        helloTxt = findViewById(R.id.helloTxt);
        engBtn = findViewById(R.id.engBtn);
        frBtn = findViewById(R.id.frBtn);
        araBtn = findViewById(R.id.araBtn);

        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("en");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                helloTxt.setText(R.string.hello_txt);
                engBtn.setText(R.string.eng);
                frBtn.setText(R.string.fr);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "en").commit();
                //commit instantly while .apply needs some time tho both work
            }
        });

        frBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("fr");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                helloTxt.setText(R.string.hello_txt);
                engBtn.setText(R.string.eng);
                frBtn.setText(R.string.fr);
                araBtn.setText(R.string.ara);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "fr").commit();
            }
        });

        araBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ar");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                helloTxt.setText(R.string.hello_txt);
                engBtn.setText(R.string.eng);
                frBtn.setText(R.string.fr);
                araBtn.setText(R.string.ara);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "ar").commit();
            }
        });
    }
}