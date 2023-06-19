/*
There is a football event going on in your city. In this event, you are 
given A passes and players having ids between 1 and 106.

Initially, some player with a given id had the ball in his possession. 
You have to make a program to display the id of the player who possessed the ball after exactly A passes.

There are two kinds of passes:

1) ID

2) 0

For the first kind of pass, the player in possession of the ball passes the 
ball "forward" to the player with id = ID.

For the second kind of pass, the player in possession of the ball passes the 
ball back to the player who had forwarded the ball to him.

In the second kind of pass "0" just means Back Pass.

Return the ID of the player who currently possesses the ball.



Problem Constraints

1 <= A <= 100000

1 <= B <= 100000

|C| = A



Input Format

The first argument of the input contains the number A.

The second argument of the input contains the number B ( id of the player possessing the ball
 in the very beginning).

The third argument is an array C of size A having (ID/0). 


Example Input

Input 1:

 A = 10
 B = 23
 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]

Input 2:

 A = 1
 B = 1
 C = [2]


Example Output
Output 1:63
Output 2:2


Hint : A is given no. of passes
B : id of player currently having ball with him
C: no of passes to the player , if 0 it means back pass eg: M23->M25->0 <- M25

1)Create a stack 
2) iterate over no .of passes
3) if id =B is 0 pop out of stack or if a id is their add in stack and return id

/*
Iterate over all the passes
1)push any id u encounter in Stack
2)in case of zero pop out the value from stack, bcoz its back pass to the player who passed new player




 */




import java.util.Arrays;
import java.util.Stack;

public class passinggame
{
    public static void main(String[] args)
    {
             int A= 10;
             int B=23;
             int C[] = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};

             int res = solve(A, B, C);
             String str = Arrays.toString(C);
             System.out.println(str); 
             System.out.print(res);
    }

    public static int solve(int A,int B,int C[])
    {
        Stack<Integer> stk = new Stack<>();
       // int n = C.length;
        int id = B;
        for(int i=0;i<A;i++)
        {
            if(C[i]==0)
            {
             id=   stk.pop();
            }
            else
            {
                stk.push(id);
                id = C[i];
            }

        }

        return id;
        
    }
}