
package StudentController;

import Model.Student;
import Utils.Input;
import java.util.ArrayList;
import java.util.Scanner;


public class Controller extends ArrayList<Student>{
    Input input = new Input();
    Scanner sc = new Scanner(System.in);
    public void addAStudent(){
        int studentId = input.inputId();
        String fullName = input.inputName();
        double gpa = input.inputGPA();
        Student student = new Student(studentId, fullName, gpa);
        this.add(student);
        System.out.println("The student has been added!");
    }
    
    public void deleteStudentInforById(){
        
        if (this.isEmpty()){
            System.out.println("No information has registerd yet!");
            return;
        }else{
            int id = 0;
            while (true) {
                try {
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                    continue;
                }
                break;
            }
            Student victim = findStudentById(id);
            if (victim == null) {
                System.out.println("Information not found!");
            } else {
                this.remove(victim);
                input.removeId(victim.getStudentId());
                System.out.println("The student with id[" + id + "] has been removed!");
            }
        }
    }
    
    public void searchStudentByName(){
        
        int count = 0;
        if (this.isEmpty()){
            System.out.println("No information has registerd yet!");
            return;
        }else{
            System.out.print("Enter student full name: ");
            String name = sc.nextLine();
            for (Student student : this) {
                if (student.getFullName().contains(name)) {
                    System.out.println("***Search result***");
                    System.out.println(String.format("Student id: %d", student.getStudentId())
                            + String.format(" ,name: %s", student.getFullName())
                            + String.format(" ,GPA: %.2f", student.getGPA()));
                    count++;
                }
            }
        }
        if (count == 0){
            System.out.println("Information not found!");
        }
    }
    
    private Student findStudentById(int id) {
        for (Student student : this) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }
    
    public void displayAllStudent(){
        if (this.isEmpty()){
            System.out.println("No information has registerd yet!");
            return;
        }
        String line = "------------------------------------------------";
        System.out.println(line);
        System.out.printf(" %10s| %-15s | %10s|\n", "Student Id", "Student Name", "Student Gpa");
        System.out.println(line);
        for (Student student : this){
            System.out.println(student.toString());
        }
        System.out.println(line);
    }
    
    
}
