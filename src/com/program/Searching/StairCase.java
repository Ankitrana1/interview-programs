package com.program.Searching;
/*
Given an integer A representing the number of square blocks.
The height of each square block is 1. The task is to create a staircase of max height using these blocks.
Find and return the maximum height of the staircase.
 */
public class StairCase {

    public static long maxHeight(int n, int start, int end){
        if(n == 0 || n==1)
            return n;
        long mid = (start + end)/2;
        long total = mid * (mid+1)/2;
        if(total == n)
            return mid;
        else if(total < n && (mid+1)*(mid+2)/2 > n)
            return mid;
        else if(total > n)
            return maxHeight(n,start, (int)mid -1);
        else
            return maxHeight(n,(int)mid + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(maxHeight(10,1,10)); //4
        System.out.println(maxHeight(14,1,14)); //4
        System.out.println(maxHeight(21,1,21)); //6
        System.out.println(maxHeight(1,1,0));   //1
    }
}
