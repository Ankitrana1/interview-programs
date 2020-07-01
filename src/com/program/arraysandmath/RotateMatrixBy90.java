package com.program.arraysandmath;

/*Hint : Just assign values using index like
        {a[0][1] =a[2][0],
         a[2][0] = a[3][2],
         a[3][2] = a[0][3]}
And try to map these indices with the current i and j values of for loop. :)
 */
public class RotateMatrixBy90 {

    private static int[][] rotateBy90(int[][] matrix){
        int temp=0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows/2; i++){
            for(int j=i; j<cols-i-1; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[cols-1-j][i];
                matrix[cols-1-j][i] = matrix[cols-1-i][cols-1-j];
                matrix[cols-1-i][cols-1-j] = matrix[j][cols-1-i];
                matrix[j][cols-1-i] = temp;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        printMatrix(rotateBy90(arr));
        System.out.println();
        int[][] arr2 = {{1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}};
        printMatrix(rotateBy90(arr2));
    }
}
