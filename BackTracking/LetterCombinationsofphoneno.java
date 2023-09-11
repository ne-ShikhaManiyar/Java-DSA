/*
 
Question: Letter Combinations of a Phone Number

https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/  (leetcode)

https://www.interviewbit.com/problems/letter-phone/    (interviewbit)


 */

import java.util.*;

public class LetterCombinationsofphoneno {
    

    public static void main(String[] args)
    {
       LetterCombinationsofphoneno obj = new LetterCombinationsofphoneno();
       ArrayList<String>  result = obj.solve("23");
       System.out.println(result);
    }

    public static ArrayList<String> solve(String digits) {
      // Initialize an ArrayList to store the resulting combinations
      ArrayList<String> ans = new ArrayList<>();
      
      // Check if the input string is empty
      if (digits.length() == 0)
          return ans;

      // Create a HashMap that maps digits to their corresponding letters
      HashMap<Character, String> map = new HashMap<>();
      map.put('0', "0");
      map.put('1', "1");
      map.put('2', "abc");
      map.put('3', "def");
      map.put('4', "ghi");
      map.put('5', "jkl");
      map.put('6', "mno");
      map.put('7', "pqrs");
      map.put('8', "tuv");
      map.put('9', "wxyz");

      // Call the recursive function to generate combinations
      Combinations(digits, 0, map, new StringBuilder(), ans);

      // Return the list of combinations
      return ans;
  }

  public static void Combinations(String digits, int i, HashMap<Character, String> map, StringBuilder sb, ArrayList<String> ans) {
      // Base case: If we have processed all digits, add the current combination to the result
      if (i == digits.length()) {
          ans.add(sb.toString());
          return;
      }

      // Get the letters corresponding to the current digit from the map
      String curr = map.get(digits.charAt(i));

      // Iterate through each letter and recursively generate combinations
      for (int j = 0; j < curr.length(); j++) {
          // Append the current letter to the combination
          sb.append(curr.charAt(j));

          // Recursively call the function for the next digit 
          Combinations(digits, i + 1, map, sb, ans);

          // Backtrack by removing the last character from the combination
          sb.deleteCharAt(sb.length() - 1);
      }
  }
}

/*
  Pseudocode

1)Digit-to-Letter Mapping: Create a mapping of each digit on a 
phone keypad (2 to 9) to the corresponding 
letters (e.g., '2' maps to "abc," '3' maps to "def," and so on).

2)Initialize an Empty List: Create an empty list (ans)
 to store the generated letter combinations.

 3)Recursive Backtracking Function:
-> Implement a recursive function (combination) to generate letter combinations.
This function takes several parameters: the input digits, the current index (i), 
the digit-to-letter mapping (map), a StringBuilder to build the current combination (sb),
 and the final list of combinations (ans).

4)Base Case:
-> If the current index i is equal to the length of the input digits, it 
means a complete combination has been formed.
-> In this case, add the current combination in the StringBuilder sb to the list ans and return.

5)Generating Combinations for Current Digit:
-> If i is not at the end of the input digits:
-> Retrieve the string of letters corresponding to the current digit from the map.
-> Iterate through each letter in the letter string.
-> Append the current letter to the StringBuilder sb.
-> Recursively call the combination function with an updated index (i+1) to move on to the next digit.
-> After the recursive call, remove the last character 
from sb (backtrack) to explore other combinations with different letters for the current digit.

6)Initiation:
-> In the main function (letterCombinations):
-> If the input string digits is empty, return an empty 
list since there are no combinations to generate.
-> Otherwise, initiate the combination generation process by calling
 the combination function with the initial parameters.

7)Completing the Process:
After all recursive calls have finished, the ans list contains all possible letter combinations.
Return the ans list as the final result.


Time complexity

-> Let's assume the input string has n digits, and the maximum number of letters corresponding 
to a digit is m.
-> The time complexity is O(m^n), as each digit leads to a branching factor of m,
 and there are n digits in the input.


 Space compleity
 -> Therefore, the space complexity is O(n) for the recursive call stack 
 and O(n) for the StringBuilder, resulting in a total space complexity of O(n).

 */