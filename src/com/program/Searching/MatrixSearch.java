package com.program.Searching;
/*
Given a matrix of integers A of size N x M and an integer B.
Integers in each row are sorted from left to right and first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
 */
public class MatrixSearch {

    private static int search(int[][] matrix, int num){
        int cols = matrix[0].length;
        int start = 0, end = matrix.length * cols;
        int mid, current;
        while(start <= end){
            mid = (start+end)/2;
            if(mid/cols > matrix.length-1)
                break;
            current = matrix[mid/cols][mid%cols];
            if(current == num)
                return 1;
            else if(current > num){
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {10,11,15,18,20},
                {21,23,24,26,30},
                {30,32,34,36,38}
        };
        int[][] m = {{22,32,67}};
        int[][] matrix2 = {{21},{26},{33},{39},{49},{97},{125}};
        //System.out.println(search(matrix2,33));
        System.out.println(search(m,90));
        System.out.println(search(matrix, 10));
        System.out.println(search(matrix, 15));
        System.out.println(search(matrix, 30));
        System.out.println(search(matrix, 33));
        System.out.println(search(matrix, 12));
    }
}
