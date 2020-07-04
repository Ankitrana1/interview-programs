package com.program.arraysandmath;
/*
Find the missing and repeating element in the array contains(1 to n).
Could be done with O(n) space easily.
This solution is O(n) time and O(1) space.
While traversing, use the absolute value of every element as an index and make the value at this index as negative to mark it visited.
If something is already marked negative then this is the repeating element.
To find missing, traverse the array again and look for a positive value.
 */
public class MissingAndRepeatingInteger {

    private static int[] missingAndRepeatingInteger(int[] arr){
        int[] result = new int[2];
        int totalSum = 0;
        for(int value : arr){
            int absValue = Math.abs(value);
            totalSum += absValue;
            if(arr[absValue - 1] > 0){
                arr[absValue-1] = -arr[absValue-1];
            }else
                result[0] = absValue;
        }
        totalSum -= result[0];
        int sum = arr.length * (arr.length+1)/2;
        result[1] = sum - totalSum;
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,5,6},
                        {1,2,3,4,5,5},
                        {1,1,3,4,5,6},
                        {1,2,2,4,5,6},
                        {1,1}};

        int[] res = new int[2];
        for (int[] ints : matrix) {
            res = missingAndRepeatingInteger(ints);
            System.out.println("Repeating : " + res[0] + " , and Missing : " + res[1]);
        }
    }
}
