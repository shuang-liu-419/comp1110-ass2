
package comp1110.ass2;
public class Player {


    // Fields
    private Color rugColor;
    private int dirhams;
    private int remainingRugs;
    private char status;


    // Constructors
    public Player(Color rugColor, int dirhams, int remainingRugs, char status) {
        this.rugColor = rugColor;
        this.dirhams = dirhams;
        this.remainingRugs = remainingRugs;
        this.status = status;
    }

    // player string example - Pr00814i
    // to substring the playerString
    public Player (String playerString){

        char color = playerString.charAt(0);
        this.rugColor = Color.getColorFromChar(color);
        this.dirhams = Integer.parseInt(playerString.substring(2, 5));
        this.remainingRugs = Integer.parseInt(playerString.substring(5, 7));
        this.status = playerString.charAt(7);
    }

    //        char colorInChar =  playerString.charAt(1);
    //        for (Color c : Color.values()){
    //          if (c.equals(colorInChar)) {
    //              this.rugColor = c; }
    //        }


    // Calculate the final score: visible rug + dirhams
    public int calculateScores(int visualizedRug){
        return visualizedRug+dirhams;
    }


    // Getter methods
    public Color getColor() { return this.rugColor; }


    // Setter methods


    // Calculate the current dirhams: + adjacent rugs amount
    public void updateDirhams(int amount) {
        this.dirhams += amount;
    }


    // Count the current remaining rugs
    public void minusRug() { this.remainingRugs -= 1; }


    // Check current status
    public void changeStatusToOut() throws IllegalAccessException {
        if (status == 'i') {
            status = 'o';
        }
        else {
            throw new IllegalAccessException("Player is already out of game. Can't change their status");
        }

    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(rugColor);
        string.append(dirhams);
        string.append(remainingRugs);
        string.append(status);
        return string.toString();
    }



}


