package comp1110.ass2;

public class Assam {
    public enum Direction{
        N(0),
        S(180),
        W(270),
        E(90);
        public final int value;

        Direction(int angle ){
            this.value=angle;
        }
    }

    public final int x;
    public final int y;

    public Direction d;

    public Assam(int x,int y,Direction d){
        this.x=x;
        this.y=y;
        this.d=d;
    }

    public int getX(){return x;}
    public int gety(){return y;}

    public int afterMovingX(int movingX){
        return movingX+x;
    }

    public int afterMovingY(int movingY){
        return movingY+y;
    }


}
