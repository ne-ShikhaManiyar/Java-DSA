import java.util.Stack;

public class PrefixtoPostfix {
    
    public static void main(String[] args)
    {
        String str = "-9/*+5346";
        System.out.println(str);

        // Create a stack to store values (operands) as strings
        Stack<String> val = new Stack<>();

        int n = str.length();
        for(int i = n-1; i >= 0; i--)
        {
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // If the character is a digit (0 to 9), push it as a string followed by a space to the value stack
            if(ascii >= 48 && ascii <= 57)
            {
               val.push(ch + " ");
            }
            else
            {
                // If the character is an operator (+, -, *, /)
                // Pop the top two values from the value stack as strings
                String v1 = val.pop();
                String v2 = val.pop();
                
                // Get the operator as a character
                char op = ch;
                
                // Combine the two values and the operator to create the postfix notation for the expression
                String t = v1 + v2 + op;
                
                // Push the resulting value (postfix notation as a string) to the value stack
                val.push(t);
            }
        }

        // The final result will be the only value remaining in the value stack, which represents the postfix notation
        System.out.println(val.peek());
    }
}

/* 
 
Pseudocode

1. Initialize a variable str with the input prefix expression
2. Create a stack to store values (operands) as strings: val
3. Initialize a variable n and set it to the length of the input string str
4. Loop through each character of the input string str from i = n-1 to i = 0 (iterate in reverse)
    a. Set ch to the character at index i of str
    b. Convert ch to its ASCII value and store it in ascii
    c. If ascii is between 48 and 57 (inclusive) [i.e., ch is a digit]
       i. Push ch as a string followed by a space to the val stack
    d. Else (ch is an operator: +, -, *, /)
       i. Pop the top two values (v1 and v2) from the val stack as strings
       ii. Get the operator as a character (op)
       iii. Combine the two values and the operator to create the postfix notation 
       for the expression
       iv. Push the resulting value (postfix notation as a string) to the val stack
5. The final result will be the only value remaining in the val stack, 
which represents the postfix notation
6. Print the final result

 */