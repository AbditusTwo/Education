import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class JavaIfElse {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{
            if (((n>=2)&&(n<=5))||(n>20)) {
                ans = "Not Weird";
            }
            else {
                if ((n>=6)&&(n<=20)) {
                    ans = "Weird";
                }
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