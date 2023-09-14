/*
 https://leetcode.com/problems/generate-parentheses/description/  (leetcode 22)
 */


 import java.util.*;
public class Generateparantheses {
    
    public static void main(String[] args) {
        int n=1;
        //int n = 3; // Input value for the number of pairs of parentheses
        ArrayList<String> result = solve(n); // Call the solve method to generate parentheses
        for (String parentheses : result) {
            System.out.println(parentheses); // Print each generated parentheses
        }
    }

    public static ArrayList<String> solve(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate("(", 1, 0, result, n); // Start the generation with an opening parenthesis
        return result;
    }

    public static void generate(String current, int obc, int cbc, ArrayList<String> result, int n) {
        // If the current string has reached the desired length (2*n), add it to the result
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if there are less than n open parentheses
        if (obc < n) {
            generate(current + "(", obc + 1, cbc, result, n);
        }

        // Add a closing parenthesis if there are more open parentheses than closing parentheses
        if (cbc < obc) {
            generate(current + ")", obc, cbc + 1, result, n);
        }
    }
}

/*
  Explanation of the above code


  1) need to keep rules in mind while generating bracket

  -> always start with open bracke
  -> if we are generating open bracket then it should be generated till less than or equal to n else if 
  we generate more than it will be not valid
  -> if we are generating close bracket then it should be generated till less than or equal to open bracket
   else if we generate more than it will be not valid

   2)solve method 
   -> we will create a string list which will have all parenthesis
   -> we will call recursive fn with paramenters
   ->"(" open bracket
   -> count of open bracket
   -> count of close bracket
   -> result list 
   -> and i/p given n
   and return the result list


   3) recursive function

   -> we will always start with open bracket and increase count of obpen bracket by 1 
   till openbracket count < n

   ->we will also increase close  bracket count  by 1 
   till openbracket count <  closebracket count

   4)base case

   -> we will store parenthesis in result list 
   -> we will store it until length of n *2 (as if n=2 then we have 2open & 2 close bracket)
   -> add in result list and return 

 */
