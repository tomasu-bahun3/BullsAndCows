/**
 *                  Revision History (Newest First)
 * **************************************************************
 * 11/17/19 - Started and finished the Animal Class - Thomas Bahun
 * 
 */

package bullsandcows;

import java.util.ArrayList;

/**
 * Course: CSCI 160
 * Class Description: A class to represent an animal, generalizing bulls/cows
 * Project Name: BullsAndCows
 * Due Date: 11/16/19
 * Depends on:
 * Extends:
 * Implements:
 * @author thomas
 */
public abstract class Animal {
    
    // properties
    protected String registrationNum;
    protected String sireRegNum;
    protected String damRegNum;
    protected char gender;
    protected int dobMonth;
    protected int dobDay;
    protected int dobYear;
    protected String name;
    protected ClassificationScore classScore;

    /**
     * Animal's parameterized constructor
     * 
     * @param registrationNum the animal's reg num
     * @param sireRegNum the sire's reg num
     * @param damRegNum the dam's reg num
     * @param gender the animal's gender
     * @param dobMonth the animal's month of birth
     * @param dobDay the animal's day of birth
     * @param dobYear the animal's year of birth
     * @param name the animal's name
     * @param classScore the animal's classification score (if exists)
     */
    public Animal(String registrationNum, String sireRegNum, String damRegNum,
            char gender, int dobMonth, int dobDay, int dobYear, String name,
            ClassificationScore classScore) {
        this.registrationNum = registrationNum;
        this.sireRegNum = sireRegNum;
        this.damRegNum = damRegNum;
        this.gender = gender;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        this.name = name;
        this.classScore = classScore;
    }

    /**
     * Getter for the sireRegNum
     * 
     * @return the sireRegNum
     */
    protected String getSireRegNum() {
        return sireRegNum;
    }

    /**
     * Getter for the damRegNum
     * 
     * @return the damRegNum
     */
    protected String getDamRegNum() {
        return damRegNum;
    }

    /**
     * toString method to build a str, format the contents, and return it
     * 
     * @return a formatted string with the animal's data
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line
        String tempStr = ""; // temporary string to hold dod contents
        
        // regNum
        str.append("Registration Number: " + registrationNum).append(eol);
        
        // name
        str.append("Name: " + name).append(eol);
        
        // dodMonth
        tempStr = String.format("%02d", dobMonth);
        str.append("Born: " + tempStr).append("-");
        
        // dodDay
        tempStr = String.format("%02d", dobDay);
        str.append(tempStr).append("-");
        
        // dodYear
        str.append(dobYear).append(eol);
        
        // classification
        if (classScore != null) {
            str.append("Classification: ").append(classScore);
        } else {
            str.append("Classification: n/a");
        }
        
        // return the animal's str
        return str.toString();
    }
    
    /**
     * Unit Tester for Animal, Cow and Bull.  Copy this into Animal to unit
     *  test both Cow and Bull. 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ClassificationScore 
                perfectCow = new CowClassificationScore(1, 2, 2010, 30, 20, 20, 30),
                nullCow = null,
                perfectBull = new BullClassificationScore(5, 6, 2012, 40, 30, 30),
                nullBull = null;

        Proving noProving = null,
                proving = new Proving(6, 4, 2016, 20, 200,
                        1500, 3.25, 324);
        ArrayList<LactationRecord> empty = null;
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 10, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 13290, 4.0));
        lacRecs.add(new LactationRecord(4, 3, 260, 19266, 3.2));
        Animal bull1 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "aBull", perfectBull, noProving);
        Animal bull2 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "anotherBull", nullBull, proving);
        Animal cow1 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "aCow", perfectCow, empty);
        Animal cow2 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "anotherCow", nullCow, lacRecs);
        System.out.println(bull1);
        System.out.println();
        System.out.println(bull2);
        System.out.println();
        System.out.println(cow1);
        System.out.println();
        System.out.println(cow2);
    }
}
