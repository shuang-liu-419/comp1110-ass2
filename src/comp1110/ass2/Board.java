package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public  class Board {

    public final static int BOARD_WIDTH = 7;
    public final static int BOARD_HEIGHT = 7;

    public final static int MAXIMUM_POSITION = BOARD_HEIGHT * BOARD_WIDTH;




//    private Tile[][] boardMatrix;
    private String[][] board;

    public Board(String boardString) {
        if (boardString == null || boardString.length() != GameString.BOARD_STRING_LENGTH || boardString.charAt(0) != GameString.BOARD_CHAR)
            throw new IllegalArgumentException("Incorrect board string!");

   // strip the B away from the board string
        boardString = boardString.substring(1);

        // initializing the matrix
        board = new String[BOARD_HEIGHT][BOARD_WIDTH];

        //string manipulation
        int pos = 0;

        for (int col = 0; col < BOARD_WIDTH; col++) {
            for (int row = 0; row < BOARD_HEIGHT; row++) {
                board[row][col] = boardString.substring( pos, pos + 3);
                pos += 3;
            }
        }



//
//        // initializing the matrix
//        boardMatrix = new Tile[BOARD_HEIGHT][BOARD_WIDTH];
//
//        if (boardStringWithoutB.length() != 3 * MAXIMUM_POSITION) {
//            throw new IllegalArgumentException("Invalid board string length!");
//        }
//
//        int position = 0;
//        for (int row = 0; row < BOARD_HEIGHT; row++) {
//            for (int col = 0; col < BOARD_WIDTH; col++) {
//
//                String abbrSubString = boardStringWithoutB.substring(position, position + 3);
//                Tile newTile = new Tile (abbrSubString, row, col);
//
//                boardMatrix[row][col] = newTile;
//                position += 3; // update the position to be indexed from the board string
//
//            }
//        }
    }

    public Board() {
        board = new String[BOARD_HEIGHT][BOARD_WIDTH];
        for(String[] row : board)
            Arrays.fill(row, GameString.RUG_DEFAULT_STRING);
    }

    // getters
//    public Tile getTile() {
//        return new Tile("",0,0); }

    // other helpers
    public String toString() {
        if(board == null) return "NO BOARD";

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                sb.append(board[row][col]).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public String toBoardString() {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < BOARD_WIDTH; col++)
            for (int row = 0; row < BOARD_HEIGHT; row++) {
             {
                sb.append(board[row][col]);
            }
        }
        return sb.toString();
    }

    public int getAllVisibleRugs(Color color) {
        int count = 0;
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (checkRug(col, row, color)) count++;
            }
        }
        return count;
    }

    public boolean containsSameRug(Color color, int id) {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (checkRug(col, row, color) && checkRugID(col, row, id)) return true;
            }
        }
        return false;
    }

    public boolean containsSameRug(String rug) {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (rug.equals(board[row][col])) return true;
            }
        }
        return false;
    }

    /**
     * find number of connecting carpet with given color
     * @param x
     * @param y
     * @param color
     * @return
     */
    public int getConnectingRugs(int x, int y, Color color) {
        //edge case
        if (board == null) return 0;

        String target = board[y][x];
        boolean[][] checks = new boolean[BOARD_HEIGHT][BOARD_WIDTH];

        return checkRugs(checks, x, y, color);
    }

    /**
     * checks 4 dir
     * @param checks
     * @param x
     * @param y
     * @return
     */
    private int checkRugs(boolean[][] checks, int x, int y, Color color) {
        //edge case
        if(x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) return 0;

        //if already checked
        if(checks[y][x]) return 0;

        int count = 0;

        checks[y][x] = true;
        if(checkRug(x,y,color)) {
            count ++;
        } else {
            return 0; //return 0 if its disconnected / diff color
        }

        //check 4 dir recursively
        for(int i = 0; i < 4; i++) {
            count += checkRugs(checks, x + Assam.ASSAM_DIRECTION_COORDS[i],
                    y + Assam.ASSAM_DIRECTION_COORDS[i + 1], color);
        }

        return count;
    }

    private boolean checkRug(int x, int y, Color color) {
        return getTileColor(x,y) == color;
    }

    private boolean checkRugID(int x, int y, int id) {
        return Integer.parseInt(board[y][x].substring(1)) == id;
    }


    public Color getTileColor(int x, int y) {
        return Color.toColor(board[y][x].charAt(0));
    }
}
