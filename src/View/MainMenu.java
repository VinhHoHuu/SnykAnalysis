
package View;

import StudentController.Controller;
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();
    public void menu(){
        int choice = 0;
        do {
            System.out.println("======Student Management======");
            System.out.println("1. Add a student");
            System.out.println("2. Delete a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            
            try {
                System.out.print("Enter choice (1- 5): ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("Choice must be between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
            
            switch (choice){
                case 1:
                    System.out.println("--------------Add newStudent--------------");
                    controller.addAStudent();
                    break;
                case 2:
                    System.out.println("--------------Delete Student--------------");
                    controller.deleteStudentInforById();
                    break;
                case 3:
                    System.out.println("--------------Search Student--------------");
                    controller.searchStudentByName();
                    break;
                case 4:
                    controller.displayAllStudent();
                    break;
                case 5:
                    System.out.println("Good Bye!");
                    break;
            }
        } while (choice != 5);
    }
}
