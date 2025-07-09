package StudentManagementSystem;

import java.util.Comparator;

public class Marks implements Comparable, Comparator {

    private int roll_no;
    private int tamil;
    private int english;
    private int social;

    public Marks(int roll_no,int tamil,int english,int social){
        this.roll_no=roll_no;
        this.tamil=tamil;
        this.english=english;
        this.social=social;
    }

    public int getRoll_no() {return roll_no;}

    public void setRoll_no(int roll_no) {this.roll_no = roll_no;}

    public int getTamil() {return tamil;}

    public void setTamil(int tamil) {this.tamil=tamil;}

    public int getEnglish() {return english;}

    public void setEnglish(int english) {this.english=english;}

    public int getSocial() {return social;}

    public void setSocial(int social) {this.social=social;}

    @Override
    public String toString(){
        return "Marks{" +
                "roll_no=" + roll_no +
                ", tamil=" + tamil +
                ", english=" + english +
                ", social=" + social +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Marks mark=(Marks) o;
        int s1=(this.tamil+this.english+this.social)/3;
        int s2=(mark.tamil+mark.english+mark.social)/3;
        return s1-s2;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Marks mark1=(Marks) o1;
        Marks mark2=(Marks) o2;

        int s1=(mark1.tamil+mark1.english+mark1.social)/3;
        int s2=(mark2.tamil+mark2.english+mark2.social)/3;

        return s1-s2;
    }
}
