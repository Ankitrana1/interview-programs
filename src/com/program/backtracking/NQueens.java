package com.program.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NQueens {
        static void printSolution(int board[][], ArrayList<ArrayList<String>> res)
        {
            res.add(new ArrayList<String>());
            for(int i = 0;i<board.length; i++)
            {
                String temp = "";
                for(int j = 0;j<board.length;j++)
                {
                    if(board[i][j] == 1)
                        temp += "Q";
                    else
                        temp += ".";
                }
                res.get(res.size()-1).add(temp);
            }
        }
        static void solveNQUtil(int board[][], int col, ArrayList<ArrayList<String>> res)
        {
            if(col == board.length)
            {
                printSolution(board,res);
                return;
            }
            for(int i = 0; i < board.length; i++)
            {
                if(isSafe(board, i, col))
                {
                    board[i][col] = 1;
                    solveNQUtil(board, col + 1, res);
                    board[i][col] = 0;
                }
            }
            return;
        }
        static boolean isSafe(int board[][], int row, int col)
        {
            int i, j;
            for(i = 0;i<col;i++)
                if(board[row][i] == 1)
                    return false;
            for(i=row,j=col;i>=0 && j>=0;i--,j--)
                if(board[i][j] == 1)
                    return false;
            for(i=row,j=col;j>=0 && i<board.length;i++,j--)
                if(board[i][j] == 1)
                    return false;

            return true;
        }
        private static ArrayList<ArrayList<String>> solveNQueens(int a) {
            int board[][] = new int[a][a];
            ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
            solveNQUtil(board, 0, ans);
            return ans;
        }

        private static void print(ArrayList<ArrayList<String>> boards){
            for(ArrayList<String> a : boards)
                for (String s: a)
                    System.out.println(s);
        }

    public static void main(String[] args) {
        print(solveNQueens(4));
        print(solveNQueens(5));
        print(solveNQueens(8));
    }
}
