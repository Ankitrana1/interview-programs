package com.program.Searching;

import java.util.Arrays;
/*
Farmer John has built a new long barn, with N stalls.
Given an array of integers A of size N where each element of the array represents the location of the stall,
and an integer B which represent the number of cows.
John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.
What is the largest minimum distance?
 */
public class MaximiseMinimalDistance {

    private static int findMinimalDistance(int[] arr, int n){
        Arrays.sort(arr);
        int min = 0, max = arr[arr.length-1];

        int mid, current=0, last=0, total;
        total = n-1;
        while(max >= min){
            //find mid based on range of numbers
            mid = (max + min)/2;
            //check if there's a way exist to assign cows to barn for current value of mid.
            for(int i=1; i<arr.length; i++){
                if(arr[i]-arr[last] >= mid) {
                    last = i;
                    total--;
                }
                if(total ==0)
                    break;
            }
            //if this all cows assigned, then check for value greater than mid and store the result.
            if(total == 0) {
                min = mid + 1;
                current = mid;
            }
            //else check for smaller value of mid
            else
                max = mid-1;
            //reset all the variables
            total = n-1;
            last=0;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1,8,4,2,9};
        System.out.println(findMinimalDistance(arr,3));
        System.out.println(findMinimalDistance(arr2,3));
    }
}
