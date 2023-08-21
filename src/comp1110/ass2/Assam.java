package comp1110.ass2;

public class Assam {

    public IntPair cord;

    public char orientation;

    public Assam(String assamString){
        int x = Integer.parseInt(assamString.substring(1,2));
        int y = Integer.parseInt(assamString.substring(2,3));

        this.cord = new IntPair(x, y);
        this.orientation = assamString.charAt(3);
    }

    // getter
    public int getCord() {return 0;}
    public char getOrientation() {return 'a';}

    // setter
    public void setCord(IntPair newCord) { this.cord = newCord; }
    public void setOrientation(char newOrientation) { this.orientation = newOrientation; }

    public void getNewCordAfterMovement() {}


}
