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

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

import java.math.MathContext;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button0, buttonMultiplication,
            buttonDev, buttonMinus, buttonPlus, buttonADel, buttonEqual,
            buttonDot, buttonProcent;
    private Button buttonLClip, buttonRClip, buttonPow, buttonE, buttonPi;
    private Button buttonTg, buttonLog, buttonSin, buttonCos, buttonHistory;


    private ImageButton buttonDel;

    private TextView recentActions,answer;

    private static String beforeS = "";
    private static ArrayList<String> history = new ArrayList<>();

    public ArrayList<String> getHistory() {
        return history;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

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

        answer.setText(beforeS);
        };

    public void onButtonClick(View v) {
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

                    BigDecimal calc = new Expression(beforeS, new MathContext(6)).eval();
                    answer.setText(calc.toString());
                    beforeS = "";
                } catch (Expression.ExpressionException e){
                    AlertDialog.Builder inputError = new AlertDialog.Builder(MainActivity.this);
                    inputError.setMessage("ExpressionException")
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }});

                    AlertDialog alert = inputError.create();
                    alert.setTitle("Ошибка ввода");
                    alert.show();
                } catch (Exception e){
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
                break;
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

    public void pushPrevious(View view) {
        answer.setText(recentActions.getText());
        beforeS = recentActions.getText().toString();
    }
}
