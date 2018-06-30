import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int fib(int n) {
        
        if (n < 0) {
            System.out.println("Error");
        }
        int F[][] = new int[][]{{1,1},{1,0}};
    if (n == 0)
        return 0;
    power(F, n-1);
      
    return F[0][0];
    }
    
    
      
    static void multiply(int F[][], int M[][])
    {
    int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
    int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
    int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
    int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
     
    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
    }
      
    /* Optimized version of power() in method 4 */
    static void power(int F[][], int n)
    {
    if( n == 0 || n == 1)
      return;
    int M[][] = new int[][]{{1,1},{1,0}};
      
    power(F, n/2);
    multiply(F, F);
      
    if (n%2 != 0)
       multiply(F, M);
    }


















    // tests

    @Test
    public void zerothFibonacciTest() {
        final int actual = fib(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstFibonacciTest() {
        final int actual = fib(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondFibonacciTest() {
        final int actual = fib(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdFibonacciTest() {
        final int actual = fib(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthFibonacciTest() {
        final int actual = fib(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthFibonacciTest() {
        final int actual = fib(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }

    // @Test(expected = Exception.class)
    // public void negativeFibonacciTest() {
    //     fib(-1);
    // }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}