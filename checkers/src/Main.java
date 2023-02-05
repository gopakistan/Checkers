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

    public static Scanner input = new Scanner(System.in);
    public static cBoard b = cBoard.getInstance();
    private static int xpos = 0;
    private static int ypos = 0;
    public static void main(String[] args) {
        b.displayBoard();
        userInputLoop();
        System.out.println("**End command has been entered. Game is over.");

    }

    private static void userInputLoop(){
        String[] moveList = new String[]{"0"};
        String dir = "help";
        int[] pos = new int[2]; int xdes = 0; int ydes = 0;

        while (!(dir.equals("end"))) {
            if (dir.equals("help")) getHelp();
            else {
                moveList = dir.split(" ", 6);

                if (moveList[0].toLowerCase().equals("move")) {
                    System.out.println("piece to be moved: " + moveList[1]);

                    //GET POSITION OF CURRENT PIECE
                    if(moveList[1].length() == 2){
                        System.out.println("LEN OF MOVELIST VALUE SHOULD BE 2 = " + moveList[1].length());
                        pos = convertToBoard(moveList[1].charAt(0), moveList[1].charAt(1));
                        xpos = pos[0]; ypos = pos[1];
                    }

                    for (int i = 2; i < moveList.length; i++) {
                        System.out.println(moveList[i]);
                        if (moveList[i].length() == 2) {
                            //GET POSITION OF NEXT PIECE
                            pos = convertToBoard(moveList[i].charAt(0), moveList[i].charAt(1));
                            xdes = pos[0]; ydes = pos[1];
                            if (validateMoves(xdes, ydes, xdes - xpos, ydes - ypos) == true) {
                                b.changeTurn();
                                System.out.println("awesome sauce!");
                            }

                        } else {
                            printError("Invalid format followed.");
                        }
                    }

                }
            }
            b.displayBoard();
            dir = input.nextLine();
        }
    }

    public static boolean validateMoves(int xdes, int ydes, int xdis, int ydis){

        int[] testVar = new int[]{xpos, xdes, xdis, ypos, ydes, ydis};
        String[] testVarStr = new String[]{"xpos", "xdes", "xdis", "ypos", "ydes", "ydis"};

        for(int j = 0; j < testVar.length; j++){
            System.out.println(testVarStr[j] + " = " + testVar[j]);
            if((j+1)%3 != 0 && (testVar[j] < 0 || testVar[j] > 7)){ //REMEMBER THAT J IS NOT GONNA BE 0
                printError("Spot specified is out of bounds");
                return false; //CHECK IF WITHIN BOUNDS OF 0 < i < 7
            }
            if(j < 3 && (testVar[j] + testVar[j+3])%2 != 0 ){
                printError("Pieces may only be on the highlighted squares.");
                return false; //CHECK IF ON BLACK SQUARE OR NOT
            }
        }
        if(ydis/b.getTurn() == -1){
            printError("This piece cannot move in this direction");
            return false; //CHECK DIRECTION
        }

        //NOTE THAT Y AND X ARE SWITCHED HERE
        if(b.getBoardPiece(xpos, ypos)/b.getTurn() == -1){
            printError("It is " + getPieceChar(b.getTurn()) + "'s turn");
            return false; //CHECK TURN
        }

        if(xdis == 1 || xdis == -1){ System.out.println("   DIS = 1");
            if(b.getBoardPiece(xdes, ydes) != 0) return false;
            b.setBoardPiece(xdes, ydes, b.getTurn());
            b.setBoardPiece(xpos, ypos, 0);
            xpos = xdes; ypos = ydes;
            return true;
        }
        else{ System.out.println("    DIS = 2");
            //find middle piece
            //check if it's the opposite side
            //perform actions to:
                //kill the middle piece
                //kill piece at pos
                //create new piece at des

            if((xdis == 2 || xdis == -2) && (ydis == 2 || ydis == -2)){
                int xmid = xdis/2 + xpos;
                int ymid = ydis/2 + ypos;
                int toKill = b.getBoardPiece(xmid, ymid);
                switch(toKill){
                    case 0:
                        printError("Cannot attempt to kill an empty square");
                        return false;
                    default:
                        if(b.getBoardPiece(xpos, ypos) == toKill){
                            printError("Cannot kill own piece");
                            return false;
                        }
                        else{
                            b.setBoardPiece(xmid, ymid, 0);
                            b.setBoardPiece(xpos, ypos, 0);
                            b.setBoardPiece(xdes, ydes, b.getTurn());
                            xpos = xdes; ypos = ydes;
                            return true;
                        }

                }
            }
        }
        return true;
    }

    public static void moveToNotKill(int xdes, int ydes, int xdis, int ydis){

    }
    public static void moveToKill(){

    }

    public static int[] convertToBoard(char let, char num){
        int x = char2num(let);
        int y = char2num(num);
        return new int[]{x, y};
    }


    private static void getHelp() {
        System.out.println("**Welcome to Checkers. Here is how to play:"
                + "\n\ttype 'help' to resend this string"
                + "\n\ttype 'end' to stop the game"
                + "\n\ttype 'move [X# X#1 X#2 ... X#n]' to move X# to the following positions"
                + "\n\t\texample: move A1 C3 A5"
                + "\n\t\t\t moves piece at A1 to C3, then to A5");
    }

    private static int char2num(char c) {
        int ascii = (int) c;
        if (ascii > 96 && ascii < 105) {
            ascii -= 97;
            return ascii;
        } else if (ascii > 64 && ascii < 73) {
            ascii -= 65;
            return ascii;
        } else if (ascii > 48 && ascii < 58) {
            ascii -= 49;
            return ascii;
        } else return -1;
    }

    public static String printError(String err) {
        System.out.println("Error due to " + err);
        return "end";
    }

    public static char getPieceChar(int i){
        switch (i){
            case 1:
                return('B');
            case -1:
                return('R');
            default:
                return('Z');
        }
    }

}
