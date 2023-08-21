package comp1110.ass2;

public class Dice {

    private final int index;
    private final int num;

    public Dice(int index,int num){
        this.index=index;
        this.num=num;
    }

    public static final Dice[] DICE=new Dice[]{
            new Dice(1,1),
            new Dice(2,2),
            new Dice(3,2),
            new Dice(4,3),
            new Dice(5,3),
            new Dice(6,4),

    };

    public int getNumber(){
        return num;
    }

    public int getNumber2(int index){
        return DICE[index-1].getNumber();
    }

}