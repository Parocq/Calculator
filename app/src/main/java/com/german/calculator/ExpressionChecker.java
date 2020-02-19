package com.german.calculator;

import android.widget.TextView;

public class ExpressionChecker {

    private Preporator pr = new Preporator();
    private char[] sings = {'/','*','+','-','^','%','√'};

    public String checkForAll(String beforeS) {
        beforeS = checkDoubleSing(beforeS);
        if (beforeS==""){return beforeS;};
        beforeS = checkFirstChar(beforeS);
        return beforeS;
    }

    String checkFirstChar (String s){
        if (s.charAt(0)== '+' || s.charAt(0)== '-'){
            s= "0"+s;
        } else if (isSing(s.charAt(0))){ s="";}
        else return s;
        return s;
    }

    String checkDoubleSing (String s){
        for (int i = 0; i<s.length()-1; i++){
            if (isSing(s.charAt(i)) && isSing(s.charAt(i+1))){
                s = "";
                break;
            }
        }
        return s;
    }

    public boolean isSing (Character c){
        for (int i=0;i<sings.length;i++){
            if (c == sings[i]) return true;
        }
        return false;
    }
}
