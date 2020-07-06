package com.program.arraysandmath;
//Euclidean method to find GCD of 2 numbers.
public class GCD {
    private static int gcd(int a, int b){
        if (a==0)
            return b;
        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        System.out.println(gcd(20,0));
        System.out.println(gcd(0, 20));
        System.out.println(gcd(13,29));
        System.out.println(gcd(16,12));
        System.out.println(gcd(12,16));
        System.out.println(gcd(1,1));
    }
}
