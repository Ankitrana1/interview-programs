package com.program.arraysandmath;

public class ExcelColumnNameMapping {

    private static StringBuilder mapIntegerToExcelColumn(int columnNumber){
        StringBuilder stringBuilder = new StringBuilder();
        char c = 64;
        int div, rem;
        while(columnNumber>0){
            rem = columnNumber%26;
            c = (char) ((char) c+rem);
            stringBuilder.insert(0,c);
            columnNumber = columnNumber/26;
            c = 64;
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        System.out.println(mapIntegerToExcelColumn(980089));
        System.out.println(mapIntegerToExcelColumn(28));
    }
}
