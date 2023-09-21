package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numberOneEditText, numberTwoEditText;
    private Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOneEditText = findViewById(R.id.int1);
        numberTwoEditText = findViewById(R.id.int2);
        addButton = findViewById(R.id.button);
        subtractButton = findViewById(R.id.button2);
        multiplyButton = findViewById(R.id.button3);
        divideButton = findViewById(R.id.button4);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('x');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('÷');
            }
        });
    }

    private void performOperation(char operation) {
        String num1 = numberOneEditText.getText().toString();
        String num2 = numberTwoEditText.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers!", Toast.LENGTH_SHORT).show();
            return;
        }

        int int1, int2;
        try {
            int1 = Integer.parseInt(num1);
            int2 = Integer.parseInt(num2);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Both numbers must be integers!", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (operation) {
            case '+':
                goToResultActivity(int1 + int2);
                break;
            case '-':
                goToResultActivity(int1 - int2);
                break;
            case 'x':
                goToResultActivity(int1 * int2);
                break;
            case '÷':
                if (int2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                } else {
                    goToResultActivity(int1 / int2);
                }
                break;
        }
    }

    private void goToResultActivity(int result) {
        Intent intent = new Intent(this, CalcResult.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
