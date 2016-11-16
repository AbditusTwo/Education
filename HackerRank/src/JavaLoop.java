import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = 1;
        if ((N>=2)&&(N<=20)) {
            while (i <= 10) {
                System.out.println(N + " x " + i + " = " + N*i);
                ++i;
            }
        }
        else {
            System.out.println("Nope");
        }
    }
}


/*
Task
Given an integer, N, print its first 10 multiples. Each multiple N x i(where 1<= i <=10 ) should be printed on a new line in the form: N x i = result.

Input Format

A single integer, N

Constraints

2 <= N <=20

Sample Output

2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20
*/