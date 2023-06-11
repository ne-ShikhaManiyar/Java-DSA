/*
 Problem Description
You are given a character string A having length N, consisting of
 only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. 
For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.



Problem Constraints
1 <= N <= 105

A[i] ∈ ['a'-'z', 'A'-'Z']

Input 1:

 A = "Hello" 
Input 2:

 A = "tHiSiSaStRiNg" 


Example Output
Output 1:

 hELLO 
Output 2:

 ThIsIsAsTrInG 


 */

public class Togglecase {

    public static void main(String [] args)
    {

        String str = "abSL";
        String res = solve(str);

        System.out.print(res);

    }

    public static String solve(String A)

    {
          // Convert the input string into a character array
          char[] arr = A.toCharArray();

          // Loop through each character in the array
          for (int i = 0; i < arr.length; i++) {
              // Check if the character is an uppercase letter
              if (arr[i] >= 'A' && arr[i] <= 'Z') {
                  // If it is an uppercase letter, convert it to lowercase
                  arr[i] = (char) (arr[i] + 32);
              } else {
                  // If it is not an uppercase letter, convert it to uppercase
                  arr[i] = (char) (arr[i] - 32);
              }
          }
  
          // Convert the modified character array back to a string and return it
          return new String(arr);
  
    }
    
}
