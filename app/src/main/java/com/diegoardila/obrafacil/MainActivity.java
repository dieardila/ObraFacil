package com.diegoardila.obrafacil;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        ScreenInsets.apply(this);
        findViewById(R.id.startButton).setOnClickListener(v ->
                startActivity(new Intent(this, InscripcionActivity.class)));
    }
}
