
package Utils;


public class Validation {
    
    public boolean isNonEmpty(String input){
        return !(input == null || input.trim().isEmpty());
    }
    
    public boolean isAPositive(double input){
        return input>0.0;
    }
    
   
}
