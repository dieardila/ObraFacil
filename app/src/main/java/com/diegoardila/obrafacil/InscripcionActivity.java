package com.diegoardila.obrafacil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InscripcionActivity extends AppCompatActivity {
    static final String NAME = "registration.name";
    static final String PHONE = "registration.phone";
    static final String EMAIL = "registration.email";
    static final String SERVICE = "registration.service";
    static final String ACCEPTED = "registration.accepted";
    private EditText name, phone, email;
    private RadioGroup services;
    private CheckBox accepted;
    private TextView serviceError;

    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_inscripcion);
        ScreenInsets.apply(this);
        name = findViewById(R.id.nameInput);
        phone = findViewById(R.id.phoneInput);
        email = findViewById(R.id.emailInput);
        services = findViewById(R.id.serviceGroup);
        accepted = findViewById(R.id.acceptCheck);
        serviceError = findViewById(R.id.serviceError);
        // El estado se limita al Bundle del ciclo de vida; no hay persistencia del registro.
        if (state != null) {
            name.setText(state.getString(NAME, ""));
            phone.setText(state.getString(PHONE, ""));
            email.setText(state.getString(EMAIL, ""));
            services.check(state.getInt(SERVICE, -1));
            accepted.setChecked(state.getBoolean(ACCEPTED));
        }
        services.setOnCheckedChangeListener((group, checkedId) -> serviceError.setText(""));
        accepted.setOnCheckedChangeListener((button, checked) -> accepted.setError(null));
        findViewById(R.id.confirmButton).setOnClickListener(v -> confirm());
    }

    @Override protected void onSaveInstanceState(Bundle out) {
        out.putString(NAME, name.getText().toString());
        out.putString(PHONE, phone.getText().toString());
        out.putString(EMAIL, email.getText().toString());
        out.putInt(SERVICE, services.getCheckedRadioButtonId());
        out.putBoolean(ACCEPTED, accepted.isChecked());
        super.onSaveInstanceState(out);
    }

    private void confirm() {
        String n = name.getText().toString().trim();
        String p = phone.getText().toString().trim();
        String e = email.getText().toString().trim();
        name.setError(null);
        phone.setError(null);
        email.setError(null);
        accepted.setError(null);
        serviceError.setText("");
        android.view.View first = null;
        if (n.length() < 2 || !n.matches(".*\\p{L}.*")) {
            name.setError(getString(R.string.error_name));
            first = name;
        }
        if (!p.matches("\\+?[0-9() .-]+") || p.replaceAll("[^0-9]", "").length() < 7
                || p.replaceAll("[^0-9]", "").length() > 15) {
            phone.setError(getString(R.string.error_phone));
            if (first == null) first = phone;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            email.setError(getString(R.string.error_email));
            if (first == null) first = email;
        }
        int selected = services.getCheckedRadioButtonId();
        if (selected == -1) {
            serviceError.setText(R.string.error_service);
            if (first == null) first = findViewById(R.id.paintRadio);
        }
        if (!accepted.isChecked()) {
            accepted.setError(getString(R.string.error_accept));
            if (first == null) first = accepted;
        }
        if (first != null) {
            first.requestFocus();
            final android.view.View invalid = first;
            first.post(() -> invalid.requestRectangleOnScreen(
                    new android.graphics.Rect(0, 0, invalid.getWidth(), invalid.getHeight()), false));
            return;
        }
        RadioButton service = findViewById(selected);
        Intent intent = new Intent(this, ConfirmacionActivity.class);
        intent.putExtra(NAME, n);
        intent.putExtra(PHONE, p);
        intent.putExtra(EMAIL, e);
        intent.putExtra(SERVICE, service.getText().toString());
        intent.putExtra(ACCEPTED, accepted.isChecked());
        startActivity(intent);
    }
}
