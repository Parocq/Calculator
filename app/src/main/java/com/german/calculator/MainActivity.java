package com.german.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3,button4, button5, button6,
    button7, button8, button9, button0, buttonMultiplication,
    buttonDev,buttonMinus, buttonPlus, buttonADel, buttonEqual,
    buttonDot, buttonProcent;

    ImageButton buttonDel;

    TextView recentActions;
    EditText answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDev = findViewById(R.id.buttonDev);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonADel = findViewById(R.id.buttonADel);
        buttonDel = findViewById(R.id.buttonDel);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonProcent = findViewById(R.id.buttonProcent);
        buttonDot = findViewById(R.id.buttonDot);

        recentActions = findViewById(R.id.recentActions);
        answer = findViewById(R.id.answer);



        View.OnClickListener onClickListener = new View.OnClickListener() {

            String beforeS = "";

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button0:
                        answer.setText(beforeS + "0");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button1:
                        answer.setText(beforeS + "1");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button2:
                        answer.setText(beforeS + "2");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button3:
                        answer.setText(beforeS + "3");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button4:
                        answer.setText(beforeS + "4");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button5:
                        answer.setText(beforeS + "5");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button6:
                        answer.setText(beforeS + "6");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button7:
                        answer.setText(beforeS + "7");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button8:
                        answer.setText(beforeS + "8");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.button9:
                        answer.setText(beforeS + "9");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonMultiplication:
                        answer.setText(beforeS + "*");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonMinus:
                        answer.setText(beforeS + "-");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonDev:
                        answer.setText(beforeS + "/");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonPlus:
                        answer.setText(beforeS + "+");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonDot:
                        answer.setText(beforeS + ".");
                        beforeS = answer.getText().toString();
                    case R.id.buttonDel:
                        if (beforeS.length()==0){ break;}
                        answer.setText(beforeS.substring(0,beforeS.length()-1));
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonADel:
                        answer.setText("");
                        beforeS = "";
                        break;
                    case R.id.buttonProcent:
                        answer.setText(beforeS + "%");
                        beforeS = answer.getText().toString();
                        break;
                    case R.id.buttonEqual:
                        recentActions.setText(beforeS);
                        answer.setText("Тут должен быть ответ");
                        beforeS = "";
                        break;
                }

            }
        };


        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        button0.setOnClickListener(onClickListener);
        buttonMinus.setOnClickListener(onClickListener);
        buttonMultiplication.setOnClickListener(onClickListener);
        buttonPlus.setOnClickListener(onClickListener);
        buttonDev.setOnClickListener(onClickListener);
        buttonProcent.setOnClickListener(onClickListener);
        buttonEqual.setOnClickListener(onClickListener);
        buttonADel.setOnClickListener(onClickListener);
        buttonDel.setOnClickListener(onClickListener);
        buttonDot.setOnClickListener(onClickListener);

    }
}
