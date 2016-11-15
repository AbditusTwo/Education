import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaIfElse {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{
            if (n%2==1) {
                System.out.println("Hi");
            }
        }
        System.out.println(ans);
    }
}


/*
If  is n odd, print Weird
If  is n even and in the inclusive range of 2 to 5, print Not Weird
If  is n even and in the inclusive range of 6 to 20, print Weird
If  is n even and greater than 20, print Not Weird
 */