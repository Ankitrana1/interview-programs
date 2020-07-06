package com.program.arraysandmath;

import java.util.HashSet;
import java.util.Set;
/*
Find the number of sub sequences of array having distinct GCD.
 */
public class DistinctGCDSubsequences {

    private static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }

    private static int distinctGCDSubsequences(int[] arr){
        Set<Integer> result = new HashSet<>();
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                result.add(gcd(arr[i], arr[j]));
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {3,8,2};
        int[] arr2 = {5,7,11,3};
        System.out.println(distinctGCDSubsequences(arr1));
        System.out.println(distinctGCDSubsequences(arr2));
    }
}
