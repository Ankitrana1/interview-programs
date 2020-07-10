package com.program.Searching;
/*
Given a sorted array of integers A of size N and an integer B.
Array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

Sol : Idea is to find the pivot where the array is rotated.
And apply Binary Search on A[0 to pivot] and A[pivot+1 to array.length]

 */
public class RotatedSortedArraySearch {

    private static int num;

    private static int findPivot(int[] arr, int low, int high){
        int length = arr.length-1;
        int mid = low + (high-low)/2;
        //if pivot not found then return -1
        if (low == 0 && high == 0)
            return -1;
        //To find the pivot make decision based on last element of the array.
        //As every sorted array has the highest element at the end.
        if(arr[mid] > arr[length] && arr[mid] > arr[mid+1])
            return mid;
        else if(arr[mid] < arr[length])
            return findPivot(arr, low, mid-1);
        else
            return findPivot(arr, mid+1, high);
    }

    //Simple method to search for the element
    private static int findElement(int[] arr, int low, int high){
        int mid = low + (high-low)/2;
        if(arr[mid] == num)
            return mid;
        else if(low == high)
            return -1;
        else if(arr[mid] > num)
            return findElement(arr,low,mid-1);
        else
            return findElement(arr, mid+1, high);
    }

    private static int rotatedArraySearch(int[] arr, int element){
        num = element;
        int index = -1;
        int pivot = findPivot(arr, 0, arr.length-1);
        //Based on pivot value find the index
        if(pivot == -1)
            index = findElement(arr,0, arr.length-1);
        else {
            //if element not  found in part A[0 to pivot] then search in A[pivot+1 to length-1]
            index = findElement(arr, 0, pivot);
            if(index == -1)
                index = findElement(arr, pivot+1,arr.length-1);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20,30,1,3,5,7,9};
        int[] arr2 = { 1,2,3,4,5,6,7,8};
        System.out.println("Index : "+rotatedArraySearch(arr, 9));
        System.out.println("Index : "+rotatedArraySearch(arr, 3));
        System.out.println("Index : "+rotatedArraySearch(arr, 10));
        System.out.println("Index : "+rotatedArraySearch(arr2, 18));
        System.out.println("Index : "+rotatedArraySearch(arr2, 2));
    }
}
