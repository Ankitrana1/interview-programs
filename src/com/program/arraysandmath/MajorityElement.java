package com.program.arraysandmath;
/*
Majority element is that which occurs more than n/2 times.
can solve it taking HashMap but it takes O(n) space as well.

Another approach : remove any 2 distinct elements and at the end we will get the remaining element as ME.
Space complexity : O(1)
 */
public class MajorityElement {

    private static String majorityElement(int[] arr){
        int count=1, element=arr[0];
        //Use count to have occurrences of any element at a given time
        for(int i=1; i< arr.length; i++) {
            if(count == 0){
                element = arr[i];
                count++;
            }else if (element != arr[i]) {
                count--;
            } else {
                count++;
            }

        }
        int checkCount =0;
        for(int i : arr){
            if(element == i)
                checkCount++;
        }
        if(checkCount > arr.length/2)
            return Integer.toString(element);
        else
            return "No majority element found";
    }

    public static void main(String[] args) {
        int[] arr = {1,6,3,1,1,1,1,6};
        int[] arr2 = {1,2,3,4,5,5,5};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement(arr2));
    }
}
