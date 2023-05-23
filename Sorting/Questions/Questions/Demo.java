
import java.io.*;
import java.lang.*;
import java.util.*;
public class Demo {

    public static void main(String[] args)
    {

        Comparator <Integer> com = new Comparator<Integer>()
         {
            public int compare(Integer i, Integer j)
            {
                if(i%10 > j%10)
                return 1;
                else
                return -1;
            }    

        };
          List<Integer> nums = new ArrayList<>();
          nums.add(39);
          nums.add(14);
          nums.add(23);

          Collections.sort(nums,com);

          System.out.print(nums);
    }
    
}
