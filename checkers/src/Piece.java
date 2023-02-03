/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsatchi
 */
public class Piece {
    int type;
    boolean promoted = false;
    int xpos;
    int ypos;
    
    public Piece(int type, int xpos, int ypos){
       this.type = type;
       this.xpos = xpos;
       this. ypos = ypos;
    }
    
    public int getXPos(){
        return xpos;
    }
    
    public int getYPos(){
        return ypos;
    }
    
    public void setXPos(int xpos){
        this.xpos = xpos;
    }
    
    public void setYPos(int ypos){
        this.ypos = ypos;
    }
    
    public int getType(){
        return this.type;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public boolean getPromoted(){
        return promoted;
    }
    
    public void setPromoted(boolean promoted){
        this.promoted = promoted;
    }
    
    public int[] getDistance(int xcoords, int ycoords){
        int dx = xcoords - this.xpos;
        int dy = ycoords - this.ypos;
        return new int[]{dx,dy};
    }
    
    public int getYDirection(int ycoords){
        if(ycoords > ypos) return 1;
        else return -1;
    }
    
    public boolean movePiece(int xcoords, int ycoords){
        //RETURN TRUE IF PIECE IS KILLED, NOT MEANING SUCCESFUL MOVE
        //check if move is valid:
        //  should only be in black square                  [DONE]
        //  (piece to be moved).getType() == b.getTurn()    [DONE]
        //  in valid direction                              [DONE]
        //      promoted = any direc                        [DONE]
        //      not promoted = depends on whose turn it is  [DONE]
        //  distance is correct                             [DONE]
        //      if killing
        //          check if opposing piece exists between dest and pos
        //          delete opposing piece from board
        //      not killing
        //          dest should be free spot
        //          dest should be within (1, 1) from pos 
        
        //if move is succesful, do the move
        //  if killing happened:
        //      delete item from array or add "dead/alive" attribute to pieces
        //  if killing happen OR no happen:
        //      change position value 
        //      change visual board
        
        cBoard b = cBoard.getInstance();
        Piece toKill = b.getPiece(xcoords, ycoords);
        if(toKill == null){
            b.displayPieces();
            System.out.println("no kill");
            b.display[ypos][xpos] = 0;
            this.setXPos(ycoords);
            this.setYPos(xcoords);
            //b.removePiece(toKill);
            b.display[ycoords][xcoords] = type;
            b.displayPieces();
            return false;
        }else{
            System.out.println("kill NOT MADE YET");
            return true;
        }
    }
}
