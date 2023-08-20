package comp1110.ass2;

public class Rug {
    public class Coordinate{
        private final int x;
        private final int y;
        public Coordinate(int x, int y){
            this.x=x;
            this.y=y;

        }

    }
    public enum Color{
        CYAN("c"),
        YELLOW("y"),
        PURPLE("p"),
        RED("r"),
        NOTHING("n");

        private final String str;
        Color( String str){
            this.str=str;
        }
        }
        private final Color cRug;
        private final int id;
        private final Coordinate c1;
        private final Coordinate c2;


        public Rug(Color c,int id,Coordinate cc,Coordinate cc2){
            this.cRug=c;
            this.id=id;
            this.c1=cc;
            this.c2=cc2;
        }
        public Coordinate getCoordinate1(){
            return c1;
        }

        public Coordinate getCoordinate2(){
        return c2;
    }


    }


