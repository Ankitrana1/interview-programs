package com.program.arraysandmath;

import java.util.Arrays;

public class MinimumHeight {

    private static int solve(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int ans = arr[n-1]-arr[0];
        int big = arr[n-1] - k;
        int small = arr[0] + k;

        if(small > big){
            int temp = small;
            small = big;
            big =temp;
        }

        int subtract = 0, add =0;

        for(int i = 1; i<n-1; i++){
            subtract = arr[i] - k;
            add = arr[i] + k;
            if(big >= add || small <= subtract)
                continue;
            if(big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }
        return Math.min(ans,big-small);
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,4};
        System.out.println(solve(arr,2));
    }
}
