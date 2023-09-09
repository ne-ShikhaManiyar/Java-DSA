/*
  Question :  N queens

  https://leetcode.com/problems/n-queens/  1st question 

  https://leetcode.com/problems/n-queens-ii/  2nd question with simple variation
 */

public class Nqueens {

    public static void main(String[] args) {
        int n = 1;
        char board[][] = new char[n][n];

        // Initialize the board with 'X' representing empty squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Start solving the N-Queens problem with the initial board configuration
        nqueen(board, 0);
    }

    // Recursive function to solve the N-Queens problem
    private static void nqueen(char[][] board, int row) {
        int n = board.length;

        // Base case: If we have placed queens in all rows, print the current board configuration
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println(); // Move to the next row for printing
            }
            System.out.println(); // Print an empty line to separate solutions
            return;
        }

        // Recursive case: Try placing a queen in each column of the current row
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) { // Check if it's safe to place a queen here
                board[row][j] = 'Q'; // Place the queen
                nqueen(board, row + 1); // Recur to the next row
                // Backtracking: Remove the queen to explore other possibilities
                board[row][j] = 'X';
            }
        }
    }

    // Helper function to check if it's safe to place a queen at a given position
    private static boolean isSafe(char[][] board, int row, int col) {

        int n = board.length;

        // Check the whole row (east and west) for any other queens
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check the whole column (north and south) for any other queens
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i = row;
        int j = col;

        // Check diagonals: northeast, southeast, southwest, northwest for other queens
        while (i >= 0 && j < n) { // northeast
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        i = row;
        j = col;
        while (i < n && j < n) { // southeast
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }

        i = row;
        j = col;
        while (i < n && j >= 0) { // southwest
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }

        i = row;
        j = col;
        while (i >= 0 && j >= 0) { // northwest
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        // If none of the above conditions are met, it's safe to place a queen here
        return true;
    }
}

/*
 
Pseudocode

1)isSafe function:
This helper function checks if it's safe to place a queen at a specific 
position on the chessboard. It examines the current row, column, 
and diagonals to ensure there are no other queens that can attack the current position.


2)nqueen function:
-> This recursive function finds all valid solutions to the N-Queens problem using backtracking.
-> It starts with an empty N×N chessboard and tries to place queens row by row.
-> When it successfully places queens in all rows (reaches the base case),
 it adds the current board configuration to the answer.
-> For each row, it iterates through each column and checks if it's safe 
to place a queen there using the isSafe function. If it's safe, 
it places a queen, recurs to the next row, and then backtracks
 by removing the queen to explore other possibilities.


3)solveNQueens function:

This is the main function that initiates solving the N-Queens problem.
It initializes an empty chessboard of size N×N with '.' representing empty squares.
It maintains a list (ans) to store all solutions.
It calls the nqueen function to start the solving process from the first row.

TC: In the worst case, the algorithm may have to try all 
possible combinations of queen placements, which results in O(N!) time complexity.

SC: The ans list stores all valid solutions, and in the worst case, 
there can be N! solutions, so the space complexity is O(N!).
The recursive call stack can go up to the depth of N, 
so the space complexity due to the call stack is O(N).

 */




/* 


code is for leetcode adding the  queen configuration in 2d arraylists
class Solution {

    private  boolean isSafe(char[][] board, int row, int col) {

        // check the whole row  check for east and west
        int n = board.length;
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // check the whole column  check for north and south

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i = row;
        int j = col;
        // checking for northeast
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        i = row;
        j = col;
        // checking for southeast
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }

        i = row;
        j = col;
        // checking for southwest
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        // checking for northwest
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        return true;
    }

 private  void nqueen(char[][] board, int row, List<List<String>> ans) {

        int n = board.length;
        if (row == n) {   //base case
            
            //copy  board 2d array into list of arraylists
            List<String> l = new ArrayList<>();
           for(int i=0;i<n;i++)
           {
               String str="";
               for(int j=0;j<n;j++)
               {
                  str += board[i][j];
               }
               l.add(str);
           }

        ans.add(l);
        return;

        }
        for (int j = 0; j < n; j++) {   // work and call
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1, ans);  // recursion to move next row
                // backtracking
                board[row][j] = '.';  // backtracking 
            }

        }

    }
 


    public List<List<String>> solveNQueens(int n) {
        
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0,ans);
        return ans;

    }
}



*/