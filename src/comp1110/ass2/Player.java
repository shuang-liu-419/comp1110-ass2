
package comp1110.ass2;
public class Player {


    // player string example - Pr00814i


    private Color color;
    private int dirhams;

    private int remainingRugs;

    private boolean isInGame;

    // example of player string - Pr00814o
    public Player(Color color, int dirhams, int remainingRugs, boolean isInGame ){
        this.color = color;
        this.dirhams = dirhams;
        this.remainingRugs = remainingRugs;
        this.isInGame = isInGame;
    }

    public Player(String playerString) {
        if(playerString == null || playerString.length() < GameString.PLAYER_STRING_LENGTH || playerString.charAt(0) != GameString.PLAYER_CHAR) {
            throw new IllegalArgumentException("Incorrect player string!");
        }

        // parse from gameString
        this.color = Color.toColor(playerString.charAt(1));

        this.dirhams = Integer.parseInt(playerString.substring(2, 5));
        this.remainingRugs = Integer.parseInt(playerString.substring(5, 7));
        this.isInGame = playerString.charAt(7) == GameString.PLAYER_IN_GAME_CHAR;
    }

    public  int calculateScores(int visualizedRug){
        return visualizedRug+dirhams;
    }

    // Getter methods
    public Color getColor() { return this.color; }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDirhams() {
        return dirhams;
    }

    public void setDirhams(int dirhams) {
        this.dirhams = dirhams;
    }

    public int getRemainingRugs() {
        return remainingRugs;
    }

    public void setRemainingRugs(int remainingRugs) {
        this.remainingRugs = remainingRugs;
    }

    public boolean isInGame() {
        return isInGame;
    }

    public void setInGame(boolean inGame) {
        isInGame = inGame;
    }
    // Setter methods

    public void addDirhams(int amount) {
        this.dirhams += amount;
    }
    public void deductRug() { this.remainingRugs -= 1; }

    public void changeStatusToOut() throws IllegalAccessException {
        if(!isInGame) return;
        isInGame = false;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(GameString.PLAYER_CHAR);
        stringBuilder.append(color);
        stringBuilder.append(dirhams);
        stringBuilder.append(remainingRugs);
        stringBuilder.append(isInGame ? GameString.PLAYER_IN_GAME_CHAR : GameString.PLAYER_OUT_GAME_CHAR);
        return stringBuilder.toString();
    }



}


