/**
 *                  Revision History (Newest First)
 * **************************************************************
 * 11/23/19 - Started and finished the Bull Class - Thomas Bahun
 */

package bullsandcows;

/**
 * Course: CSCI 160
 * Class Description: A class to represent a bull in the project
 * Project Name: BullsAndCows
 * Due Date: 11/23/19
 * Depends on:
 * Extends: Animal
 * Implements:
 * @author thomas
 */
public class Bull extends Animal{

    // propeties 
    private Proving proof;

    /**
     * Bull's parameterized constructor
     * 
     * @param registrationNum the bull's reg num
     * @param sireRegNum the sire's reg num
     * @param damRegNum the dam's reg num
     * @param gender the bull's gender
     * @param dobMonth the bull's month of birth
     * @param dobDay the bull's day of birth
     * @param dobYear the bull's year of birth
     * @param name the bull's name
     * @param classScore the bull's classification score (if exists)
     * @param proof the bull's proving
     */
    public Bull(String registrationNum, String sireRegNum, String damRegNum,
            char gender, int dobMonth, int dobDay, int dobYear,
            String name, ClassificationScore classScore, Proving proof) {
        super(registrationNum, sireRegNum, damRegNum, gender,
                dobMonth, dobDay, dobYear, name, classScore);
        this.proof = proof;
    }
    
    /**
     * toString method to build a str, format the contents, and return it
     * 
     * @return a formatted string with the bull's data
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line
        
        // content from Animal
        str.append(super.toString()).append(eol);
        
        // content from Bull
        str.append("Proof: ");
        
        if(proof == null) {
            str.append("n/a");
        } else {
            str.append(proof.toString());
        }
        
        return str.toString();
    }
}
