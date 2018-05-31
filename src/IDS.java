import java.net.PortUnreachableException;
import java.util.HashSet;
import java.util.Set;

public class IDS {

    private Node root;
    int nodesExp=1;
    int nodesChecked=1;

    //constructor
    public IDS (Node root){
        this.root=root;
    }


    //recursively
    //Reference: https://stackoverflow.com/questions/43616726/iterative-deepening-search-java-implementation
    public Node DLS(Node currentNode, int depth){

        Set<Board> boardSet = new HashSet<Board>();
        boardSet.add(currentNode.getBoardState());
        if(depth == 0 && currentNode.isGoalState())
            return currentNode;
        if(depth > 0) {
            nodesExp++;
            for(Node n : currentNode.expandNode()) {
                if(boardSet.contains(n.getBoardState()))
                    continue;
                n.setParent(currentNode);
                Node child = DLS(n,depth-1);
                nodesChecked++;

                if(child != null && child.isGoalState())
                    return child;
            }
        }
        return null;
    }

    //does depth limited search for every level
    public Node IDS(Node root){
        for (int depth = 0; depth< Integer.MAX_VALUE; depth++){
            Node result = DLS(root,depth);
            if(result!=null){
                System.out.println("Solution Depth: " + depth);
                System.out.println("Nodes expanded: " + nodesExp);
                result.showResults(result);
                return result;
            }
        }
        return null;
    }

}
