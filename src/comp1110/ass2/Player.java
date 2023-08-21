
package comp1110.ass2;
public class Player {


    // player string example - Pr00814i
    public Color c;
    public int dirhams;

    public int remainingRugs;

    public char status;

    // example of player string - Pr00814o
    public Player(String playerString){

        char colorInChar =  playerString.charAt(1);
        for (Color c : Color.values()){
          if (c.equals(colorInChar)) {  this.c = c; }
        }

        this.dirhams = Integer.parseInt(playerString.substring(2, 5));
        this.remainingRugs = Integer.parseInt(playerString.substring(5, 7));
        this.status = playerString.charAt(7);

    }

    public  int caculateScores(int visualizedRug){
        return visualizedRug+dirhams;
    }

    // Getter methods
    public Color getColor() { return this.c; }


    // Setter methods

    public void updateDirhams(int amount) {
        this.dirhams += amount;
    }
    public void minusRug() { this.remainingRugs -= 1; }

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
        string.append(c);
        string.append(dirhams);
        string.append(remainingRugs);
        string.append(status);
        return string.toString();
    }



}


