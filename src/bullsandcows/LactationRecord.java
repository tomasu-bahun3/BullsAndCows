/***************************************************************
 *                Revision History (Newest First)
 * *************************************************************
 *  11/09/2019 - Started and finished the class - Thomas Bahun
 **************************************************************/

package bullsandcows;

import java.util.ArrayList;

/**
 * Course: CSCI 160
 * Class Description: A class to represent a cow's lactation record
 * Project Name: BullsAndCows
 * Due Date: 11/09/2019
 * Depends on: 
 * Extends:
 * Implements:
 * @author thomas
 */
public class LactationRecord {
    
    
    // input properties
    private int yearsAtCalving;
    private int monthsAtCalving;
    private int daysInMilk;
    private int lbsMilk;
    private double percButterfat;
    
    // calculated properties
    private int totalButterfat;

    /**
     * Parameterized constructor that also calculates the total butterfat
     * @param yearsAtCalving the years at calving
     * @param monthsAtCalving the months at calving
     * @param daysInMilk the days in milk
     * @param lbsMilk the lbs of milk
     * @param percButterfat the percentage of butterfat
     */
    public LactationRecord(int yearsAtCalving, int monthsAtCalving,
            int daysInMilk, int lbsMilk, double percButterfat) {
        this.yearsAtCalving = yearsAtCalving;
        this.monthsAtCalving = monthsAtCalving;
        this.daysInMilk = daysInMilk;
        this.lbsMilk = lbsMilk;
        this.percButterfat = percButterfat;
        
        // calculated property
        this.totalButterfat = (int)(lbsMilk * (percButterfat/100));
    }

    /**
     * Builds and returns a formatted string with the lactation record
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String tempStr = "";
        
        // date (years)
        tempStr = String.format("%02d", yearsAtCalving);
        str.append(tempStr).append("-");
        // date (months)
        tempStr = String.format("%02d", monthsAtCalving);
        str.append(tempStr).append(" ");
        
        // days in milk
        tempStr = String.format("%4d", daysInMilk);
        str.append(tempStr).append(" ");
        
        // lbs of milk
        tempStr = String.format("%6d", lbsMilk);
        str.append(tempStr).append(" ");
        
        // percentage of butterfat
        tempStr = String.format("%2.2f", percButterfat);
        str.append(tempStr).append(" ");
        
        // total butterfat
        tempStr = String.format("%3d", totalButterfat);
        str.append(tempStr);
        
        // returns the formatted str as a string
        return str.toString();
    }
    
    /*
     * Unit Test for LactationRecord Copy this into LactationRecord and use 
     *    Run File to test it.
     */
     public static void main(String[] args){
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 10, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 3290, 4.0));
        lacRecs.add(new LactationRecord(4, 5, 260, 266, 3.2));
        System.out.println("Milk Records");
        for(LactationRecord record: lacRecs){
            System.out.println(record);
        }
    } // end Unit Test
}