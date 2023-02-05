public class cBoard {
    private static cBoard instance;
    public static int turn = 1;
    private static int[][] display = new int[9][9];
    private cBoard (){ }
    public static cBoard getInstance() {
        if (instance == null) {
            instance = new cBoard();
        }
        instance.createBoard();
        return instance;
    }

    public int getBoardPiece(int xpos, int ypos){
        return(display[ypos][xpos]);
    }

    public void setBoardPiece(int xpos, int ypos, int value){
        display[ypos][xpos] = value;
    }

    private void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i + j)%2 == 0){
                    if(i < 3) display[i][j] = 1;
                    else if(i > 4) display[i][j] = -1;
                }
            }
        }
    }

    public void displayBoard(){
        displayBCoordinates();
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
        System.out.println(" \t|-----------------------------------------");
        System.out.print(" \t|");
        for(i = 0; i < 8; i++) System.out.print((char) (65+i) + "    ");
        System.out.println();

        System.out.println(printTurn());
    }

    public void displayBCoordinates(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(i + "," + j + " | ");
            }
            System.out.println();
            System.out.println("-----------------------------------------------");
        }
    }

    public int getTurn(){
        return turn;
    }

    public String printTurn(){
        return("It is " + Main.getPieceChar(getTurn()) + "'s turn");
    }

    public void changeTurn(){
        turn *= -1;
    }

}
