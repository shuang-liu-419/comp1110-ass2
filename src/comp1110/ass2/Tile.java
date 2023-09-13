package comp1110.ass2;

public class Tile {

    // Fields
    private Color character;
    private int id;
    boolean isOccupied = false;
    private final IntPair coordinate;



    // Constructors
    Tile(String abbrString, int x, int y) {

        // Update abbrString
        char cColor = abbrString.charAt(0);
        for (Color c : Color.values()) {
            if (c.getColor() == cColor) {
                this.character = c;
                this.isOccupied = true;
            }
        }

        // Abbreviated rug id
        this.id = Integer.parseInt(abbrString.substring(1,3));
        // New (x, y)
        this.coordinate = new IntPair(x, y);
    }




    // Check if the tile is covered
    public boolean isOccupied() {return false;}

    // Check the visible color of the covered tile
    public Color getColor() {return character;}

    // The rug id of the visible color
    public int getId() {return id;}

    // Find the coordinate of each occupied piece
    public IntPair getCoordinate() {return new IntPair(0,0);}



    // public int getTilePosition() {return 0;}




    // setter methods
    public void reset() {}

    public void setRug(Rug newRug) {}




    public String toString() {return "";}

}
 