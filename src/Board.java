/**
 * Created by Oana on 2017-11-22.
 */
public class Board {

    private char [][] board;
    private int n;
    //constructor
    public Board(int n){
        this.n=n;
        board = new char [n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='X';
        board[n-3][1]='A';
        board[n-2][1]='B';
        board[n-1][2]='C';
        board[n-1][n-1]='K';
    }

    public void showMatrix(){
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }

    public Board moveUp(){
        Board auxBoard = this;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if(auxBoard.getBoard()[i][j]=='K')
                    if(i==0) {
                        return null;
                    } else
                    {
                        auxBoard.getBoard()[i][j] =auxBoard.getBoard()[i - 1][j];
                        auxBoard.getBoard()[i - 1][j] = 'K';
                    }
        return auxBoard;
    }

    public Board moveDown(){
        Board auxBoard = this;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if(auxBoard.getBoard()[i][j]=='K'&&i!=n-1)
                    {
                        auxBoard.getBoard()[i][j] = auxBoard.getBoard()[i + 1][j];
                        auxBoard.getBoard()[i + 1][j] = 'K';
                        return auxBoard;
                    }
        return null;

    }

    public Board moveLeft(){
        Board auxBoard = this;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if(auxBoard.getBoard()[i][j]=='K')
                    if(j==0)
                        return null;
                    else
                    {
                        auxBoard.getBoard()[i][j] = auxBoard.getBoard()[i][j-1];
                        auxBoard.getBoard()[i][j-1] = 'K';
                    }
        return auxBoard;
    }

    public Board moveRight(){
        Board auxBoard = this;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if(auxBoard.getBoard()[i][j]=='K' && j!=n-1)
                    {
                        auxBoard.getBoard()[i][j] = auxBoard.getBoard()[i][j+1];
                        auxBoard.getBoard()[i][j+1] = 'K';
                        return auxBoard;
                    }
                    return null;

    }
    public char [][] getBoard(){
        return board;
    }
    public int getN(){
        return n;
    }

}