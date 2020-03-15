/**
 *                  Revision History (Newest First)
 * **************************************************************
 * 11/23/19 - Started and finished the Cow Class - Thomas Bahun
 */

package bullsandcows;

import java.util.ArrayList;

/**
 * Course: CSCI 160
 * Class Description: A class to represent a cow in the project
 * Project Name: BullsAndCows
 * Due Date: 11/23/19
 * Depends on:
 * Extends: Animal
 * Implements:
 * @author thomas
 */
public class Cow extends Animal {
    
    // propeties
    private ArrayList<LactationRecord> lacRecord;

    /**
     * Cow's parameterized constructor
     * 
     * @param registrationNum the cow's reg num
     * @param sireRegNum the sire's reg num
     * @param damRegNum the dam's reg num
     * @param gender the cow's gender
     * @param dobMonth the cow's month of birth
     * @param dobDay the cow's day of birth
     * @param dobYear the cow's year of birth
     * @param name the cow's name
     * @param classScore the cow's classification score (if exists)
     * @param lacRecord the cow's lactation records in a list
     */
    public Cow(String registrationNum, String sireRegNum, String damRegNum,
            char gender, int dobMonth, int dobDay, int dobYear, String name,
            ClassificationScore classScore,
            ArrayList<LactationRecord> lacRecord) {
        super(registrationNum, sireRegNum, damRegNum, gender,
                dobMonth, dobDay, dobYear, name, classScore);
        this.lacRecord = lacRecord;
    }
    
    /**
     * toString method to build a str, format the contents, and return it
     * 
     * @return a formatted string with the cow's data
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line
        
        // content from Animal
        str.append(super.toString()).append(eol);
        
        // content from Cow
        str.append("Milk Records:").append(eol);
        
        if(lacRecord == null) {
            str.append("No milk records");
        } else {
            str.append(lacRecord.toString());
        }
        
        return str.toString();
    }
}
