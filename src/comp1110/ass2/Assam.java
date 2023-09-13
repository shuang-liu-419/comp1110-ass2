package comp1110.ass2;

public class Assam {

    // Fields
    public IntPair cord;

    public char orientation;



    // Constructors
    public Assam(IntPair cord, char orientation) {
        this.cord = cord;
        this.orientation = orientation;
    }

    // Example of Assam string: A04N
    public Assam(String assamString){
        int x = Integer.parseInt(assamString.substring(1,2));
        int y = Integer.parseInt(assamString.substring(2,3));

        this.cord = new IntPair(x, y);
        this.orientation = assamString.charAt(3);
    }


    // Find the orientation after rotate
    public void newOrientation(){}



    // Update Assam's current cord
    public void getNewCordAfterMovement() {}



    // getter
    public IntPair getCord() {return cord;}
    public char getOrientation() {return '/';}

    // setter
    public void setCord(IntPair newCord) { this.cord = newCord; }
    public void setOrientation(char newOrientation) { this.orientation = newOrientation; }






}
