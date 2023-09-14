package comp1110.ass2;

public class Assam {


    public static final char[] ASSAM_DIRECTION_CHARS = new char[] {'N','E','S','W'};

    public static final int[] ASSAM_DIRECTION_COORDS = new int[] {0,1,0,-1,0};
    private IntPair coord;

    private int orientation;

    /**
     * Sample Assam String A04N
     * A - assam
     * 0 - x coord
     * 4 - y coord
     * N - direction of Assam
     * @param assamString
     */
    public Assam(String assamString){
        if(assamString == null || assamString.length() < GameString.ASSAM_STRING_LENGTH || assamString.charAt(0) != GameString.ASSAM_CHAR)
            throw new IllegalArgumentException("Incorrect assam string");

        int x = Integer.parseInt(assamString.substring(1,2));
        int y = Integer.parseInt(assamString.substring(2,3));

        this.coord = new IntPair(x, y);
        this.orientation = 0;
        for (char dir : ASSAM_DIRECTION_CHARS) {
            if(assamString.charAt(3) == dir) break;
            this.orientation ++;
        }

        if(this.orientation > ASSAM_DIRECTION_CHARS.length) throw new IllegalArgumentException("Orientation not found!8");
    }

    // getter
    public IntPair getCoord() {return this.coord;}
    public char getOrientationChar() {return ASSAM_DIRECTION_CHARS[orientation];}
    public int getOrientation() {return this.orientation;};

    // setter
    public void setCord(IntPair newCoord) { this.coord = newCoord; }
    public void setOrientation(char newOrientation) {
        this.orientation = 0;
        for (char dir : ASSAM_DIRECTION_CHARS) {
            if(newOrientation == dir) break;
            this.orientation ++;
        }
    }

    public void updateMovement(int steps) {

        for (; steps > 0; steps--) {
            this.coord.x += ASSAM_DIRECTION_COORDS[this.orientation];
            this.coord.y -= ASSAM_DIRECTION_COORDS[this.orientation + 1];
//            System.out.println(ASSAM_DIRECTION_CHARS[this.orientation]);
//            System.out.println(this.coord);
            if (this.coord.x < 0) {
                if(this.coord.y == Board.BOARD_HEIGHT - 1) {
                    //if top left
                    this.orientation = 0; // W -> N
                } else {
                    this.orientation = 1; // W -> E
                    if(this.coord.y % 2 == 0) {
                        this.coord.y ++;
                    } else {
                        this.coord.y --;
                    }
                }
                this.coord.x = 0;
            }
            if (this.coord.x >= Board.BOARD_WIDTH) {
                if(this.coord.y == 0) {
                    //if top left
                    this.orientation = 2; // E -> S
                } else {
                    this.orientation = 3; // E -> W
                    if(this.coord.y % 2 == 0) {
                        this.coord.y --;
                    } else {
                        this.coord.y ++;
                    }
                }
                this.coord.x = Board.BOARD_WIDTH - 1;
            }
            if (this.coord.y < 0) {
                if(this.coord.x == Board.BOARD_WIDTH - 1) {
                    //if top left
                    this.orientation = 3; // N -> W
                } else {
                    this.orientation = 2; // N -> S
                    if(this.coord.x % 2 == 0) {
                        this.coord.x ++;
                    } else {
                        this.coord.x --;
                    }
                }
                this.coord.y = 0;
            }
            if (this.coord.y >= Board.BOARD_HEIGHT) {
                if(this.coord.x == 0) {
                    //if top left
                    this.orientation = 1; // S -> E
                } else {
                    this.orientation = 0; // S -> N
                    if(this.coord.x % 2 == 0) {
                        this.coord.x --;
                    } else {
                        this.coord.x ++;
                    }
                }
                this.coord.y = Board.BOARD_HEIGHT - 1;
            }

        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(GameString.ASSAM_CHAR).append(this.coord.x).append(this.coord.y)
                .append(ASSAM_DIRECTION_CHARS[this.orientation]).toString();
    }
}
