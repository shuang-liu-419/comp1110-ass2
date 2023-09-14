package comp1110.ass2;

public class Rug {

   private Color color;
   private String id;
   private IntPair coord1;
   private IntPair coord2;

    /**
     * Sample Rug p014445
     * p
     * 01
     * 44
     * 45
     * @param rugString
     */
    public Rug(String rugString) {
        if(rugString == null || rugString.length() < GameString.RUG_STRING_LENGTH)
            throw new IllegalArgumentException("Incorrect rug string");

        this.color = Color.toColor(rugString.charAt(0));

        this.id = rugString.substring(1,3);

        int x1 = Integer.parseInt(rugString.substring(3,4));
        int y1 = Integer.parseInt(rugString.substring(4,5));
        this.coord1 = new IntPair(x1,y1);

        int x2 = Integer.parseInt(rugString.substring(5,6));
        int y2 = Integer.parseInt(rugString.substring(6,7));
        this.coord2 = new IntPair(x2,y2);

    }

    // getter
    public Color getColor() {return this.color;}
    public String getID() {return "";}
    public IntPair getCoord1() {return new IntPair(0,0);}
    public IntPair getCoord2() {return new IntPair(0,0);}

    // setter
    public void setColor(Color newColor) {this.color = newColor;}
    public void setID (String newID) {this.id = newID;}
    public void setNewCoord(IntPair coord1, IntPair coord2){this.coord1 = coord1; this.coord2 = coord2;}

    public boolean isCoordValid() {
        return !(coord1.x < 0 || coord1.x >= Board.BOARD_WIDTH || coord1.y < 0 || coord1.y >= Board.BOARD_HEIGHT ||
                coord2.x < 0 || coord2.x >= Board.BOARD_WIDTH || coord2.y < 0 || coord2.y >= Board.BOARD_HEIGHT);
    }

    // other helpers
    public String toString(){
        return "";
    }

}
