package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    private static List<Student> students=new ArrayList<>();
    private static List<Marks> marks=new ArrayList<>();

    public static String addStudent(String name,int age,String gender){
        Student s1=new Student(name,age,gender);

        students.add(s1);

        return "Student added successfully with the roll no: "+s1.getRoll_no();
    }

    public static Student editStudent(int roll,String name,int age,String gender) throws StudentNotFoundException {
        boolean exist=false;
        for(Student s:students){
            if(s.getRoll_no() == roll){
                exist=true;
                s.setName(name.equals("") ? s.getName() : name);
                s.setAge(age == 0 ? s.getAge() : age);
                s.setGender(gender.equals("") ? s.getGender() : gender);

                return s;
            }
        }

        if(exist == false){
            throw new StudentNotFoundException("Student with the roll no: "+roll+" not found");
        }

        return null;
    }

    public static Marks addStudentMarks(int roll_no,int tamil,int english,int social){
        boolean exist=false;

        for(Student s:students){
            if(s.getRoll_no() == roll_no){
                exist=true;
            }
        }

        if(exist == true){
            Marks mark=new Marks(roll_no,tamil,english,social);
            marks.add(mark);

            return mark;
        }else{
            return null;
        }

    }

    public static void displayMarks(int roll_no){

        for(Marks mark:marks){
            if(mark.getRoll_no() == roll_no){
                String name=getName(roll_no);
                System.out.println("Student name: "+name);
                System.out.println("Roll no: "+roll_no);
                System.out.println("Tamil: "+mark.getTamil());
                System.out.println("English: "+mark.getEnglish());
                System.out.println("Social: "+mark.getSocial());

                return;
            }
        }

        System.out.println("Sorry student's marks detail not available!");
    }

    public static String getName(int roll_no){
        for(Student s:students){
            if(s.getRoll_no() == roll_no){
                return s.getName();
            }
        }

        return  "";
    }

    public static void DisplayAllStudents(){
        System.out.println("***********************STUDENT DETAILS***********************");
        for (Student student:students){
            System.out.println("Name: "+student.getName());
            System.out.println("Roll No: "+student.getRoll_no());
            System.out.println("Age: "+student.getAge());
            System.out.println("Gender: "+student.getGender());
            System.out.println();
            System.out.println("**********************************************************");
        }
    }

    public static void DisplayRankWise(){

        Collections.sort(marks,(A,B)->(
                ((B.getTamil()+B.getEnglish()+B.getSocial())/3)-((A.getTamil()+A.getEnglish()+A.getSocial())/3)
        ));

        int rank=1;
        System.out.println("***********************STUDENT RANK REPORT****************************");
        for(Marks mark:marks){
            String name=getName(mark.getRoll_no());
            int total=mark.getTamil()+mark.getEnglish()+mark.getSocial();
            int avg=total/3;

            System.out.println("Name: "+name);
            System.out.println("Total marks obtained: "+total);
            System.out.println("Average: "+avg);
            System.out.println("Rank: "+rank);
            rank++;
            System.out.println();
            System.out.println("********************************************************************");

        }
    }
}
