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
    public Color getColor() {}
    public int getId() {}
    public IntPair getCoordinate() {}

    public int getTilePosition() {}

    // if tile is occupied, it returns true else false meaning tile is empty (no rugs on tile)
    public boolean isOccupied() {}


    // setter methods
    public void reset() {}

    public void setRug(Rug newRug) {}

    public String toString() {}

}
 