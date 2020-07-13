package com.program.Searching;

public class FindStartAndLastIndex {

    private static int[] findIndices(int[] arr, int num){
        int[] res = {-1,-1};
        int start = 0, end = arr.length-1, mid;
        while(start <= end){
            mid = (start + end)/2;
            if(num == arr[mid]){
                res[0] = mid;
                res[1] = mid;
                if(mid != arr.length-1 && num == arr[mid+1]) {
                    for (int i = mid+1,j=arr.length-1; i<=j;){
                        int t = (i + j)/2;
                        if(arr[t] == num){
                            res[1] = t;
                            i = t+1;
                        }
                        else
                            j=t-1;
                    }
                }
                if(mid != 0 && num == arr[mid-1]) {
                    for (int i = 0,j=mid-1; i<=j;){
                        int t = (i + j)/2;
                        if(arr[t] == num) {
                            res[0] = t;
                            j = t-1;
                        }
                        else
                            i=t+1;
                    }
                }
                return res;
            }
            else if(num < arr[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,9};
        int[] arr2 = {7,7,7,7,7,7};
        int[] arr3 = {6,6,7,7,7,8,8,9,9};
        int[] res = findIndices(arr,8);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        res = findIndices(arr,5);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        res = findIndices(arr,6);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        res = findIndices(arr2,7);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        res = findIndices(arr3,6);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        res = findIndices(arr3,9);
        System.out.println("First Index : "+ res[0] + " and Last Index : "+ res[1]);
        /*  Output :
            First Index : 3 and Last Index : 4
            First Index : 0 and Last Index : 0
            First Index : -1 and Last Index : -1
            First Index : 0 and Last Index : 5
            First Index : 0 and Last Index : 1
            First Index : 7 and Last Index : 8
         */
    }
}
