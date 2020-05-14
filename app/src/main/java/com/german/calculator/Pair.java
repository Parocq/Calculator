package com.german.calculator;

public class Pair {

    private String exp;
    private String answer;

    public Pair(String exp, String answer) {
        this.exp = exp;
        this.answer = answer;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
