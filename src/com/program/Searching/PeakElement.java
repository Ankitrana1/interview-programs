package com.program.Searching;
/*
Given an array of integers A, find and return the peak element in it.
An array element is peak if it is NOT smaller than its neighbors.
 */
public class PeakElement {

    private static int findPeakElement(int[] arr, int low, int high){
        int mid = low + (high - low)/2;
        if(mid == 0){
            if(arr[mid] > arr[mid+1])
                return arr[mid];
        } else if(mid == arr.length-1){
            if(arr[mid] > arr[mid-1])
                return arr[mid];
        }else{
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return arr[mid];
            else
                if(arr[mid] > arr[mid-1])
                    //answer is unique that's why we can chose which side to search on.
                    return findPeakElement(arr, mid+1, high);
                else
                    return findPeakElement(arr, low, mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {5,17,100,11};
        System.out.println(findPeakElement(arr, 0 , arr.length-1));
        System.out.println(findPeakElement(arr2, 0 , arr2.length-1));
    }
}
