package comp1110.ass2;

public class GameString {

    private static final int PLAYER_STRING_LENGTH = 8;
    private static final int ASSAM_STRING_LENGTH = 4;
    private static final int BOARD_STRING_LENGTH = 148;
    private String p1String;
    private String p2String;
    private String p3String;
    private String p4String;
    private String assamString;
    private String boardString;

    // example of gamestring - Pr01214i + Pr01214i + A04E + B(3 * 49)
    public GameString(String string) throws IllegalAccessException {

        if (string.length() < PLAYER_STRING_LENGTH * 2 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH
                || string.length() > PLAYER_STRING_LENGTH * 2 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH)
        { throw new IllegalAccessException("Illegal length of string parsed  into gamestring constructor."); }

        this.p1String = string.substring(0, 8);
        this.p2String = string.substring(8, 16);

        int stringLength = string.length();

        // 2 players
        if (stringLength == PLAYER_STRING_LENGTH * 2 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH){
            this.assamString = string.substring(16,20);
            this.boardString = string.substring(20);
        }

        // 3 players
        if (stringLength == PLAYER_STRING_LENGTH * 3 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH){
            this.p3String = string.substring(16, 24);
            this.assamString = string.substring(24, 28);
            this.boardString = string.substring(28);
        }

        // 4 player
        if (stringLength == PLAYER_STRING_LENGTH * 4 + ASSAM_STRING_LENGTH + BOARD_STRING_LENGTH){
            this.p3String = string.substring(16, 24);
            this.p4String = string.substring(24, 32);
            this.assamString = string.substring(32, 36);
            this.boardString = string.substring(36);
        }

    }

    // getter methods
    public String getPlayer1String() { return this.p1String; }
    public String getPlayer2String() {return "";}
    public String getPlayer3String() {return "";}
    public String getPlayer4String() {return "";}
    public String getAssamString() {return "";}
    public String getBoardString() {return "";}

    // setter methods
    public void setNewPlayerString(String newPlayerString) {}
    public void setNewRugString(String newRugString){}
    public void setNewBoardString(String newBoardString){}


    // toString
    @Override
    public String toString() {
        return "GameString{" +
                "p1String='" + p1String + '\'' +
                ", p2String='" + p2String + '\'' +
                ", p3String='" + p3String + '\'' +
                ", p4String='" + p4String + '\'' +
                ", assamString='" + assamString + '\'' +
                ", boardString='" + boardString + '\'' +
                '}';
    }
}
