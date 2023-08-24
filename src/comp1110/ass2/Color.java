package comp1110.ass2;

public enum Color {

    CYAN('c'),
    YELLOW('y'),
    PURPLE('p'),
    RED('r');

    public final char color;


    Color(char color) {
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }


}
