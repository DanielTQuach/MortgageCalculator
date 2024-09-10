package com.example.project1danielquach;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project1danielquach.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        binding.calBtn.setOnClickListener(this::onClick);
        binding.unBtn.setOnClickListener(this::uninstall);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.rateText.setText(String.format("Interest Rate: %.1f", i / 10.0)); // rateText change id of one of text
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // Seekbar make sure that the range is from 0 to 20
    private void onClick(View v) {
        String principle = binding.input.getText().toString();
        if (!isValid(principle)) {
            return;
        }
        double P = Double.parseDouble(principle);
        double J = binding.seekBar.getProgress() / 10.0 / 12 / 100; // Amount of ? annual rate
        int N = getMonths();
        double T = binding.checkBox.isChecked()? 0.1 / 100 * P : 0.0;
        double result = Calculator.calculate(P, J, N, T);
        binding.resultText.setText(String.format("Monthly payment: %.2f", result));
    }
    private int getMonths() {
        if (binding.r15.isChecked()) {
            return 15 * 12;
        }
        else if (binding.r20.isChecked()) {
            return 20 * 12;
        }
        else {
            return 30 * 12;
        }
    }

    private boolean isValid(String input) {
        // Make sure input is not empty and 2 decimal plaes max
        return true;
    }
    private void uninstall(View v) {

    }
}