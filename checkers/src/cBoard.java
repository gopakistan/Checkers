
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
    public static int turn = 0;
    public static int[][] display = new int[8][8];
    
    private cBoard (){ }
    
    public static cBoard getInstance() {
        if (instance == null) {
            instance = new cBoard();
        }
    return instance;
    }
    
    public void createBoard(){
        int spotx = 1;
        int spoty = 1;
        
        for(int i = 0; i < 12; i++){
            pieces.add(new Piece(1, spotx, spoty));
            pieces.add(new Piece(-1, spotx, 9 - spoty));
            display[spotx-1][spoty-1] = 1;
            display[spotx-1][9-spoty-1] = -1;
            spotx += 2;
            
            if(i == 3) spotx += 1;
            if(i == 7) spotx -= 1;
            
            if((i+1) % 4 == 0){
                spoty += 1;
                spotx %= 8;
            }
            
        }
        
        displayPieces();
        displayBoard();
    }
    
    public void displayBoard(){
        int i, j = 0;
        for(i = 0; i < 8; i++){
            if(i == 0) System.out.println("_____________");
            
            //8| B  B  B  B  
            //_____________
            for(j = 0; j < 8; j++){
                if(j == 0) System.out.print(8-i + "| ");
                if (display[j][i] == 1) System.out.printf("%1s", "B");
                else if (display[j][i] == -1) System.out.printf("%-1s", "R");
                else System.out.print(" x ");
            }
            System.out.println();
        }
        System.out.println("_____________");
        System.out.println("   A B C D E F G H");
        
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
