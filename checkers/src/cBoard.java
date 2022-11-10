import java.util.ArrayList;

public class cBoard {
    static ArrayList<Piece> pieces;
    private static cBoard instance =  null;
    
    public static cBoard getInstance(){
        if(instance == null){
            instance = new cBoard();
        }
        return instance;
    }
    
    private cBoard(){
        pieces = new ArrayList<Piece>();
    }

    public static Boolean checkFree(String position, int type){
        for (Piece p: pieces){
            if (p.getPosition().equals(position) && p.getType() != type) 
                return false;
        }
        return true;
    }
}
