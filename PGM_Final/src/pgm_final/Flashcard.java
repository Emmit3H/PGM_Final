package pgm_final;
/**
 * <h1>Flashcard Class</h1>
 * The flashcard class hold the data for a 2 sided flashcard that can be displayed in a simple GUI using a pane
 * <h2>Data fields</h2>
 * String side1 - Stores data for one side of the flashcard
 * String side2 - Stores data for a second side of a flashcard
 * @author angel
 */
public class Flashcard{
    //INITIALIZED CLASS VARIABLES-----------------------------------------------
    private String side1,side2;
    //CLASS CONSTRUCTORS--------------------------------------------------------
    /**
     *Default class constructor
     */
    public Flashcard(){
    }
    /**
     *Parameterized class constructor
     * @param side1
     * String - information for side 1
     * @param side2
     * String - information for side 2
     */
    public Flashcard(String side1,String side2){
        this.side1=side1;
        this.side2=side2;
    }
    //GETTERS AND SETTERS-------------------------------------------------------
    /**
     * Returns side1
     * @return
     * String - the data from side1
     */
    public String getSide1(){
        return side1;
    }
    /**
     *Sets side1
     * @param side1
     * String - value to pass into slide1
     */
    public void setSide1(String side1){
        this.side1=side1;
    }
    /**
     * Getter for side2
     * @return
     * String - the data from side2
     */
    public String getSide2(){
        return side2;
    }
    /**
     * Setter for side2
     * @param side2
     * String - data to pass into side2
     */
    public void setSide2(String side2){
        this.side2=side2;
    }
    //TOSTRING VARIABLE---------------------------------------------------------
    /**
     * Prints output for the class
     * @return
     * String - all side1 and side2 contents
     */
    @Override
    public String toString(){
        return "<<Side 1: "+side1+">> <<Side 2: "+side2+">>";
    }
}