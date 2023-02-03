/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsatchi
 */

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        int i = 0;
        String[] moveList = new String[]{"0"};
        Scanner input = new Scanner(System.in);
        String dir = "help";
        cBoard b = cBoard.getInstance();
        b.createBoard(); //<--INIT B
        b.displayBoard();
        while(!(dir.equals("end") )){
            if (dir.equals("help")) getHelp();
            else {
                b.displayBoard();
                moveList = dir.split(" ", 6);
            
                if (moveList[0].toLowerCase().equals("move")){
                    System.out.println("piece to be moved: " + moveList[1]);
                    
                    for(i = 2; i < moveList.length; i++){
                        System.out.println(moveList[i]);
                        if (moveList[i].length() == 2){
                            int xpos = char2num(moveList[1].charAt(0));
                            int ypos = char2num(moveList[1].charAt(1));
                            Piece p = b.getPiece(xpos, ypos);
                            
                            int x = char2num(moveList[i].charAt(0));
                            int y = char2num(moveList[i].charAt(1));
                            if (validateMoves(p, b, x, y) == true){
                                p.movePiece(x, y);
                            }
                            
                        } 
                        else{
                            printError("Invalid format followed.");
                        }
                    }
                    
                }
            }
            dir = input.nextLine();
        }
        
        System.out.println("**End command has been entered. Game is over.");

    }
        public static void getHelp(){
            System.out.println("**Welcome to Checkers. Here is how to play:"
                    + "\n\ttype 'help' to resend this string"
                    + "\n\ttype 'end' to stop the game"
                    + "\n\ttype 'move [X# X#1 X#2 ... X#n]' to move X# to the following positions"
                    + "\n\t\texample: move A1 C3 A5"
                    + "\n\t\t\t moves piece at A1 to C3, then to A5");
        }
    
        public static int char2num(char c){
            int ascii = (int) c;
            if(ascii > 96 && ascii < 105){
                ascii -= 97;
                return ascii;
            }
            else if(ascii > 64 && ascii < 73){
                ascii -= 65;
                return ascii;
            }
            else if(ascii > 48 && ascii < 58){
                ascii -= 49;
                return ascii;
            }
            else return -1;
        }
        
        public static String printError(String err){
            System.out.println("Error due to " + err);
            return "end";
        }
        
        public static boolean validateMoves(Piece p, cBoard b, int x, int y){
            //check if piece exists
            if(p == null){
                printError("Piece not found");
                return false;
            }
            //check if piece belongs to player
            
            else{
                int[] distance = p.getDistance(x, y);
                int xdis = distance[0];
                int ydis = distance[1];
                
                if((x + y)%2 != 0) return false;
                
                else if(p.getType() != b.getTurn()){
                    printError("It is not your turn");
                    return false;
                }
                //check if direction its going in is ok
                else if(p.getPromoted() == false && p.getYDirection(y) != b.getTurn()){
                    printError("Piece cannot move in this direction.");
                    return false;
                }
            }
//            else if (xdis != 1 || ydis != 1){
//                printError("Piece cannot travel this far.");
//                return false;
//            }
            return true; //CHECK IF THE MOVE SPOT IS ACTUALLY ON THE BOARD
        }
    
}
