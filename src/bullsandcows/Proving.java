/***************************************************************
 *                Revision History (Newest First)
 * *************************************************************
 *  11/08/2019 - Started and finished the class - Thomas Bahun
 **************************************************************/

package bullsandcows;

/**
 * Course: CSCI 160
 * Class Description: A class to represent a bull's proving
 * Project Name: BullsAndCows
 * Due Date: 11/09/2019
 * Depends on:
 * Extends:
 * Implements:
 * @author thomas
 */
public class Proving {
    
    // input properties
    private int dayOfProving;
    private int monthOfProving;
    private int yearOfProving;
    private int numDaughters;
    private int numProductionRecords;
    private int avgLbsMilk;
    private double percButterfat;
    private double expImp;
    
    // calculated properties
    private int avgLbsButterfat;

    /**
     * Parameterized Constructor that also calculates the avgLbsButterfat
     * @param dayOfProving the day of the proving
     * @param monthOfProving the month of the proving
     * @param yearOfProving the year of the proving 
     * @param numDaughters the number of daughters of the bull
     * @param numProductionRecords the number of records used
     * @param avgLbsMilk the average lbs of milk
     * @param percButterfat the percentage of butterfat
     * @param expImp the expected increase
     */
    public Proving(int dayOfProving, int monthOfProving, int yearOfProving,
            int numDaughters, int numProductionRecords, int avgLbsMilk,
            double percButterfat, double expImp) {
        this.dayOfProving = dayOfProving;
        this.monthOfProving = monthOfProving;
        this.yearOfProving = yearOfProving;
        this.numDaughters = numDaughters;
        this.numProductionRecords = numProductionRecords;
        this.avgLbsMilk = avgLbsMilk;
        this.percButterfat = percButterfat;
        this.expImp = expImp;
        
        // calculated properties
        this.avgLbsButterfat = (int) (avgLbsMilk * (percButterfat/100));
    }

    /**
     * toString method that builds and returns the string for the proving
     * @return the formatted str as as string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator();
        String tempStr = "";
        
        // date (day)
        tempStr = String.format("%02d", dayOfProving);
        str.append("Date = ").append(tempStr).append("-");
        
        // date (month)
        tempStr = String.format("%02d", monthOfProving);
        str.append(tempStr).append("-");
        
        // date (year)
        str.append(yearOfProving).append(eol);
        
        // number of daughters and records
        str.append("Dtrs = ").append(numDaughters).append("  ")
                .append("Records = ").append(numProductionRecords)
                .append(eol);
        
        // average lbs of milk
        str.append("AvgMilk = ").append(avgLbsMilk).append("  ");
        
        // percentage of butterfat and average butterfat
        tempStr = String.format("%.2f", percButterfat);
        str.append("AvgBf% = ").append(tempStr).append("  ")
                .append("AvgBF = ").append(avgLbsButterfat)
                .append(eol);
        
        // the expected increase or not
        tempStr = String.format("%+.2f", expImp);
        str.append("ExImp = ").append(tempStr);

        // returns the formatted string
        return str.toString();
        
    }
    
    /*
     * Unit Test for Proving  Copy this into Proving and use Run File to 
     *   to test it.
     */
    public static void main (String[] args){
        Proving proof1 = new Proving(6, 6, 1920, 93, 180, 15894, 3.4, -476.8);
        Proving proof2 = new Proving(6, 6, 1920, 93, 180, 15894, 3.4, 476.8);
        System.out.println(proof1);
        System.out.println();
        System.out.println(proof2);
    } 
    
}