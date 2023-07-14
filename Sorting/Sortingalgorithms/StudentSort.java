import java.util.jar.Attributes.Name;



import java.util.*;

class Student{
    String name;
    int marks;
    long Rollno;

    public Student(String name,int marks,long Rollno)
    {
        this.name = name;
        this.marks = marks;
        this.Rollno = Rollno;

    }

    public void printStudent()
    {
        System.out.println("Name is:"+ this.name);
        System.out.println("Marks is:"+ this.marks);
        System.out.println("RollNo is:"+ this.Rollno);
        System.out.println();
    }
}

 class SortByRollNo implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
       
        if(o1.Rollno < o2.Rollno) return -1;
        else return 1;
        
    }
}

//      class SortByMarks implements Comparator<Student>
//     {
//         @Override
//         public int compare(Student o1, Student o2)
//         {
//             if(o1.marks > o2.marks) return -1;
//             else if(o1.marks == o2.marks)
//              {
//                 if(o1.Rollno <o2.Rollno)  return -1;
//             else return 1;
//         }
//         else return 1;
    
//     }

// }

public class StudentSort{
public static void main(String[] args)
{
       Student s1 = new Student("Mohak",87,11L);
       Student s2 = new Student("Yahnit",87,13L);
       Student s3 = new Student("Harsh",90,12L);
       Student s4 = new Student("Abhi",80,1L);
      // s1.printStudnet();

      List<Student> students = new ArrayList<>();
      students.add(s1);
      students.add(s2);
      students.add(s3);
      students.add(s4);

      System.out.println("Sort by Rollno");
     Collections.sort(students,new SortByRollNo());
      for(Student s:students)
      {
        s.printStudent();
      }

    //  System.out.println("\n Sort by Marks");
  /*    Collections.sort(students, new SortByMarks());
      for(Student s:students)
      {
        s.printStudent();
      }*/
}
}

 