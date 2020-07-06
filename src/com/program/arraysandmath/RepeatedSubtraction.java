package com.program.arraysandmath;
/*
Return the sum of 2 integers if both are equal, or any any one of them is zero.
Subtract the smaller value at each step from bigger value.
 */
public class RepeatedSubtraction {

    private static int subtractValues(int p, int q){
        if(p == 0 || q ==0 || p==q){
            return p+q;
        }else if(p > q)
            return subtractValues(p-q, q);
        else
            return subtractValues(p, q-p);
    }

    public static void main(String[] args) {
        System.out.println(subtractValues(16,7)); //2
        System.out.println(subtractValues(5,15)); //10
    }
}
