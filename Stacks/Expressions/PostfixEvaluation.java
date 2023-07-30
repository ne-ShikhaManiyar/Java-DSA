import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String [] args)

    {

         String str = "953+4*6/-";
         System.out.println(str);
         
         // Create a stack to store values (operands)
         Stack<Integer> val = new Stack<>();
         
         int n = str.length();
         for(int i=0;i<n;i++)
         {
            char ch = str.charAt(i);

            int ascii =(int)ch;

            // If the character is a digit (0 to 9), push its integer value to the value stack
            if(ascii>=48 && ascii<=57)
            {
                val.push(ascii-48);
            }
            else
            {
                // If the character is an operator (+, -, *, /)
                // Pop the top two values from the value stack
                int v2 = val.pop();
                int v1 = val.pop();
                
                // Perform the corresponding operation and push the result back to the value stack
                if(ch=='+') val.push(v1+v2); 
                if(ch=='-') val.push(v1-v2); 
                if(ch=='*') val.push(v1*v2); 
                if(ch=='/') val.push(v1/v2); 
            }

         }

          // The final result will be the only value remaining in the value stack
          System.out.println(val.peek()+" ");
        
    }
    
}

/*

Pseudcode

1. Initialize a variable str with the input postfix expression
2. Create a stack to store values (operands): val
3. Initialize a variable n and set it to the length of the input string str
4. Loop through each character of the input string str from i = 0 to i = n-1
    a. Set ch to the character at index i of str
    b. Convert ch to its ASCII value and store it in ascii
    c. If ascii is between 48 and 57 (inclusive) [i.e., ch is a digit]
       i. Push the integer value of ch (ascii - 48) to the val stack
    d. Else (ch is an operator: +, -, *, /)
       i. Pop the top two values (v2 and v1) from the val stack
       ii. Perform the corresponding operation based on the operator ch and the values v1 and v2
       iii. Push the result of the operation back to the val stack
5. The final result will be the only value remaining in the val stack, which
 represents the evaluation of the postfix expression
6. Print the final result



 */