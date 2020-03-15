/**
 * /**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/7/19 - Started and finished part 5 - Thomas Bahun
 * 12/03/19 - Updated to reflect improper do...while - Thomas Bahun
 * 11/30/19 - finished the read in method - Thomas Bahun
 * 04/19/2017 - Anne Applin - added documentation
 * 2015 - David Briggs - original starting code
 *********************************************************************
 * Driver for the project. 
 * PLEASE NOTE:  Use Unit testing to test your classes and 
 * ignore the errors in this file until you have all classes 
 * working. 
 */
package bullsandcows;
import java.util.*;
import java.io.*;
/**
 * The driver for the Holstein-Fresian Pedigree application.
 * @author aapplin
 */
public class BullsAndCows {
    // Properties of the class
    private static Database herdBook;
    /**
     * Displays a menu, asks for and reads a menu choice
     * This Method is complete - DO NOT CHANGE
     * @return an integer between 1 and 4 inclusive
     */
    public int getMenuChoice(){
        Scanner stdIn = new Scanner(System.in);
        int choice;
        do{
            System.out.print("*************************\n"
                           + "* 1. Print Pedigree     *\n"
                           + "* 2. Count Offspring    *\n"
                           + "* 3. Evaluate Offspring *\n"
                           + "* 4. Quit.              *\n"
                           + "*************************\n"
                           + "  Enter Choice --> ");
            choice = stdIn.nextInt();
        }while(choice < 1 || choice > 4);
        
        return choice;
    }

    /**
     *     YOU WRITE THIS ONE
     * Reads the input file and creates either a Bull or Cow
     * object and adds it to the Database
     * NOTE:
     * During development, we print out the full message of
     * the exception by using e.toString() and e.printStackTrace().
     * That is not recommended for production programs, since it 
     * gives hackers too much insight into the innards of the 
     * software, possibly allowing them to exploit it.Instead, 
     * production programs write error messages to internal 
     * log files that hackers wouldn't see.                 
     * @param h the Database object
     * @param fileName a String for the file that we want to 
     *                 use.
     */
    public void loadHerd(String fileName){
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File(fileName));            
            while (inputFile.hasNext()) { // read in one Animal
		Animal animal = null;
                // read the common, always there values
                String animalRegNum = inputFile.next();
                String sireRegNum = inputFile.next();
                String damRegNum = inputFile.next();
                char gender = inputFile.next().charAt(0);
                int dobMonth = inputFile.nextInt();
                int dobDay = inputFile.nextInt();
                int dobYear = inputFile.nextInt();
                String animalName = inputFile.next();
                // read a ClassificationScore 
                ClassificationScore score = null; 
                int month = inputFile.nextInt();
                if (month != -1) {
                    int day = inputFile.nextInt();
                    int year = inputFile.nextInt();
                    int generalAppearance = inputFile.nextInt();
                    int dairyCharacter = inputFile.nextInt();
                    int bodyCapacity = inputFile.nextInt();
                    if (gender == 'f') {
                        int mammarySystem = inputFile.nextInt();
                        score = new CowClassificationScore(month, day, year,
                            generalAppearance, dairyCharacter, bodyCapacity,
                            mammarySystem);
                    } else {
                        score = new BullClassificationScore(month, day, year,
                            generalAppearance, dairyCharacter, bodyCapacity);
                    }
                }
		// read production data 
                if (gender == 'f') {                    
                    ArrayList<LactationRecord> lacRec = null;
                    int mo = inputFile.nextInt();
	            if ( mo != -1){
  	               lacRec = new ArrayList<>();
                    }
                    while (mo != -1) {
                       int yr = inputFile.nextInt();
                       int days = inputFile.nextInt();
                       int pounds = inputFile.nextInt();
                       double pcentBF = inputFile.nextDouble();
                       lacRec.add(new LactationRecord(mo, yr, days,
                                         pounds, pcentBF));
                       // see if there is another record
                       mo = inputFile.nextInt();
                   } // end while mo != -1
                   animal = new Cow(animalRegNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, animalName, score, lacRec);
                } else { // it's a bull 
                    Proving proving = null;                   
                    int mo = inputFile.nextInt();
                    if (mo != -1) {
                        int da = inputFile.nextInt();
                        int yr = inputFile.nextInt();
                        int dtrs = inputFile.nextInt();
                        int recs = inputFile.nextInt();
                        int aveM = inputFile.nextInt();
                        double aveBFpcent = inputFile.nextDouble();
                        double exImp = inputFile.nextDouble();
                        proving = new Proving(mo, da, yr, dtrs, recs, aveM, 
                                 aveBFpcent, exImp);
                   } // end if
                    animal = new Bull(animalRegNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, animalName, score, proving);
                } // end else
                // add this current animal to the herdbook database
                herdBook.addToHerd(animalRegNum, animal);
            }// end while not end of file.
	    // comment the next line out when you start on part 5!
            // System.out.println(herdBook.printHerd());            
            inputFile.close();
        } catch (InputMismatchException e) {
            System.out.println("Probably using nextInt or nextDouble"
                    + " when the file input is not of that type.");
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Probably some problem with the input"
                    + " data file or the keyboard input.");
            System.out.println(e);
            e.printStackTrace();
        }       
    }

    /**
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it 
     * 
     *         Make no other changes.
     */
    public void printPedigree(){
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        System.out.println(herdBook.printPedigree(regNum));
        // System.out.println("not yet implemented.");        
    }

    /**
     * Extra Credit 1 Method 
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it
     * 
     *         Make no other changes.
     */
    public void countOffspring(){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        // System.out.println(herdbook.countOffspring(regNum);
        System.out.println("Not Implemented.");
    }

    /**
     * An Extra Credit 2 Method
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it 
     * 
     *             Make no other changes.
     * 
     */
    public void evaluateOffspring(){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        // System.out.println(herdbook.evaluateOffspring(regNum);
        System.out.println("Not implemented.");
    }
    /**
     * The actual driver for the application
     * This method is DONE - DO NOT CHANGE THIS
     * @param fileName comes from the command line arguments
     */
    public void run(String fileName){
        boolean finished = false;
        // create an instance of the Database
        herdBook = new Database();
        loadHerd(fileName);
        while (!finished) {
            int choice = getMenuChoice();
            switch(choice){
                case 1: printPedigree();     break;
                case 2: countOffspring();    break;
                case 3: evaluateOffspring(); break;
                case 4: finished = true;
            }                
        }//end while  
    } // end run
    /**
     * This method is DONE DO NOT CHANGE THIS
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: prog datafile");
            return;
        }
        // fileName from the command line arguments
        String fileName = args[0];        
        BullsAndCows driver = new BullsAndCows();
        driver.run(fileName);
    }
}
