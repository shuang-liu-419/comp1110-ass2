package comp1110.ass2;

import java.util.ArrayList;
import java.util.StringJoiner;

public class GameString {

    public static final int PLAYER_STRING_LENGTH = 8;
    public static final char PLAYER_CHAR = 'P';
    public static final char PLAYER_IN_GAME_CHAR = 'i';
    public static final char PLAYER_OUT_GAME_CHAR = 'o';

    public static final int ASSAM_STRING_LENGTH = 4;
    public static final char ASSAM_CHAR = 'A';

    public static final int BOARD_STRING_LENGTH = 148;
    public static final char BOARD_CHAR = 'B';

    public static final int RUG_STRING_LENGTH = 7;
    public static final int RUG_SHORT_STRING_LENGTH = 3;

    public static final String RUG_DEFAULT_STRING = "n00";

    private String gameString;

    private ArrayList<String> playerStrings;
    private String assamString;
    private String boardString;

    // example of gamestring - Pr01214i + Pr01214i + A04E + B(3 * 49)
    public GameString(String string) {
        int stringLength = string.length();

        //test if string too short or does not contain correct player length
        if (stringLength < PLAYER_STRING_LENGTH * 2 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH || (stringLength - ASSAM_STRING_LENGTH - BOARD_STRING_LENGTH) % PLAYER_STRING_LENGTH != 0)
        { throw new IllegalArgumentException("Illegal length of string parsed  into gamestring constructor."); }

        this.gameString = string;

        //calculate player numbers
        int numOfPlayers = (stringLength - ASSAM_STRING_LENGTH - BOARD_STRING_LENGTH) / PLAYER_STRING_LENGTH;

        playerStrings = new ArrayList<>();
        int i;
        for (i = 0; i < numOfPlayers; i ++) {
            playerStrings.add(string.substring(i * 8, (i + 1) * 8));
        }

        this.assamString = string.substring(i * 8, i * 8 + ASSAM_STRING_LENGTH);

        this.boardString = string.substring(i * 8 + ASSAM_STRING_LENGTH);

    }

    // getter methods


    public ArrayList<String> getPlayerStrings() {
        return playerStrings;
    }

    public String getPlayerStr() {
        StringBuilder sb = new StringBuilder();
        playerStrings.forEach(sb::append);
        return sb.toString();
    }

    public String getPlayerString(int playerNum) {
        if(playerNum >= playerStrings.size()) throw new IllegalArgumentException("Player Number Exceeded maximum player");
        return playerStrings.get(playerNum);
    }

    public String getAssamString() {return this.assamString;}
    public String getBoardString() {return this.boardString;}

    public void setPlayerStrings(ArrayList<String> playerStrings) {
        this.playerStrings = playerStrings;
    }

    public void setPlayerString(String playerString, int playerNum ) {

        this.playerStrings.set(playerNum, playerString);
    }

    public void setAssamString(String assamString) {
        this.assamString = assamString;
    }

    public void setBoardString(String boardString) {
        this.boardString = boardString;
    }

    // other helper methdos
    @Override
    public String toString() {
        return new StringBuilder().append(getPlayerStr()).append(assamString).append(boardString).toString();
    }

}
