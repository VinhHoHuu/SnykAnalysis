
package Utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




public class Input {
    Scanner sc = new Scanner(System.in);
    Set<Integer> uniqueList = new HashSet<>();
    Validation validation = new Validation();
    public int inputId(){        
        while (true){
            try {
                System.out.print("Enter unique student id(positive integer number): ");
                int id = Integer.parseInt(sc.nextLine());
                if (uniqueList.contains(id) || !validation.isAPositive(id)){
                    System.out.println("Retry! Must be unique and be a positive integer number");
                    continue;
                }
                
                uniqueList.add(id);
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }        
    }
    
    public String inputName(){
        while (true){
            try {
                System.out.print("Enter full name (max 50 characters): ");
                String name = sc.nextLine();
                if (name.length() > 49 || !validation.isNonEmpty(name)){
                    System.out.println("Invali (max 50 characters)!");
                    continue;
                }
                return name;
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        }
    }
    public double inputGPA(){
        while(true){
            try {
                System.out.print("Enter GPA (range 0.0 - 4.0): ");
                double gpa = Double.parseDouble(sc.nextLine());
                if (!validation.isAPositive(gpa) || gpa<0.0 || gpa>4.0){
                    System.out.println("Invalid (range 0.0 - 4.0)");
                    continue;
                }
                return gpa;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
    
    public void removeId(int id){
        uniqueList.remove(id);
    }
}
