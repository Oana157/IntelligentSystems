import java.util.ArrayList;

/**
 * Created by Oana on 2017-11-21.
 */
public class Node {
    private int totalCost;
    private Node parent;
    private Board boardState;

    //constructor
    public Node(Board boardState) {
        this.boardState = boardState;
    }

    public Board getBoardState(){
        return boardState;
    }

    public int getTotalCost(){
        return totalCost;
    }
    public void setTotalCost(int totalCost){
        this.totalCost=totalCost;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent){
        this.parent=parent;
    }

    //checks is 'A', 'B' and 'C' are in the goal state positions
    public boolean isGoalState(){
        if(boardState.getBoard()[boardState.getN()-3][1]=='A')
            if(boardState.getBoard()[boardState.getN()-2][1]=='B' && boardState.getBoard()[boardState.getN()-1][1]=='C')
                return true;
        return false;
    }


    //Creates an auxiliary Board
    public Board createAuxBoard(){
        Board aux = new Board(this.getBoardState().getN());
        for(int i=0;i<this.getBoardState().getN();i++)
            for (int j=0;j<this.getBoardState().getN();j++)
                aux.getBoard()[i][j]=this.getBoardState().getBoard()[i][j];
        return aux;

    }
    /*checks is the agent is able to move in a certain direction and if it is
    creates a new node that has the moved board and adds it to the children array
     */
    public ArrayList<Node> expandNode(){

        ArrayList<Node> successors = new ArrayList<Node>();
        Board upMove = this.createAuxBoard();
        if(upMove.moveUp()!=null){
            Node child3 = new Node(upMove);
            successors.add(child3);
        }

        Board leftMove = this.createAuxBoard();
        if(leftMove.moveLeft()!=null){
            Node child2 = new Node(leftMove);
            successors.add(child2);
        }
        Board downMove = this.createAuxBoard();
        if(downMove.moveDown()!=null){
            Node child4 = new Node(downMove);
            successors.add(child4);
        }

        Board rightMove = this.createAuxBoard();
        if(rightMove.moveRight()!=null){
            Node child1 = new Node(rightMove);
            successors.add(child1);
        }


        return successors;
    }

    //shows the depth of the solution and the action sequence
    public void showResults(Node result) {
        result.getBoardState().showMatrix();
        Node parent = result.getParent();
        int path = 0;
        while (parent != null) {
            path++;
            result = parent;
            result.getBoardState().showMatrix();
            parent = result.getParent();

        }

        System.out.println("Depth:" + path);
    }
}