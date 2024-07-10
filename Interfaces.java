public class Interfaces {
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves();
    }
    
}
interface ChessPlayer{
    void moves(); //just a blueprint since all moves are different respective to the piece.
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("Moves= Can move in all directions.");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("Moves in a straight line, horizontal and vertical.");
    }
}