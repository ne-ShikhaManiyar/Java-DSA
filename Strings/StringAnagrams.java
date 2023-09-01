/*
  Question : Group anagrams

  https://leetcode.com/problems/group-anagrams/description/ //leetcode 

  https://www.interviewbit.com/problems/anagrams/ //interviewbit


 */



import java.util.*;

public class StringAnagrams
{


public static void main(String [] args)
{

}


public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

    // Create a HashMap to store words associated as anagrams with each other.
    // The words are stored as keys, and their indices are stored as values.
    HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

    // Iterate through the input list of strings.
    for (int i = 0; i < A.size(); i++) {
        // Convert the current string to a character array.
        char arr[] = A.get(i).toCharArray(); // e.g., "cat" -> ['c', 'a', 't']

        // Sort the characters in the array.
        Arrays.sort(arr); // After sorting: ['a', 'c', 't']

        // Convert the sorted character array back to a string.
        String s = new String(arr); // After converting: "act"

        // Check if the sorted string is already a key in the HashMap.
        if (hm.containsKey(s)) {
            // If it's a known anagram, add the current index to its list of indices.
            hm.get(s).add(i + 1); // Use 1-based indexing.
        } else {
            // If it's a new anagram, create a new ArrayList to store its indices.
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(i + 1); // Add the current index to the list.

            // Insert the new key (sorted string) and its ArrayList into the HashMap.
            hm.put(s, ans);
        }
    }

    // Create a result list to store the grouped anagrams.
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    // Iterate through the keys in the HashMap.
    for (String key : hm.keySet()) {
        // Add the ArrayList of indices associated with each key (anagram) to the result list.
        list.add(hm.get(key));
    }

    // Return the final list containing grouped anagrams and their indices.
    return list;
}


}

/*
  Pseudocode

  1)first create a hashmap of(String, ArrayList<Integer>) to store the keys of string 
  and pairs as list (to store indexes corresponding to it as anagram)
  2)then iterate over i/p array 
  3) in the get the ith element from the array or list and convert it into charArray "cat-> 'c''a''t'
  4)After converting it to charArray now sort it so it will be  'c''a''t' -> 'a''c''t'
  5)and then again convert sorted  charArray to a string 
  6) Now check if the particular sorted String (key) present in map
  - > if condition is true it means that there is already a key 
  in the map for the sorted string, which indicates that the 
  current string is an anagram of some previously encountered string(s).
  -> if yes then retrieve it in map and add current index
  7)else It  is false, it means   that the sorted string
  is not yet present as a key in the map,   which indicates that
   the current string is a new anagram group.
-> create new arraylist add currentindex(i+) in the list 
-> then essentially create a new entry in the HashMap for the current anagram group.
8)Create a 2d arraylist
9)then iterate over keys of hashmap through foreach loop & keyset
-> loop will iterate through all keys in map
-> add the keys in list and indices associated it with as anagram grp 
10) return the doubly AL

TC:
The overall time complexity of the code is O(n * m * log m) in the worst case, 
where n is the number of strings, and m is the average length of strings.

SC:

The overall space complexity of the code is O(n * m) in the worst case.

 */