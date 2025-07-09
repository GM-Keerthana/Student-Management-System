package StudentManagementSystem;

public class Student {
     private static int ROLL_NO_GENERATE=100;
     private String name;
     private int age;
     private String gender;
     private int roll_no;

     public Student(String name,int age,String gender){
         this.roll_no=ROLL_NO_GENERATE++;
         this.name=name;
         this.age=age;
         this.gender=gender;
     }

     public int getRoll_no() {return roll_no;}

     public void setRoll_no(int roll_no) {this.roll_no = roll_no;}

     public String getName() {return name;}

     public void setName(String name) {this.name = name;}

     public int getAge() {return age;}

     public void setAge(int age) {this.age = age;}

     public String getGender() {return gender;}

     public void setGender(String gender) {this.gender = gender;}

    @Override
    public String toString(){
         return "Student{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", gender='" + gender + '\'' +
                 ", roll_no=" + roll_no +
                 '}';
    }
}
