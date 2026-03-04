package com.example.v8t1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final double USD_RATE = 1.05;
    private static final double GBP_RATE = 0.83;
// testikommentti
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText euroInput = findViewById(R.id.EuroInput);
        Button usdButton = findViewById(R.id.USDButton);
        Button gbpButton = findViewById(R.id.GDPButton);
        TextView resultText = findViewById(R.id.ResultText);

        usdButton.setOnClickListener(v -> {
            Double euros = parseEuro(euroInput.getText().toString());
            if (euros == null) {
                resultText.setText("Syötä eurot");
                return;
            }
            resultText.setText(String.format("$%.2f", euros * USD_RATE));
        });

        gbpButton.setOnClickListener(v -> {
            Double euros = parseEuro(euroInput.getText().toString());
            if (euros == null) {
                resultText.setText("Syötä eurot");
                return;
            }
            resultText.setText(String.format("£%.2f", euros * GBP_RATE));
        });
    }
}