package com.program.arraysandmath;
/*
Scooby has 3 three integers A, B and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
You need to tell number of special integers less than or equal to A.
 */
public class DivisorGame {

    private static int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a, a);
    }

    private static int divisorGame(int a, int b, int c){
        int factor  = gcd(b,c);
        if(factor > 1){
            b = b/factor;
            c = c/factor;
        }
        return a/(b*c);
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(100, 5, 3));
        System.out.println(divisorGame(12, 2, 3));
        System.out.println(divisorGame(6, 1, 4));
    }
}
