package com.program.Searching;

import java.util.Arrays;
/*
Farmer John has built a new long barn, with N stalls.
Given an array of integers A of size N where each element of the array represents the location of the stall,
and an integer B which represent the number of cows.
 */
public class MaximiseMinimalDistance {

    private static int findMinimalDistance(int[] arr, int n){
        Arrays.sort(arr);
        int min = arr[0], max = arr[arr.length-1];

        int mid, current=0, last=0, total;
        total = n-1;
        while(max >= min){
            mid = (max + min)/2;
            for(int i=1; i<arr.length-1; i++){
                if(arr[i]-arr[last] >= mid) {
                    last = i;
                    total--;
                }
            }
            if(total == 0) {
                min = mid + 1;
                current = mid;
            }
            else
                max = mid-1;
            total = n-1;
            last=0;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,2,8};
        System.out.println(findMinimalDistance(arr,3));
    }
}
