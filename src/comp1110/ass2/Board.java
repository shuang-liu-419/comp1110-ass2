package comp1110.ass2;

public  class Board {

    // Fields
    public final static int BOARD_WIDTH = 7;
    public final static int BOARD_HEIGHT = 7;
    public final static int MAXIMUM_POSITION = BOARD_HEIGHT * BOARD_WIDTH;
    private Tile[][] boardMatrix;



    // Constructors
    public Board(Tile[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
    }

    // to substring the boardString
    public Board(String boardString) {

        // strip the B away from the board string
        String boardStringWithoutB = boardString.substring(1);

        // initializing the matrix
        boardMatrix = new Tile[BOARD_HEIGHT][BOARD_WIDTH];

        // Check if the board is valid
        if (boardStringWithoutB.length() != 3 * MAXIMUM_POSITION) {
            throw new IllegalArgumentException("Invalid board string length!");
        }

        //
        int position = 0;
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {

                String abbrSubString = boardStringWithoutB.substring(position, position + 3);
                Tile newTile = new Tile (abbrSubString, row, col);

                boardMatrix[row][col] = newTile;
                position += 3; // update the position to be indexed from the board string

            }
        }
    }



    // getters
    public Tile getTile() {
        return new Tile("",0,0); }

    // other helpers
    public String toString() {return " ";}


}
