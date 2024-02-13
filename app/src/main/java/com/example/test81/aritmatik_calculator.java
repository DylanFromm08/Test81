package com.example.test81;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

 public class aritmatik_calculator extends AppCompatActivity {

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Spinner operatorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_layout);

        firstNumberEditText = findViewById(R.id.First_number);
        secondNumberEditText = findViewById(R.id.second_number);
        operatorSpinner = findViewById(R.id.Spinner_spinner);

        // Populate the spinner with the operator options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operatorSpinner.setAdapter(adapter);
    }

    public void calculate(View view) {
        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();

        if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double firstNumber = Double.parseDouble(firstNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);

        String selectedOperator = operatorSpinner.getSelectedItem().toString();

        double result = 0.0;
        switch (selectedOperator) {
            case "tambah":
                result = firstNumber + secondNumber;
                break;
            case "kurang":
                result = firstNumber - secondNumber;
                break;
            case "kali":
                result = firstNumber * secondNumber;
                break;
            case "bagi":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }


        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("Result: %.2f", result));

    }
}
