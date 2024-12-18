package com.example.myfirslapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double num1 = 0;
    double num2 = 0;
    char ch;  // This stores the current operator
    TextView result;

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
        result = findViewById(R.id.textViewResult);
        result.setText("");
        ch = '\0';  // Clear the operator
    }

    // Handles number button clicks
    public void numFunction(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());  // Append the clicked number to the display
    }

    // Clears the current input and resets num1
    public void ClearResult(View view) {
        result.setText("");
        num1 = 0;  // Reset num1
        num2 = 0;  // Reset num2
        ch = '\0';  // Clear the operator

    }

    // Handles the Plus button (addition)
    public void PlusFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            num1 = Double.parseDouble(num);  // Store the first number
            result.setText("");  // Clear the display for the next number
            ch = '+';  // Set the operator to '+'
        }
    }

    // Handles the Minus button (subtraction)
    public void MinusFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            num1 = Double.parseDouble(num);  // Store the first number
            result.setText("");  // Clear the display for the next number
            ch = '-';  // Set the operator to '-'
        }
    }

    // Handles the Multiply button (multiplication)
    public void MultiplyFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            num1 = Double.parseDouble(num);  // Store the first number
            result.setText("");  // Clear the display for the next number
            ch = '*';  // Set the operator to '*'
        }
    }

    // Handles the Divide button (division)
    public void DivideFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            num1 = Double.parseDouble(num);  // Store the first number
            result.setText("");  // Clear the display for the next number
            ch = '/';  // Set the operator to '/'
        }
    }

    // Handles the Sign button (toggle sign of the number)
    public void SignFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            double currentNum = Double.parseDouble(num);
            currentNum *= -1;  // Toggle sign
            result.setText(String.valueOf(currentNum));  // Update the display
        }
    }

    // Handles the Decimal button (allows decimal numbers)
    public void DecimalFunction(View view) {
        String currentText = result.getText().toString();
        if (!currentText.contains(".")) {  // Check if there is no decimal point already
            result.append(".");  // Append a decimal point
        }
    }

    // Handles the Result button (calculates the result)
    public void ResultFunction(View view) {
        String num = result.getText().toString();
        if (num.length() > 0) {
            num2 = Double.parseDouble(num);  // Get the second number (current input)
        }

        double res = 0;
        boolean valid = true;

        // Perform the operation based on the current operator
        switch (ch) {
            case '+':
                res = num1 + num2;  // Addition
                break;

            case '-':
                res = num1 - num2;  // Subtraction
                break;

            case '*':
                res = num1 * num2;  // Multiplication
                break;

            case '/':
                if (num2 == 0) {
                    result.setText("Error");  // Handle division by zero
                    valid = false;
                } else {
                    res = num1 / num2;  // Division
                }
                break;

            default:
                valid = false;
                break;
        }

        // If the operation is valid, update the result and store it as num1
        if (valid) {
            result.setText(String.valueOf(res));  // Display the result
            num1 = res;  // Store the result for further calculations
            num2 = 0;    // Reset num2 for the next input
            ch = '\0';   // Clear the operator
        }
    }
}
