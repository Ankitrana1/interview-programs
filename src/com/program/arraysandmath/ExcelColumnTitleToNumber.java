package com.program.arraysandmath;

public class ExcelColumnTitleToNumber {

    private static int titleToNumber(String title){
        int result =0;
        int power = title.length()-1;
        for(char c : title.toCharArray()){
            result += (c-64)*(int)Math.pow(26, power--);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BCSUS"));
        System.out.println(titleToNumber("AB"));
    }
}
