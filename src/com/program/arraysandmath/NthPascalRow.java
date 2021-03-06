package com.program.arraysandmath;
/*
Given an integer n find the nth pascal row(0 indexed)
Sol : We can observe that the Nth row of the Pascals triangle consists of following sequence:
NC0, NC1, ......, NCN - 1, NCN
Since, NC0 = 1, the following values of the sequence can be generated by the following equation:
NCr = (NCr - 1 * (N - r + 1)) / r where 1 ≤ r ≤ N
 */
public class NthPascalRow {

    private static void printNthPascalRow(int n){
        int[] result = new int[n+1];
        result[0] =1;
        for(int i=1; i<result.length; i++){
            result[i] = result[i-1]*(n - i +1)/i;
        }
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printNthPascalRow(5);
        printNthPascalRow(3);
        printNthPascalRow(10);
    }
}
