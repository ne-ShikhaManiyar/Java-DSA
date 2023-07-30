import java.util.Stack;

public class InfixtoPostfix {
    
    public static void main(String [] args)
    {
         String infix = "9-(5+3)*4/6 ";
         System.out.println(infix);
         
         // Create two stacks: one for operators (op) and another for values (val)
        Stack<Character> op = new Stack<>();
        Stack<String> val = new Stack<>();
        
        int n = infix.length();
        for (int i = 0; i < n; i++) {
            char ch = infix.charAt(i);
            int ascii = (int) ch;
            
            // If the character is a digit (0 to 9), push it as a string to the value stack
            if (ascii >= 48 && ascii <= 57) {
                String s = " " + ch;
                val.push(s);
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                // If the operator stack is empty or the current character is an opening parenthesis '(',
                // push the character to the operator stack
                op.push(ch);
            } else if (ch == ')') {
                // If the current character is a closing parenthesis ')', start converting the expression
                // inside the parenthesis to postfix notation
                
                while (op.peek() != '(') {
                    // Pop the top two values from the value stack
                    String v2 = val.pop();
                    String v1 = val.pop();
                    
                    // Pop the operator from the operator stack
                    char o = op.pop();
                    
                    // Combine the two values and the operator to create the postfix notation for the expression
                    String t =  v1 + v2 + o;
                    
                    // Push the resulting value to the value stack
                    val.push(t);
                }
                // Pop the opening parenthesis '(' from the operator stack as it is no longer needed
                op.pop();
            } else {
                // If the current character is an operator (+, -, *, /)
                if (ch == '+' || ch == '-') {
                    // Pop the top two values from the value stack
                    String v2 = val.pop();
                    String v1 = val.pop();
                    
                    // Pop the operator from the operator stack
                    char o = op.pop();
                    
                    // Combine the two values and the operator to create the postfix notation for the expression
                    String t =  v1 + v2 + o;
                    
                    // Push the resulting value to the value stack
                    val.push(t);
                    
                    // Push the current operator to the operator stack
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // If the top operator on the stack is also * or /, convert the expression accordingly
                        
                        // Pop the top two values from the value stack
                        String v2 = val.pop();
                        String v1 = val.pop();
                        
                        // Pop the operator from the operator stack
                        char o = op.pop();
                        
                        // Combine the two values and the operator to create the postfix notation for the expression
                        String t =  v1 + v2 + o;
                        
                        // Push the resulting value to the value stack
                        val.push(t);
                        
                        // Push the current operator to the operator stack
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }

        // Empty the remaining operators in the operator stack and convert the expressions to postfix notation
        while (val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t =  v1 + v2 + o;
            val.push(t);
        }

        // The final result will be the only value remaining in the value stack, which represents the postfix notation
        String postfix= val.peek();
        System.out.println(postfix);
    }
}


/*
  Pseudocode of above code

  1. Initialize a variable infix with the input infix expression
2. Create two stacks: op (for operators) and val (for values)
3. Initialize a variable n and set it to the length of the input string infix
4. Loop through each character of the input string infix from i = 0 to i = n-1
    a. Set ch to the character at index i of infix
    b. Convert ch to its ASCII value and store it in ascii
    c. If ascii is between 48 and 57 (inclusive) [i.e., ch is a digit]
       i. Push ch as a string to the val stack
    d. Else if the op stack is empty or ch is an opening parenthesis '(' or the top of the op stack is also '('
       i. Push ch to the op stack
    e. Else if ch is a closing parenthesis ')'
       i. While the top of the op stack is not an opening parenthesis '('
          A. Pop the top two values (v2 and v1) from the val stack
          B. Pop the top operator from the op stack
          C. Combine the two values and the operator to create the postfix notation for the expression
          D. Push the resulting value to the val stack
       ii. Pop the opening parenthesis '(' from the op stack as it is no longer needed
    f. Else (ch is an operator: +, -, *, /)
       i. If ch is + or -
          A. Pop the top two values (v2 and v1) from the val stack
          B. Pop the top operator from the op stack
          C. Combine the two values and the operator to create the postfix notation for the expression
          D. Push the resulting value to the val stack
          E. Push ch to the op stack
       ii. Else (ch is * or /)
           A. If the top of the op stack is also * or /
              i. Pop the top two values (v2 and v1) from the val stack
              ii. Pop the top operator from the op stack
              iii. Combine the two values and the operator to create the postfix notation for 
              the expression
              iv. Push the resulting value to the val stack
              v. Push ch to the op stack
           B. Else (the top of the op stack is + or -)
              i. Push ch to the op stack
5. End of loop
6. While the size of val stack is greater than 1
    a. Pop the top two values (v2 and v1) from the val stack
    b. Pop the top operator from the op stack
    c. Combine the two values and the operator to create the postfix notation for the expression
    d. Push the resulting value to the val stack
7. The final result will be the only value remaining in the val stack, which represents
 the postfix notation
8. Print the final result

 */

 