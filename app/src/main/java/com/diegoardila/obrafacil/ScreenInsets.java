package com.diegoardila.obrafacil;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/** Aplica barras, recortes y teclado sin acumular padding. */
final class ScreenInsets {
    private ScreenInsets() {}
    static void apply(AppCompatActivity activity) {
        WindowCompat.enableEdgeToEdge(activity.getWindow());
        View root = activity.findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, windowInsets) -> {
            Insets safe = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
            view.setPadding(safe.left, safe.top, safe.right, safe.bottom);
            return windowInsets;
        });
        ViewCompat.requestApplyInsets(root);
    }
}
