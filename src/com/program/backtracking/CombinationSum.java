package com.program.backtracking;

import java.util.*;

public class CombinationSum {

    static SortedMap<Integer, Integer> frequencyMap= new TreeMap<>();
    static int target;

    private static void printUniqueCombination(int[] arr, int targetSum){
        target = targetSum;
        for(int value : arr){
            if(frequencyMap.containsKey(value))
                frequencyMap.put(value, frequencyMap.get(value)+1);
            else
                frequencyMap.put(value, 1);
        }
        int[] distinct = new int[frequencyMap.size()];
        int index=0;
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            distinct[index++] = entry.getKey();
        }
        findUniqueSubsets(distinct, new ArrayList<>(),0,0);
    }
    private static void findUniqueSubsets(int[] distinct, List<Integer> list, int sum, int index){
        if(target == sum){
            print(list);
            return;
        }
        else if(index == distinct.length || target < sum)
            return;
        for (int i =0; i< frequencyMap.get(distinct[index]); i++){
            sum += distinct[index];
            list.add(distinct[index]);
            findUniqueSubsets(distinct, list, sum, index+1);
        }
        for (int i =0; i< frequencyMap.get(distinct[index]); i++){
            sum -= distinct[index];
            list.remove(new Integer(distinct[index]));
        }
        findUniqueSubsets(distinct, list, sum, index+1);
    }

    private static void print(List<Integer> list){
        for(Integer a : list){
            System.out.print(a+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr2 = {1,2,3,2,1,1};
        printUniqueCombination(arr2,5);
    }
}
