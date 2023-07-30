import java.util.Stack;

public class PostfixtoInfix {
    public static void main(String [] args)

    {

         String str = "953+4*6/-";
         System.out.println(str);
         
         // Create a stack to store values (operands) as strings
         Stack<String> val = new Stack<>();
         
         int n = str.length();
         for(int i=0;i<n;i++)
         {
            char ch = str.charAt(i);

            int ascii =(int)ch;

            // If the character is a digit (0 to 9), push it as a string to the value stack
            if(ascii>=48 && ascii<=57)
            {
                val.push(ch+"");
            }
            else
            {
                // If the character is an operator (+, -, *, /)
                // Pop the top two values from the value stack as strings
                String v2 = val.pop();
                String v1 = val.pop();
                
                // Get the operator as a character
                char op = ch;
                
                // Combine the two values and the operator to create the infix notation for the expression
                String t = "(" + v1 + op + v2 + ")";
                
                // Push the resulting value as a string to the value stack
                val.push(t);
            }

         }

          // The final result will be the only value remaining in the value stack, which represents the infix notation
          System.out.println(val.peek()+" ");
    }
}

/*
 Pseudocode

 1. Initialize a variable str with the input postfix expression
2. Create a stack to store values (operands) as strings: val
3. Initialize a variable n and set it to the length of the input string str
4. Loop through each character of the input string str from i = 0 to i = n-1
    a. Set ch to the character at index i of str
    b. Convert ch to its ASCII value and store it in ascii
    c. If ascii is between 48 and 57 (inclusive) [i.e., ch is a digit]
       i. Push ch as a string to the val stack
    d. Else (ch is an operator: +, -, *, /)
       i. Pop the top two values (v2 and v1) from the val stack as strings
       ii. Get the operator as a character (op)
       iii. Combine the two values and the operator to create the infix notation for the expression
       iv. Enclose the combined expression within parentheses to maintain precedence of operators
       v. Push the resulting value (infix notation as a string) to the val stack
5. The final result will be the only value remaining in the val stack, which represents
 the infix notation
6. Print the final result


 */