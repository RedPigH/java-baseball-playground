package study.step1;

import java.util.Scanner;

public class StringCalculator {
    static String operation = "+-*/";

    public static void main(String[] args) {
        StringCalculator strcal = new StringCalculator();
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        System.out.println(strcal.CalResult(value));
    }

    boolean StringCheck(String value) {
        value = value.trim();
        if (value.length() == 0 || value == null) {
            return false;
        }
        return true;
    }

    boolean OpCheck(String op){
        if(operation.contains(op) || digitCheck(op)) return true;
        return false;
    }

    boolean digitCheck(String str){
        if(str.matches("[0-9]+")) return true;
        return false;
    }

    String[] split(String value) {
        return value.split(" ");
    }

    int StrToInt(String value){
        return Integer.parseInt(value);
    }

    int CalResult(String value) {
        if(!StringCheck(value)){
            throw new RuntimeException("not valid value for calculation");
        }
        return getResult(value);
    }

    private int getResult(String value){
        String[] token = split(value);
        int result = StrToInt(token[0]);

        for(int i = 1 ; i <= token.length - 2; i += 2){
            result = calculation(result, token[i], token[i+1]);
        }
        return result;
    }

    private int calculation(int result, String op, String token) {
        if(OpCheck(op)) throw new RuntimeException("unsupported operator");
        if(digitCheck(token)) throw new NumberFormatException("non-numeric string");

        int num = StrToInt(token);

        if(op.equals("+")) result = add(result,num);
        if(op.equals("-")) result = subtract(result,num);
        if(op.equals("*")) result = multiply(result,num);
        if(op.equals("/")) result = divide(result,num);
        return result;
    }

    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        if(j == 0) throw new ArithmeticException("not divide zero");
        return i / j;
    }
}
