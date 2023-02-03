
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsatchi
 */
public class cBoard {
    private static cBoard instance;
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static int turn = 1;
    public static int[][] display = new int[9][9];
    
    private cBoard (){ }
    
    public static cBoard getInstance() {
        if (instance == null) {
            instance = new cBoard();
        }
    return instance;
    }
    
    public Piece getPiece(int x, int y){
        for(Piece p: pieces){
            //System.out.println(p.getXPos() + " != " + x + ";" + p.getYPos() + " != " + y);
            if(p.getXPos() == x && p.getYPos() == y){
                System.out.println("\tPIECE FOUND: " + p.getXPos() + "," + p.getYPos());
                return p;
            }
        }
        System.out.println("no find: " + x + " " + y);
        return null;
    }
    
    public void removePiece(Piece p){
        pieces.remove(p);
    }
    
    
    public void createBoard(){
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i+j)%2 == 1) continue;
                if(i < 3){
                    display[i][j] = 1;
                    pieces.add(new Piece(1, j, i));
                }
                else if(i > 4){
                    display[i][j] = -1;
                    pieces.add(new Piece(-1, j, i));
                }
                //System.out.print(i + "" + j);
                //System.out.print(":" + display[i][j] + " ");
            }
            //System.out.println();
        }
    }
    
    public void placePiece(int type, int x, int y){
        //method exists purely for testing purposes
        display[x][y] = type;
        displayBoard();
    }
    
    public void displayBoard(){
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                switch (display[i][j]){
                    case 1:
                        System.out.print("B ");
                        break;
                    case -1:
                        System.out.print("R ");
                        break;
                    default:
                        System.out.print("/ ");
                        break;
                }
            }
            System.out.println();
        }
        
        System.out.print(" \t|");
        for(int i = 0; i < 8; i++) System.out.print((char) (65+i) + "    ");
        System.out.println();
        System.out.println(" \t|-----------------------------------------");
        
        int i = 0;
        
        for(int j = 0; j < 8; j++){
            for(int k = 0; k < 3; k++){
                if(k == 0){
                    System.out.print(j+1 +"\t|");
                }
                else System.out.print(" \t|");
                if(k != 1){
                    if(j%2 == 0) System.out.println("/////     /////     /////     /////     ");
                    if(j%2 == 1) System.out.println("     /////     /////     /////     /////");
                }
                else if(k==1){
                    if(j%2 == 1) System.out.print("     ");
                    for(i = 0; i < 8; i++){
                        if((i+j)%2 == 0){
                            switch (display[j][i]){
                                case 1:
                                    System.out.print("//B//     ");
                                    break;
                                case -1:
                                    System.out.print("//R//     ");
                                    break;
                                default:
                                    System.out.print("/////     ");
                                    break;
                            }
                        }
                        //System.out.print("     ");
                    }
                System.out.println();
                }
                else{
                    if(j%2 == 0) System.out.println("/////     /////     /////     /////     ");
                    if(j%2 == 1) System.out.println("     /////     /////     /////     /////");
                }
            //System.out.println();

            }
        }
        //	|     /////     /////     /////     /////
        //      -----------------------------------------
        //       A    B    C    D    E
        System.out.println(" \t|-----------------------------------------");
        System.out.print(" \t|");
        for(i = 0; i < 8; i++) System.out.print((char) (65+i) + "    ");
        System.out.println();
    }
    
    public void displayPieces(){
        int i = 0;
        for(Piece P: pieces){
            if(P.type == -1){
                i++;
                System.out.print(P.xpos + "," + P.ypos + " ");
                if(i%4 == 0) System.out.println();
            }
        }
        System.out.println();
        i = 0;
        for(Piece P: pieces){
            if(P.type == 1){
                i++;
                System.out.print(P.xpos + "," + P.ypos + " ");
                if(i%4 == 0) System.out.println();
            }
        }
    }
    
    public void changeTurn(){
        if(turn == -1) turn = 1;
        else turn = -1;
    }
    
    public int getTurn(){
        return turn;
    }
    
}
