package com.german.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.german.calculator.MyCalc.ExpressionChecker;
import com.german.calculator.MyCalc.Polish;
import com.german.calculator.MyCalc.Preporator;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button0, buttonMultiplication,
            buttonDev, buttonMinus, buttonPlus, buttonADel, buttonEqual,
            buttonDot, buttonProcent;

    View.OnClickListener onClickListener;

    ImageButton buttonDel;

    TextView recentActions,answer;

    static String beforeS = "";
    private static ArrayList<String> history = new ArrayList<>();

    public ArrayList<String> getHistory() {
        return history;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        final Preporator preporator = new Preporator();
        final Polish polish = new Polish();
        final ExpressionChecker exCheck = new ExpressionChecker();

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


        onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                switch (v.getId()) {
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
                        break;
                    case R.id.buttonDel:
                        if (beforeS.length() == 0) {
                            break;
                        }
                        answer.setText(beforeS.substring(0, beforeS.length() - 1));
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
                        if (beforeS == ""){

                        }else try {
                        recentActions.setText(beforeS);
                        history.add(beforeS);
                        beforeS = "";

                        BigDecimal calc;
                        calc = new Expression(beforeS).eval();
                        answer.setText(calc.toString());
                    } catch (Exception ex){
//                            answer.setText("Произошла ошибка: недопустимое выражение");
                        AlertDialog.Builder inputError = new AlertDialog.Builder(MainActivity.this);
                        inputError.setMessage("Было введено необрабатываемое выражение, проверьте правильность ввода.")
                                .setCancelable(false)
                                .setNegativeButton("ОК",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }});

                        AlertDialog alert = inputError.create();
                        alert.setTitle("Ошибка ввода");
                        alert.show();
                    }





//                        if (beforeS == ""){
//                            answer.setText("???");
//                        } else {
//                            beforeS = exCheck.checkForAll(beforeS);
//                        }
//                        if (beforeS == ""){
//                            answer.setText("???");
//                        } else {
////                        String solution = preporator.getAnswer(beforeS);
////                        answer.setText(solution);
//
//                            beforeS = preporator.acceptProcents(beforeS);
//
//                            beforeS = preporator.addSpaces(beforeS);
//                            beforeS = polish.toRPN(beforeS);
//                            double solutionD = polish.calculateRPN(beforeS);
//                            String solutionS = Double.toString(solutionD);
//                            answer.setText(solutionS);
//                            beforeS = "";
//                        }

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

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Button buttonLClip, buttonRClip, buttonPow, buttonE, buttonPi;
            Button buttonTg, buttonLog, buttonSin, buttonCos, buttonHistory;


            buttonLClip = findViewById(R.id.buttonLClip);
            buttonRClip = findViewById(R.id.buttonRClip);
            buttonPow = findViewById(R.id.buttonPow);
            buttonE = findViewById(R.id.buttonE);
            buttonPi = findViewById(R.id.buttonPi);
            buttonTg = findViewById(R.id.buttonTg);
            buttonLog = findViewById(R.id.buttonLog);
            buttonSin = findViewById(R.id.buttonSin);
            buttonCos = findViewById(R.id.buttonCos);
            buttonHistory = findViewById(R.id.buttonHistory);

            onClickListener = new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.buttonLClip:
                            answer.setText(beforeS + "(");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonRClip:
                            answer.setText(beforeS + ")");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonPow:
                            answer.setText(beforeS + "^");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonE:
                            answer.setText(beforeS + "e");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonPi:
                            answer.setText(beforeS + "pi");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonTg:
                            answer.setText(beforeS + "tan(");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonLog:
                            answer.setText(beforeS + "log(");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonSin:
                            answer.setText(beforeS + "sin(");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonCos:
                            answer.setText(beforeS + "cos(");
                            beforeS = answer.getText().toString();
                            break;
                        case R.id.buttonHistory:
                            Intent intent = new Intent(MainActivity.this, history.class);
                            startActivity(intent);
                            break;
                    }



                }
            };

            buttonLClip.setOnClickListener(onClickListener);
            buttonRClip.setOnClickListener(onClickListener);
            buttonPow.setOnClickListener(onClickListener);
            buttonE.setOnClickListener(onClickListener);
            buttonPi.setOnClickListener(onClickListener);

            buttonTg.setOnClickListener(onClickListener);
            buttonLog.setOnClickListener(onClickListener);
            buttonSin.setOnClickListener(onClickListener);
            buttonCos.setOnClickListener(onClickListener);
            buttonHistory.setOnClickListener(onClickListener);
        }
    }
}
