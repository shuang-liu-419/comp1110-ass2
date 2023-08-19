package comp1110.ass2;

public  class Board {
    private final Rug.Color c;
    private final Rug.Coordinate cc;

    public Board(Rug.Color c,Rug.Coordinate cc){
        this.c=c;
        this.cc=cc;
    }

    public Rug.Color getPlayer(){
        return c;
    }

    public Boolean ifBlank(Board d){
        if(d.getPlayer().equals(Rug.Color.NOTHING)){
        return true;}
        else{
            return false;
        }

    }





}
