import java.util.ArrayList;
import java.util.List;

class Student {
    private static int id = 0;
    private String firstName;
    private int studentID;
    private List<Course> courses;

    public Student(String name) {
        this.firstName = name;
        this.studentID = getId();
        this.courses = new ArrayList<>();
    }

    private static int getId() {
        id++;
        return id;
    }

    public void printInfo() {
        int totalScores = 0;
        int totalCourses = this.courses.size();
        for (Course course : this.courses) {
            totalScores += Integer.parseInt(course.getGrade());
        }
        System.out.printf("%-15s %-5d %-5d %-20s %-5s%n", this.firstName, this.studentID, totalScores / totalCourses, this.courses.get(0).getSubject(), this.courses.get(0).getGrade());
        for (int i = 1; i < totalCourses; i++) {
            this.courses.get(i).printInfo();
        }
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}

class Course {
    private String subject;
    private String grade;

    public Course(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public void printInfo() {
        System.out.printf("%-27s %-20s %-5s%n", "", this.subject, this.grade);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // add one student
        Student student1 = new Student("Capybara");
        student1.addCourse(new Course("Psychology", "100"));
        student1.addCourse(new Course("Math", "120"));
        students.add(student1);

        // add another student
        Student student2 = new Student("Bob the Builder");
        student2.addCourse(new Course("Physical Education", "98"));
        student2.addCourse(new Course("Physics", "100"));
        student2.addCourse(new Course("Computer Science", "94"));
        students.add(student2);

        // print all students
        System.out.printf("%-15s %-5s %-5s %-20s %-5s%n", "Name", "ID", "Avg", "Subject", "Grade");
        System.out.println("=========================================================");
        for (Student student : students) {
            student.printInfo();
        }
    }
}
