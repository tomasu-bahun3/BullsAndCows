/********************************************************
 * Revision History
 ********************************************************
 * 12/7/2019 - Started and finished part 5 - Thomas Bahun
 * 11/30/2019 - Worked on and finished part 4 - Thomas Bahun
 * 2014 - AA - skeleton written to prevent errors in the 
 *             driver.
 ********************************************************/
package bullsandcows;

import java.util.Map;
import java.util.TreeMap;

/**
 * Database of cows.  Please complete the documentation 
 * @author thomas
 */
public class Database {
    // Your implementation of everything goes here
    
    private Map<String, Animal> herd;

    /**
     * Constructor for the Database class
     * 
     * initializes the TreeMap herd
     */
    public Database() {
        this.herd = new TreeMap<>();
    }
    
    /**
     * Method addToHerd that takes the animal's regNum and 
     * adds it to the herd
     * 
     * @param regNum the animal's registration number
     * @param animal the animal
     */
    public void addToHerd(String regNum, Animal animal) {
        herd.put(regNum, animal);
    }
    
    /**
     * This method is for debugging part 4.  
     * You should iterate through your map to generate the output String
     * Look at BookStoreMap for an example of iterating over a map.  
     * @return a string that is the output of the entire herd as long as the
     *  herd isn't more than 13 animals.
     */
    public String printHerd(){
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line
        
        // as long as the herd is 13 animals or less
        if(herd.size() <= 13) {
            // iterate through the map
            for(String regNum:herd.keySet()) {
                // get and append an animal based on regsitration number
                str.append(herd.get(regNum)).append(eol);
            }
        } else { // otherwise its greater than 13 animals
            str.append("The herd contains more than 13 animals.");
        }
        
        return str.toString();
    }
    /**
     * Method to create a string that represents 2 generations of an animal's
     * ancestry.  If the Animal exists in the database, it is printed.  If
     * its dam is present it is printed as are the dam's parents if they 
     * exist.  If its sire is present it is printed as are the sire's 
     * parents if they exist.
     * @param regNum the registration number of the animal to evaluate
     * @return a two generation pedigree of the input animal if it exists
     *      or a string that says it does not exist.
     */
    public String printPedigree(String regNum){
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line
        Animal inputAnimal, dam, damDam, damSire, sire, sireDam, sireSire;
        
        if (herd.containsKey(regNum)) { // input animal exists
            // copy animals so as to only pull once, possibly null for some
            inputAnimal = herd.get(regNum);
            dam = herd.get(inputAnimal.getDamRegNum());
            if (dam != null) { // dam exists in database
                damDam = herd.get(dam.getDamRegNum());
                damSire = herd.get(dam.getSireRegNum());
            } else { // avoid nullpointer
                damDam = null;
                damSire = null;
            }
            sire = herd.get(inputAnimal.getSireRegNum());
            if (sire != null){ // sire exists in database
                sireDam = herd.get(sire.getDamRegNum());
                sireSire = herd.get(sire.getSireRegNum());
            } else { // avoid nullpointer
                sireDam = null;
                sireSire = null;
            }
            
            // input animal
            str.append("Data for the animal").append(eol);
            str.append(inputAnimal).append(eol);
            
            // dam
            str.append("Data for Dam").append(eol);
            
            if (dam != null){ // dam exists
                str.append(dam).append(eol);
                
                // damDam
                str.append("Data for Maternal Granddam").append(eol);
                
                if (damDam != null) {
                    str.append(damDam).append(eol);
                } else {
                    str.append("No data").append(eol);
                }
                
                // damSire
                str.append("Data for Maternal Grandsire").append(eol);
                
                if (damSire != null) {
                    str.append(damSire).append(eol);
                } else {
                    str.append("No data").append(eol);
                }
                
            } else { // no dam records
                str.append("No data for Dam, Maternal Granddam, "
                        + "or Maternal Grandsire")
                        .append(eol);
            }

            // sire
            str.append("Data for Sire").append(eol);
            
            if (sire != null){ // sire exists
                str.append(sire).append(eol);
                
                // sireDam
                str.append("Data for Paternal Granddam").append(eol);
                
                if (sireDam != null) { // sireDam exists
                    str.append(sireDam).append(eol);
                } else { // no sireDam
                    str.append("No data").append(eol);
                }
                
                // sireSire
                str.append("Data for Paternal Grandsire").append(eol);
                
                if (sireSire != null) { // sireSire exists
                    str.append(sireSire).append(eol);
                } else { // no sireSire
                    str.append("No data").append(eol);
                }
                
            } else { // no sire records
                str.append("No data for Sire, Paternal Granddam, "
                        + "or Paternal Grandsire")
                        .append(eol);
            }
            
        } else { // input animal doesn't exist
            str.append("Animal does not exist.").append(eol);
        }
        
        return str.toString();
    }
    /**
     *    EXTRA CREDIT 1
     * if you implement this, then change these comments and complete
     * the JavaDoc otherwise leave it ALL alone
     * @param regNum the registration number of the animal to evaluate
     * @return 
     */
    public String countOffspring(String regNum){
        return "Not yet implemented.";
    }
    /**
     *    EXTRA CREDIT 2
     * if you implement this, then change these comments and complete
     * the JavaDoc otherwise leave it ALL alone
     * @param regNum the registration number of the animal to evaluate
     * @return 
     */
    public String evaluateOffspring(String regNum){
        return "Not yet implemented.";
    }
}
