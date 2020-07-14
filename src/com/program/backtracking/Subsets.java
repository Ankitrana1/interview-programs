package com.program.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Print all the 2^n subsets of given array  using recursion
 */
public class Subsets {

    private static void printSubsets(int[] arr){
        List<Integer> list = new ArrayList<>();
        getAllSubsets(arr, list, 0);
    }

    private static void getAllSubsets(int[] arr, List<Integer> list, int index){
        if(index == arr.length)
            print(list);
        else{
            list.add(arr[index]);
            getAllSubsets(arr, list,index+1);
            list.remove(new Integer(arr[index]));
            getAllSubsets(arr, list, index+1);
        }
    }

    private static void print(List<Integer> list){
        for(Integer a : list){
            System.out.print(a+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubsets(arr);
    }
}
