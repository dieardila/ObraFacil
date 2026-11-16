package com.diegoardila.obrafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_confirmacion);
        ScreenInsets.apply(this);
        Intent data = getIntent();
        ((TextView) findViewById(R.id.summaryText)).setText(getString(R.string.summary,
                value(data, InscripcionActivity.NAME), value(data, InscripcionActivity.PHONE),
                value(data, InscripcionActivity.EMAIL), value(data, InscripcionActivity.SERVICE),
                getString(data.getBooleanExtra(InscripcionActivity.ACCEPTED, false)
                        ? R.string.yes : R.string.no)));
        // Cierra solamente esta Activity: el formulario anterior conserva su estado.
        findViewById(R.id.backButton).setOnClickListener(v -> finish());
        findViewById(R.id.exitButton).setOnClickListener(v -> finishAffinity());
    }

    private String value(Intent intent, String key) {
        String value = intent.getStringExtra(key);
        return value == null ? getString(R.string.missing) : value;
    }
}
