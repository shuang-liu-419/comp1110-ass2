package comp1110.ass2;

public enum Color {

    CYAN('c'),
    YELLOW('y'),
    PURPLE('p'),
    RED('r');

    public char color;


    Color(char color) {
        this.color = color;
    }
    public static Color getColorFromChar(char color) {
        if (color == 'c') return CYAN;
        if (color == 'y') return YELLOW;
        if (color == 'p') return PURPLE;
        if (color == 'r') return RED;
        else return null;
    }
    public char getColor() {
        return this.color;
    }


}
