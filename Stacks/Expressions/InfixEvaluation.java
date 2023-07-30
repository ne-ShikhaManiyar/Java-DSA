import java.util.*;

public class InfixEvaluation {

    public static void main(String[] args) {
        
        //String str = "9-5+3*4/6";
        String str ="9-(5+3)*4/6 ";
        
        // Create two stacks: one for operators and another for values (operands)
        Stack <Character> op= new Stack<>();
        Stack <Integer> val= new Stack<>();
        
        int n = str.length();
        for(int i=0;i<n;i++)
        {
            char ch = str.charAt(i);
            int ascii= (int)ch;
            
            // If the character is a digit, push its integer value to the value stack
            if(ascii>=48 && ascii<=57)
            {
                val.push(ascii-48);
            }
            else if(op.size()==0 || ch=='(' || op.peek()=='(')
            {
                // If the operator stack is empty or the current character is an opening parenthesis,
                // push the character to the operator stack
                op.push(ch);
            }
            else if(ch==')')
            {
                // If the current character is a closing parenthesis, start evaluating the expression 
                // inside the parenthesis
                
                while(op.peek()!='(')
                {
                    // Pop the top two values from the value stack
                    int v2=val.pop();
                    int v1=val.pop();

                    // Perform the operation based on the operator at the top of the operator stack
                    // and push the result back to the value stack
                    if(op.peek()=='-') val.push(v1-v2);
                    if(op.peek()=='+') val.push(v1+v2);
                    if(op.peek()=='*') val.push(v1*v2);
                    if(op.peek()=='/') val.push(v1/v2);
                    
                    // Pop the operator from the operator stack as it is no longer needed
                    op.pop();
                }
                // Pop the opening parenthesis from the operator stack as it is no longer needed
                op.pop();
            }
            else
            {
                // If the current character is an operator (+, -, *, /)
                if(ch=='+'|| ch=='-' )
                {
                    // Pop the top two values from the value stack
                    int v2=val.pop();
                    int v1=val.pop();

                    // Perform the operation based on the operator at the top of the operator stack
                    // and push the result back to the value stack
                    if(op.peek()=='-') val.push(v1-v2);
                    if(op.peek()=='+') val.push(v1+v2);
                    if(op.peek()=='*') val.push(v1*v2);
                    if(op.peek()=='/') val.push(v1/v2);
                    
                    // Pop the operator from the operator stack as it is no longer needed
                    op.pop();
                    
                    // Push the current operator to the operator stack
                    op.push(ch);
                }
                if(ch=='*'|| ch=='/')
                {
                    // If the current operator is * or /
                    if(op.peek()=='*' || op.peek()=='/')
                    {
                        // If the top operator on the stack is also * or /, perform the operation 
                        // and push the result back to the value stack
                        int v2=val.pop();
                        int v1=val.pop();

                        if(op.peek()=='*') val.push(v1*v2);
                        if(op.peek()=='/') val.push(v1/v2);
                        
                        // Pop the operator from the operator stack as it is no longer needed
                        op.pop();
                        
                        // Push the current operator to the operator stack
                        op.push(ch);
                    }
                    else 
                    {
                        // If the top operator on the stack is + or -, push the current operator 
                        // to the operator stack
                        op.push(ch);
                    }
                }
            }
        }

        // Empty the remaining operators in the operator stack and perform the corresponding 
        // operations on the value stack
        while(val.size()>1)
        {
            int v2=val.pop();
            int v1=val.pop();

            if(op.peek()=='-') val.push(v1-v2);
            if(op.peek()=='+') val.push(v1+v2);
            if(op.peek()=='*') val.push(v1*v2);
            if(op.peek()=='/') val.push(v1/v2);
            
            // Pop the operator from the operator stack as it is no longer needed
            op.pop();
        }

        // The final result will be the only value remaining in the value stack
        System.out.println(val.peek());
    }
}



/*
 Pseudocode of above code
 
1. Initialize two stacks: op (for operators) and val (for values)
2. Initialize a variable n and set it to the length of the input string str
3. Loop through each character of the input string str from i = 0 to i = n-1
    a. Set ch to the character at index i of str
    b. Convert ch to its ASCII value and store it in ascii
    c. If ascii is between 48 and 57 (inclusive) [i.e., ch is a digit]
       i. Push the integer value of ch (ascii - 48) to the val stack
    d. Else if the op stack is empty or ch is an opening parenthesis '(' or the top of the op stack is also '('
       i. Push ch to the op stack
    e. Else if ch is a closing parenthesis ')'
       i. While the top of the op stack is not an opening parenthesis '('
          A. Pop the top two values (v2 and v1) from the val stack
          B. Pop the top operator from the op stack
          C. Perform the corresponding operation and push the result back to the val stack
       ii. Pop the opening parenthesis '(' from the op stack
    f. Else (ch is an operator: +, -, *, /)
       i. If ch is + or -
          A. Pop the top two values (v2 and v1) from the val stack
          B. Pop the top operator from the op stack
          C. Perform the corresponding operation and push the result back to the val stack
          D. Push ch to the op stack
       ii. Else (ch is * or /)
           A. If the top of the op stack is also * or /
              i. Pop the top two values (v2 and v1) from the val stack
              ii. Pop the top operator from the op stack
              iii. Perform the corresponding operation and push the result back to the val stack
              iv. Push ch to the op stack
           B. Else (the top of the op stack is + or -)
              i. Push ch to the op stack
4. End of loop
5. While the size of val stack is greater than 1
    a. Pop the top two values (v2 and v1) from the val stack
    b. Pop the top operator from the op stack
    c. Perform the corresponding operation and push the result back to the val stack
6. The final result will be the only value remaining in the val stack
7. Print the final result

 */

/* 

Explanation of above code

1)The program uses two stacks, one for operators (op) and another for integer values (val).

2)The loop iterates through each character of the input string str.

3) If the character is a digit (0-9), its integer value is pushed to the val stack.

4)If the operator stack is empty or the current character is an opening parenthesis 
'(', the operator is pushed to the op stack.

5)If the current character is a closing parenthesis ')', the program evaluates the 
expression inside the parenthesis using a loop. It pops two values from the val stack
 and one operator from the op stack, performs the corresponding operation, and pushes 
 the result back to the val stack. This process continues
  until an opening parenthesis '(' is encountered and removed.

  6)If the current character is an operator (+, -, *, /), the program checks the top operator
   on the op stack to determine the order of evaluation. 
   If the top operator has higher precedence, 
   it performs the operation and pushes the result back to 
   the val stack. If not, it pushes the current operator to the op stack.


   7)After processing all characters, the program ensures that all 
   remaining operations in the op stack are performed in the correct order.
    It pops two values from the val stack and one operator from the op stack,
     performs the corresponding operation, and pushes the result back to the val stack.
      This process continues until only one value remains in the val stack, 
      which represents the final result of the expression.

      8)The final result is printed, representing the evaluation of the infix expression.
 */