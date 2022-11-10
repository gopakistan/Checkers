public class Piece {
    public String position;
    public int type;

    public Piece(String position, int type){
        this.position = position;
        this.type = type;
    } 

    public String getPosition(){
        return this.position;
    }

    public Boolean setPosition(String newPos){
        if (cBoard.checkFree(newPos, this.type)){

        }
        return true;
    }

    public int getType(){
        return this.type;
    }

    public void setType(int type){
        this.type = type;
    }

    public int letterVal(char c){
        int val = (int) c;
        if (val > 72)
            val -= 96;
        else
            val -= 71;
        return val;
    }

    public Boolean move(String newPos){
        //What to do in order:
            //1. Verify that newPos is within 1 space of p.getPosition()
            //2. Is it vertical or diagonal?
                //2.a. Vertical:
                        // Check if space is FREE
                //2.b. Diagonal:
                        // Check if space is OCCUPIED by OTHER COLOUR
            //3. Then u can just place the thing with the setPos method
            int Hdiff = letterVal(getPosition().charAt(0)) - letterVal(newPos.charAt(0));
            int Vdiff = (int) getPosition().charAt(1) - (int) newPos.charAt(1); 

            

        return true;   
    }
}
