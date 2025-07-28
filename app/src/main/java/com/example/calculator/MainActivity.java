package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int summa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editTextAnswer = findViewById(R.id.editTextNumber);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView incorrectAnswer = findViewById(R.id.TextViewIncorrectAnswer);
        TextView correctAnswer = findViewById(R.id.TextViewCorrectAnswer);

        getRandomAnswer();

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                int number = Integer.parseInt(text);
                if (number == summa){
                    correctAnswer.setVisibility(View.VISIBLE);
                    incorrectAnswer.setVisibility(View.GONE);
                    editTextAnswer.setText("");
                    getRandomAnswer();

                }else{
                    incorrectAnswer.setVisibility(View.VISIBLE);
                    correctAnswer.setVisibility(View.GONE);
                }


            }
        });
    }
    private void getRandomAnswer(){
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);

        summa = number1 + number2;

        TextView example = findViewById(R.id.textViewExample);
        example.setText(number1 + " + " + number2 + " = ?");
    }
}