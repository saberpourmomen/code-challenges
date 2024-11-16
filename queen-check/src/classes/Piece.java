package classes;

public class Piece {
    private int x;
    private int y;
    public Piece(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void SetX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    public boolean validMove(){
        return !(x<1 || x>8 || y<1 || y>8);
    }

    public boolean isCheckedBy(Piece piece){
        return (x== piece.getX() || y== piece.getY()) || (Math.abs(piece.getX()-x)==Math.abs(piece.getY()-y));
    }
}
