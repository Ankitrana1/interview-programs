package com.program.backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniquePermutation {

    private static ArrayList<ArrayList<Integer>> result;

    private static void permuteUtil(int[] distinct, int[] count, int[] temp, int level){
        if(level == temp.length){
            result.add(IntStream.of(temp).boxed().collect(Collectors.toCollection(ArrayList::new)));
            return;
        }
        for(int i=0; i<distinct.length; i++){
            if(count[i] == 0)
                continue;
            count[i] -= 1;
            temp[level] = distinct[i];
            permuteUtil(distinct, count, temp, level+1);
            count[i] += 1;
        }

    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr){
        SortedMap<Integer, Integer> frequencyMap = new TreeMap<>();
        int[] distinct, count;
        result = new ArrayList<>();
        for(Integer i : arr){
            if(frequencyMap.containsKey(i))
                frequencyMap.put(i, frequencyMap.get(i)+1);
            else
                frequencyMap.put(i,1);
        }
        int index = 0;
        distinct = new int[frequencyMap.size()];
        count = new int[frequencyMap.size()];
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            distinct[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        int[] temp = new int[arr.size()];
        permuteUtil(distinct, count, temp, 0);
        return result;
    }

    private static void print(ArrayList<ArrayList<Integer>> res){
        for(ArrayList<Integer> a : res){
            for(Integer i : a)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>(Arrays.asList( 1,2,3));
        print(permute(arr));
    }
}
