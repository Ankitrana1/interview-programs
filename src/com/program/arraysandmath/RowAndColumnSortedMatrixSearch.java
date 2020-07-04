package com.program.arraysandmath;
/*
Search a number exist in matrix which is row and column wise sorted.
if exist at matrix[i][j] then return result = (i+1)*1009 + (j+1).
If there are multiple number exist then return the minimum result.
 */
public class RowAndColumnSortedMatrixSearch {

    private static long findNumber(int[][] matrix, int num){
        long result=-1;
        if(matrix[0][0] == num)
            return 1010;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while (rows != 0 || columns !=0){
            if(rows == 0 || columns == 0)
                return result;
            if(matrix[matrix.length - rows][columns-1] == num){
                int mul = (matrix.length - rows + 1)*1009 +columns;
                if(result==-1)
                    result = mul;
                else if(result > mul)
                    result = mul;
                columns--;
            }
            else if(matrix[matrix.length - rows][columns-1] > num){
                columns--;
            }
            else
                rows--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{10,20,35,35},
                {12,21,35,35},
                {18,25,35,35},
                {35,35,40,40}};

        System.out.println(findNumber(matrix,35));
        System.out.println(findNumber(matrix,10));
        System.out.println(findNumber(matrix,5));
        System.out.println(findNumber(matrix,40));
    }
}
