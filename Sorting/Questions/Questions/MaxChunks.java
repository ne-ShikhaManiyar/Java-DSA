/*You are given an integer array arr of length n that represents a permutation of the integers
 in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
 After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array
 * 
 * Constraints:

n == arr.length
1 <= n <= 10
0 <= arr[i] < n
All the elements of arr are unique.
 * 
 * Hint : we use the chaining technique to make the partition(chunk)
 * we update the max with A[i] vs max 
 * and it at any case i==max update chunk count and return it
 * 
 * 
 */







import java.util.Arrays;

public class MaxChunks {

    public static void main(String[] args)
    {
          //  int A[] = {3,0,1,2,5,4,8,6,7};
          int A[] = {1,0,2,3,4};
            int res = solve(A);
           // String str = Arrays.toString(A);
            System.out.print(res);
    }

    public static int solve(int A[])
    {
        int n = A.length;
        int max=0; // maintaining the max var to check till(index) when it has impact 
        int chunkcount=0; // if some stage if i==max then update the count 
        
        for(int i=0;i<n;i++)
        {
            max = Math.max(A[i],max);  //maintaining  the max by A[i] vs max bcz we use 
                                       ///chaining technique so max is updated after every chunk(partition)

            if(i==max)     //if at any pt i==max we make partition(chunk) to sort the array 
            {
                chunkcount++;    //increasing count;
            }
        }
        return chunkcount;  //returning count so we make partitions to sort array
    }
    
}
