package com.example.week8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText textInputFirstNumber;
    private EditText textInputSecondNumber;
    private TextView textNumber1;
    private TextView textNumber2;
    private TextView textResult;

    public void add(View view){

       operation(view,"+");
    }

    public void substract(View view){

        operation(view,"-");
    }

    public void multiplication(View view){

        operation(view,"*");
    }

    public void division(View view){

        operation(view,"/");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSubstract), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textNumber1 = findViewById(R.id.textNumber1);
        textNumber2 = findViewById(R.id.textNumber2);
        textResult = findViewById(R.id.textResult);
        textInputFirstNumber = findViewById(R.id.textInputFirstNumber);
        textInputSecondNumber = findViewById(R.id.textInputSecondNumber);
    }

    public void operation(View view,String action){

        String s1 = textInputFirstNumber.getText().toString();
        String s2 = textInputSecondNumber.getText().toString();


        if(s1.isEmpty() || s2.isEmpty()){
            textResult.setText("Note! Inputs can not be empty.");

        }else{
            float num1 = Float.parseFloat(s1);
            float num2 = Float.parseFloat(s2);
            DecimalFormat df = new DecimalFormat("#.##");

            switch(action){

                case "+":
                    textResult.setText("Result: "+ df.format(num1+num2));
                    break;

                case "-":
                    textResult.setText("Result: "+ df.format(num1-num2));
                    break;

                case "/":
                    if(num2 == 0){
                        textResult.setText("Note! Divisor cannot be zero.");
                    }else {
                        textResult.setText("Result: "+ df.format(num1/num2));
                    }
                    break;

                case "*":
                    textResult.setText("Result: "+ df.format(num1*num2));
                    break;
            }
        }
    }
}

