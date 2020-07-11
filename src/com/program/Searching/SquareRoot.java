package com.program.Searching;
/*
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
 */
public class SquareRoot {

    private static int findRoot(int num, long start, long end){
        long mid = (start + end)/2;
        if(mid*mid == num)
            return (int)mid;
        else if(mid*mid < num && (mid+1)*(mid+1) > num)
            return (int)mid;
        else if(mid*mid > num)
            return findRoot(num, start, mid-1);
        else
            return findRoot(num, mid+1, end);
    }

    private static int findSquareRoot(int num){
        int res = -1;
        if(num == 0 || num == 1)
            return num;
        for(long i=1; i<=num; i*=2){
            if(i*i > num) {
                res = findRoot(num, i/2, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(625));
        System.out.println(findSquareRoot(50));
        System.out.println(findSquareRoot(4));
        System.out.println(findSquareRoot(2147483647));
    }
}
