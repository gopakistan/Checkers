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
    
    public boolean getPromoted(){
        return promoted;
    }
    
    public void setPromoted(boolean promoted){
        this.promoted = promoted;
    }
    
    public int[] getDistance(int xcoords, int ycoords){
        int dx = xcoords - xpos;
        int dy = ycoords - ypos;
        return new int[]{dx,dy};
    }
    
    public int getYDirection(int ycoords){
        if(ycoords > ypos) return 1;
        else return -1;
    }
    
    public void movePiece(int xcoords, int ycoords){
        //check if move is valid:
        //  should only be in black square
        //  in valid direction
        //      promoted = any direc
        //      not promoted = depends on whose turn it is
        //  distance is correct
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
        
        
    }
}
