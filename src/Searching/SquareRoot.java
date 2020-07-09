package Searching;
/*
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
 */
public class SquareRoot {

    private static int findSquareRoot(int num, int rangeStart, int rangeEnd){
        int mid = rangeStart + (rangeEnd-rangeStart)/2;
        if (mid*mid == num)
            return mid;
        else if(mid*mid < num && (mid+1)*(mid+1) > num)
            return mid;
        else if(mid*mid > num)
            return findSquareRoot(num, rangeStart, mid-1);
        else
            return findSquareRoot(num, mid+1, rangeEnd);
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(625, 1, 625/2));
        System.out.println(findSquareRoot(50, 1, 50/2));
        System.out.println(findSquareRoot(196, 1, 196/2));
    }
}
