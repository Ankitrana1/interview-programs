package com.program.arraysandmath;

import javax.swing.*;

/*
Find the first missing positive integer in the array
Make sure to run your code with provided edge cases in main method and
compare outputs given at the end of each print statement.
 */
public class MissingPositiveInteger {

    private static int missingInteger(int[] arr){
        int length = arr.length;
        int count = 0;
        for(int value : arr){
            if(value>0 && value<=length)
                count++;
        }
        if(count == 0)
            return 1;
        int[] consecutiveArray = new int[count];
        for(int value : arr){
            if(value > 0 && value <= count)
                consecutiveArray[value-1] = value;
        }
        for(int i=0; i<count; i++){
            if(consecutiveArray[i] == 0)
                return i+1;
        }
        return consecutiveArray.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {1};
        int[] arr3 = {-1,-2,-3,1,2,6,9};
        int[] arr4 = {-1,-2,-3,-4,-5,-6,-7,-8,-9};
        int[] arr5 = {-10,-9,-6,7,8,9};
        int[] arr6 = {6};
        System.out.println(missingInteger(arr));    //10
        System.out.println(missingInteger(arr2));   //2
        System.out.println(missingInteger(arr3));   //3
        System.out.println(missingInteger(arr4));   //1
        System.out.println(missingInteger(arr5));   //1
        System.out.println(missingInteger(arr6));   //1
    }
}


