package com.german.calculator;

public class Preporator {

    Polish polish = new Polish();

    public String getAnswer (String s){

        preparation(s);


        return s;
    }

    int calculateFactorial(double n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }

    public  String preparation (String s) {
        String substring = null;
        String number = null;
        boolean flag;
        double answer =0;

        for (int i = 0; i<s.length();i++){
            switch (s.charAt(i)){
                case '!':
                    if (s.charAt(i-1) == ')'){
                        substring = detectStatementBefore(s,i-1);
                    } else {
                        number = detectNumberBefore(s,i-1);

                        answer = calculateFactorial(Double.parseDouble(number));

                    }
                    break;
                case '^':
                    if (s.charAt(i-1) == ')'){
                        substring = detectStatementBefore(s,i-1);
                    } else {
                        number = detectNumberBefore(s,i-1);
                    }
                    ///////////////////////////// выражение после
                    break;
                case 'c'://////////////////////////////////cos ctg
                case 's':
                    if (s.charAt(i+3) == '('){
                        substring = detectStatementAfter(s,i+3);
                    } else {
                        number = detectNumberAfter(s,i+3);
                    }
                    break;
                case 't':
                    if (s.charAt(i+2) == '('){
                        substring = detectStatementAfter(s,i+2);
                    } else {
                        number = detectNumberAfter(s,i+2);
                    }
                    break;
                case '√':
                    if (s.charAt(i+1) == '('){
                        substring = detectStatementAfter(s,i+1);
                    } else {
                        number = detectNumberAfter(s,i+1);
                    }
                    break;




                    default:flag = true;
                    break;
            }
        }
        return s;
    }



    public boolean isANumber (Character c){
        for (int i =0;i<10;i++){
            if (c == i || c == '.') return true;
        }
        return false;
    }

    public boolean isATrigonometric (Character c){
        if (c=='c'||c=='o'||c=='s'||c=='s'||c=='i'||c=='n'||c=='t'||c=='g'||c=='('||c==')'){
            return true;
        }
        else return false;
    }



    public String detectNumberAfter (String s, int start) {
        String numberS = null;

        for (int i = start; i < s.length(); i++) {
            if (!isANumber(s.charAt(i))) {

                numberS = s.substring(start, i-1);
            }
        }
        return numberS;
    }

    public String detectStatementAfter(String s, int start){
        int end;
        String substring = null;
        for (int i=start;i<s.length();i++){
            if (s.charAt(i) == ')'){
                end = i;
                substring = s.substring(start,end);
                break;
            }
        }
        return substring;
    }

        public String detectNumberBefore (String s, int end){
        String numberS = null;

        for (int i=end;i<s.length();i--){
            if (!isANumber(s.charAt(i))){

                numberS = s.substring(i+1,end);
            }
        }
        return numberS;
    }

    public String detectStatementBefore(String s, int end){
        int start;
        String substring = null;
        for (int i=end;i<s.length();i--){
            if (s.charAt(i) == '('){
                start = i;
                substring = s.substring(start,end);
                break;
            }
        }
        return substring;
    }


    public String addSpaces (String s){
        String newStr = "";
        for (int i = 0; i<s.length(); i++){
            if (polish.getPriority(s.charAt(i)) != 0){
                newStr = newStr + " " + s.charAt(i);
            } else newStr += s.charAt(i);
        }
        return newStr;
    }

    public static String acceptProcents (String s){
        s.replace("%","/100");
        return s;
    }
}
