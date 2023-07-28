/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'. 

// https://leetcode.com/problems/valid-parentheses/description/
 */


/*
 
Explanation

1)The program defines a class called ValidParentheses.

2)The main method is used to test the functionality of the ValidParentheses function. 
It sets a sample input string str and then calls the ValidParentheses function to check 
if the parentheses in the string are valid or not.

3)The ValidParentheses function takes a string as input and returns a boolean value 
indicating whether the parentheses in the string are valid or not.

4)The function uses a stack to keep track of the opening parentheses encountered while
 iterating through the input string.

5)It checks if the length of the string is odd, which implies there can't be a valid pair 
for each parenthesis, so it returns false.

6)It then iterates through each character in the input string.

7)If an opening parenthesis is encountered (i.e., '(', '{', '['), it is pushed onto the stack.

8)If a closing parenthesis is encountered, the function checks if the stack is not empty and 
if the top of the stack contains the corresponding opening parenthesis. If they match, 
the opening parenthesis is popped from the stack and the loop continues with the next character. 
If they don't match, the parentheses are considered invalid, and the function returns false.

9)After processing all characters, if the stack is empty, 
it means all parentheses were matched correctly, and the 
function returns true (i.e., the parentheses are valid). 
Otherwise, it returns false (i.e., some opening parentheses were not
 matched with their corresponding closing parentheses).

 */





import java.util.*;

public class ValidParentheses {

  public static void main(String[] args) {
    // Input string containing parentheses
    String str="()[]{}";
    
    // Call the ValidParentheses function to check if the parentheses are valid
    boolean result = ValidParentheses(str);
    
    // Print the result
    System.out.print(result);
  }

  public static boolean ValidParentheses(String str) {
    // Create a stack to store the opening parentheses
    Stack<Character> stk = new Stack<>();
    
    // Get the length of the input string
    int n = str.length();

    // If the number of characters in the string is odd, it can't be valid
    if (n % 2 == 1) {
      return false;
    }
    
    // Iterate through each character of the string
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      
      // If the character is an opening parenthesis, push it onto the stack
      if (ch == '(' || ch == '{' || ch == '[') {
        stk.push(ch);
      }
      // If the character is a closing parenthesis
      else if (ch == ')') {
        // Check if the stack is not empty and the top of the stack contains a matching opening parenthesis
        if (stk.size() != 0 && stk.peek() == '(') {
          // If it matches, pop the opening parenthesis from the stack and continue with the next character
          stk.pop();
          continue;
        } else {
          // If it doesn't match, the parentheses are invalid
          return false;
        }
      }
      else if (ch == '}') {
        if (stk.size() != 0 && stk.peek() == '{') {
          stk.pop();
          continue;
        } else {
          return false;
        }
      }
      else if (ch == ']') {
        if (stk.size() != 0 && stk.peek() == '[') {
          stk.pop();
          continue;
        } else {
          return false;
        }
      }
    }

    // If the stack is empty after processing all characters, it means all parentheses are matched and valid
    if (stk.isEmpty()) {
      return true;
    }

    // If the stack is not empty, it means there are unmatched opening parentheses
    return false;
  }
}


