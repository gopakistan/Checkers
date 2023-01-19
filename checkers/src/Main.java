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
        //System.out.println("here:" + dir.substring(0,2) + "rrr");
        while(!(dir.equals("end") )){
            if (dir.equals("help")) getHelp();
            
            else {
                moveList = dir.split(" ", 6);
            
                if (moveList[0].equals("move")){
                    System.out.println("piece to be moved: " + moveList[1]);
                    
                    for(i = 2; i < moveList.length; i++){
                        System.out.println(moveList[i]);
                        if (moveList[i].length() == 2) verifySpotColour(moveList[i]);
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
            if(ascii > 96 && ascii < 105)
                return ascii - 96;
            if(ascii > 64 && ascii < 73)
                return ascii - 64;
            else return -1;
        }
        
        public static boolean verifySpotColour(String move){
            System.out.println("\t\t" + move);
            int ycoords = move.charAt(1); 
            int xcoords = char2num(move.charAt(0));
            
            //checks if the entered coordinates are on a black spot
            if((xcoords + ycoords)%2 == 1) return false;
            else return true;
        }
        //A
        public static String printError(String err){
            System.out.println("Error due to " + err);
            return "end";
        }
    
}
