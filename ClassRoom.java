package StudentManagementSystem;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Scanner;

public class ClassRoom {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.println("********************Welcome to the classroom********************");
            System.out.println("1.Create a student");
            System.out.println("2.Edit student details");
            System.out.println("3.Enter student details");
            System.out.println("4.Display student marks");
            System.out.println("5.All student details");
            System.out.println("6.Rank Record");
            System.out.println("0.Exit");

            System.out.print("Enter your choice: ");
            int op=input.nextInt();

            switch (op){
                case 1:
                    System.out.println("Enter the name of the student");
                    input.nextLine();
                    String name=input.nextLine();
                    System.out.println("Enter the age of the student: ");
                    int age=input.nextInt();
                    System.out.println("Enter the gender of the student: ");
                    String gender=input.next();

                    String response=Controller.addStudent(name,age,gender);
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("Enter the roll no: ");
                    int roll=input.nextInt();
                    System.out.println("*Enter empty data such as empty string or 0 which implies no change in existing data*");
                    System.out.println("Enter the name of the student: ");
                    input.nextLine();
                    String newName=input.nextLine();
                    System.out.println("Enter the age of the student:");
                    int a=input.nextInt();
                    System.out.println("Enter the gender of the student: ");
                    input.nextLine();
                    String gen=input.nextLine();

                    Student student=Controller.editStudent(roll,newName,a,gen);
                    if(student == null){
                        System.out.println("Sorry student does not exist");
                    }else{
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.println("Enter the roll of the student: ");
                    int roll_no= input.nextInt();
                    System.out.println("Enter mark for Tamil: ");
                    int tamil=input.nextInt();
                    System.out.println("Enter mark for english: ");
                    int english=input.nextInt();
                    System.out.println("Enter mark for social: ");
                    int social=input.nextInt();

                    Marks mark=Controller.addStudentMarks(roll_no,tamil,english,social);

                    if(mark == null){
                        System.out.println("Sorry does not exist with given roll no!");
                    }else{
                        System.out.println(mark);
                    }
                    break;
                case 4:
                    System.out.println("Enter the student roll no: ");
                    int rollno=input.nextInt();

                    Controller.displayMarks(rollno);
                    break;
                case 5:
                    Controller.DisplayAllStudents();
                    break;
                case 6:
                    Controller.DisplayRankWise();
                    break;
                case 0:
                    System.exit(1);
                    break;

            }
        }
    }
}
