package comp1110.ass2;

public class Rug {

   private Color color;
   private String id;
   private IntPair cord1;
   private IntPair cord2;

    Rug(String rugString) {

        char cColor = rugString.charAt(0);
        for (Color c : Color.values()) {
            if (c.getColor() == cColor) {
                this.color = c;
            }
        }

        this.id = rugString.substring(1,3);

        int x1 = Integer.parseInt(rugString.substring(3,4));
        int y1 = Integer.parseInt(rugString.substring(4,5));
        this.cord1 = new IntPair(x1,y1);

        int x2 = Integer.parseInt(rugString.substring(5,6));
        int y2 = Integer.parseInt(rugString.substring(6,7));
        this.cord2 = new IntPair(x2,y2);

    }

    /**
     * all of the visible squares with the same color
     */
    public Rug visibleRug(){

        return visibleRug();
    }

    // getter
    public Color getColor() {return this.color;}
    public String getID() {return "";}
    public IntPair getCord1() {return new IntPair(0,0);}
    public IntPair getCord2() {return new IntPair(0,0);}

    // setter
    public void setColor(Color newColor) {}
    public void setID (String newID) {}
    public void setNewCord(IntPair newCord){}

    // other helpers
    public String toString(){
        return "";
    }

}
