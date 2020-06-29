package com.program.arraysandmath;
/*
A continuation of Majority Element problem
But the difference is any number occurring more than n/3 times.
Similar approach should be followed. Here instead we will keep track of 2 numbers at the same time.
As soon as new distinct number comes, we will delete all three elements
 */
public class MajorityElement2 {
    private static String majorityElement(int[] arr){
        String result;
        int count1=0, count2=0, element1 = Integer.MAX_VALUE, element2=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(element1 == arr[i])
                count1++;
            else if(element2 == arr[i])
                count2++;
            else if(count1 == 0) {
                element1 = arr[i];
                count1++;
            } else if(count2 == 0){
                element2 = arr[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i : arr){
            if(i == element1)
                count1++;
            else if(i == element2)
                count2++;
        }
        if(count1 > arr.length/3)
            result = Integer.toString(element1);
        else if(count2 > arr.length/3)
            result = Integer.toString(element2);
        else
            result = "No Majority Element Found";

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,5,5,6,5,8};
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,4,6,7,5,5,5};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement(arr1));
        System.out.println(majorityElement(arr2));
    }
}
