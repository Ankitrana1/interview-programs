package com.program.arraysandmath;

/*
An array contains 0 and 1. Find the longest sub-array length after swapping one 0(only one time).
Brute force solution can be O(n^2). : find every 0 and traverse both side of it to find max length of continuous ones.
This solution is O(n) and space is also O(n)
 */
public class LongestSubArrayAfterSwap {

    private static int longestLength(int[] arr){
        int totalOnes = 0, count=0, maxLength = -1;
        int[] leftContinuousOnes = new int[arr.length];
        int[] rightContinuousOnes = new int[arr.length];

        //find the total number of one and populate left and right continuous arrays
        for(int i=0; i< arr.length; i++){
            if(arr[i] == 1) {
                totalOnes++;
                leftContinuousOnes[i] = ++count;
            }else{
                count = 0;
                leftContinuousOnes[i] = count;
            }
        }
        count = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == 1) {
                rightContinuousOnes[i] = ++count;
            }else{
                count = 0;
                rightContinuousOnes[i] = count;
            }
        }
       for(int i=0; i<arr.length; i++){
           if(arr[i] == 0) {
               if (i == 0) {                //Cover corner case
                   if (maxLength < rightContinuousOnes[i+1]) {
                       if (rightContinuousOnes[i + 1] > totalOnes)
                           maxLength = rightContinuousOnes[i + 1] + 1;
                       else
                           maxLength = rightContinuousOnes[i + 1];
                   }
               } else if (i == arr.length - 1) {            //Cover corner case
                   if(maxLength < leftContinuousOnes[i-1]) {
                       if (leftContinuousOnes[i - 1] > totalOnes)
                           maxLength = leftContinuousOnes[i - 1] + 1;
                       else
                           maxLength = leftContinuousOnes[i - 1];
                   }
               } else {
                   int length = leftContinuousOnes[i - 1] + rightContinuousOnes[i + 1];
                   if(maxLength < length) {
                       if (length < totalOnes)
                           maxLength =  length + 1;
                       else
                           maxLength = length;
                   }
               }
           }
       }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,0,1,0,1,0,0,1};
        System.out.println(longestLength(arr));
    }
}
