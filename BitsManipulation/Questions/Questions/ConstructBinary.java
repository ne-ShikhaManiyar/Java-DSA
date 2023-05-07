/*
Question : Construct a binary number

-> Construct a binary number having A 1's followed by B 0's return
    decimal value of the number

    Problem constraints
    1<=A+B<=30

 i/p1  A=3,B=2;  binary num (11100) 
o/p 1 -> 28

i/p2 : A=2,B=3; binary num(11000) 
o/p 2 -> 24

   Hint : Simply convert the given numbers into string 
   add the given binary numbers into string as
   given and iterate on it;

   -> Use Integer.parseInt(string,radix) method to return the ans
 */


package Questions;
import java.lang.*;
import java.util.*;

public class ConstructBinary {

     public static void main(String[]args)
    {
        int A= 3;
        int B=2;

        int res = solve(A,B);
        System.out.print(res);
    }

    public static int solve(int A, int B) {

        
        String num = "";
        for(int i=0;i<A;i++)
        {
            num = num + "1";
        }
          for(int i=0;i<B;i++)
        {
            num = num + "0";
        }
        
         return Integer.parseInt(num,2);
    }
}
