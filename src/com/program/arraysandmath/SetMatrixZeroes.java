package com.program.arraysandmath;

import java.util.Arrays;

/*
Update row and column of a matrix with zero for every corresponding element i.e. matrix[i][j] = 0
 */
public class SetMatrixZeroes {

    private static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] setMatrixZeroes(int[][] matrix){
        boolean rowFlag = false, columnFlag = false;
        //check if row have any zeroes
        for(int i =0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        //check if column have any zeroes
        for(int i =0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                columnFlag = true;
                break;
            }
        }

        //iterate the remaining matrix for zeroes and makes it corresponding row and column first element as zero.
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        //if cell(i,0) or cell(0,j) is 0, then set set cell(i,j) = 0.
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[0][j] == 0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        //set row or column as 0 if flags are true.
        if(rowFlag){
            Arrays.fill(matrix[0], 0);
        }
        if(columnFlag){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,0,1},
                           {0,1,1,1},
                           {1,1,1,1},
                           {1,1,1,0}};
        int[][] matrix2 = {{1,1,0,1},
                            {1,1,1,1},
                            {1,1,1,1},
                            {1,1,1,0}};
        printMatrix(setMatrixZeroes(matrix1));
        System.out.println();
        printMatrix(setMatrixZeroes(matrix2));
    }
}
