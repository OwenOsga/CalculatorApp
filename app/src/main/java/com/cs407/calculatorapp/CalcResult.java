package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalcResult extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);

        resultTextView = findViewById(R.id.textView);

        int result = getIntent().getIntExtra("result", 0);
        resultTextView.setText(String.valueOf(result));
    }
}
