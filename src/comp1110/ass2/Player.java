
package comp1110.ass2;
public class Player {

    public enum Color{
        CYAN("c"),
        YELLOW("y"),
        PURPLE("p"),
        RED("r");

        public final String str;

        Color(String str){
            this.str=str;
        }

    }


    public final Color c;
    public final int dirhams;

    public final int rugs;

    public final String status;

    public Player(Color c,int dirhams,int rugs,String status){
        this.c=c;
        this.dirhams=dirhams;
        this.rugs=rugs;
        this.status=status;
    }
    public  int caculateScores(int visualizedRug){
        return visualizedRug+dirhams;
    }

}


