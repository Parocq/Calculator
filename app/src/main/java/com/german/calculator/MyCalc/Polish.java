package com.german.calculator.MyCalc;

import java.util.Stack;

public class Polish {





    public String toRPN (String s){

        String str = "";
        Stack<Character> stack = new Stack<>();
        int priority = 0;

        for (int i = 0; i< s.length(); i++){
            priority = getPriority(s.charAt(i));

            if (priority == 0){ str +=s.charAt(i); continue;}
            else
            if (priority == 1){ stack.push(s.charAt(i)); continue;}
            else
            if (priority > 1){ //////////////////////////////////////////////////2 lib 3
                if (stack.empty()) {
                    stack.push(s.charAt(i));
                } else {
                    while (priority <= getPriority(stack.peek())){
                        str += stack.pop();
                        if (stack.empty()) break;
                    }stack.push(s.charAt(i));
                }
            }
            else
            if (priority == -1) {
                for (int j = 0; j < stack.size(); j++) {
                    if (stack.peek() != '(') {
                        str += stack.pop();
                    }
                }
                stack.pop();
            }
        }
        while (!stack.empty()){
            str += stack.pop();
        }
        return str;
    }

    public Double calculateRPN (String rpn){
        Stack<Double> stack = new Stack<>();

        for (int i=0;i<rpn.length();i++) {

            String countS = "";
            Double countD = 0.0;

            if (rpn.charAt(i) == ' ') continue;

            if (getPriority(rpn.charAt(i)) == 0 && rpn.charAt(i) != '.' && rpn.charAt(i) != ' ') {
                while (getPriority(rpn.charAt(i)) == 0 && rpn.charAt(i) != ' ') {//если первый символ - точка -добавь ноль перед.
                    countS += rpn.charAt(i++);
                    countD = Double.parseDouble(countS);
                }
                stack.push(countD);
            }

            if (getPriority(rpn.charAt(i)) != 0) {

                double a = stack.pop();
                double b = stack.pop();

                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }

        return stack.peek();
    }

    public int getPriority (char symb){
        if (symb == '*' || symb == '/')  return 3;
        else if (symb == '+' || symb == '-') return 2;
        else if (symb == '(') return 1;
        else if (symb == ')') return -1;
        else return 0;
    }

}
