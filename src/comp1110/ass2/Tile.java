package comp1110.ass2;

public class Tile {
    private Color character;
    private int id;
    boolean isOccupied = false;
    private final IntPair coordinate;

    Tile(String abbrString, int x, int y) {

        // update abbrString
        char cColor = abbrString.charAt(0);
        for (Color c : Color.values()) {
            if (c.getColor() == cColor) {
                this.character = c;
                this.isOccupied = true;
            }
        }

        this.id = Integer.parseInt(abbrString.substring(1,3));

        this.coordinate = new IntPair(x, y);

    }


    // getter methods
    public Color getColor() {return Color.CYAN;}
    public int getId() {return 0;}
    public IntPair getCoordinate() {return new IntPair(0,0);}

    public int getTilePosition() {return 0;}

    // if tile is occupied, it returns true else false meaning tile is empty (no rugs on tile)
    public boolean isOccupied() {return false;}


    // setter methods
    public void reset() {}

    public void setRug(Rug newRug) {}

    public String toString() {return "";}

}
 