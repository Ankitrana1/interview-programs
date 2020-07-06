package com.program.arraysandmath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given : an array of gcd of all possible  pair combinations(including pair of itself. Ex : (A1,A1)).
From the array deduce the elements of original array.
Solution Observation : Every pair comes twice except pairs of itself.
After removing all double occurring pairs, only pair of element with itself remains.
Also the resultant array size will be  : n^(1/2).
 */
public class FindArrayFromGCDArrayOfPairs {

    private static int[] findArrayFromGCDPairs(int[] gcdPairs){
        int[] result = new int[(int)Math.sqrt(gcdPairs.length)];
        Map<Integer,Integer> frequencies = new HashMap<>();
        for(int value : gcdPairs){
            if(frequencies.containsKey(value))
                frequencies.put(value, frequencies.get(value) + 1);
            else
                frequencies.put(value, 1);
        }

        int index = 0;
        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()){
            if(entry.getValue() %2 != 0)
                result[index++] = entry.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,8,2,2,4,4,2,6};
        System.out.println(Arrays.toString(findArrayFromGCDPairs(arr)));
    }
}
