package com.program.arraysandmath;

public class MaximiseGCDByOneDeletion {

    private static int gcd(int a, int b){
        if (a==0)
            return b;
        return gcd(b%a, a);
    }

    private static int maximiseGCD(int[] arr){
        int result = Integer.MIN_VALUE;
        int length = arr.length;
        int[] prefixGCD = new int[length];
        int[] suffixGCD = new int[length];

        prefixGCD[0] = arr[0];
        suffixGCD[length-1] = arr[length-1];

        for(int i= 1; i<length; i++){
            prefixGCD[i] = gcd(arr[i], prefixGCD[i-1]);
            suffixGCD[length-1-i] = gcd(arr[length-1-i], suffixGCD[length-i]);
        }

        int gcdValue;
        for(int i= 0; i<length; i++){
            if(i == 0)
                gcdValue = suffixGCD[i+1];
            else if( i==length-1)
                gcdValue = prefixGCD[i-1];
            else
                gcdValue = gcd(prefixGCD[i-1], suffixGCD[i+1]);
            if(result < gcdValue)
                result = gcdValue;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {49,6,25};
        System.out.println(maximiseGCD(arr));
    }
}
