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
