import java.util.*;

/**
 * Created by Oana on 2017-11-25.
 */
public class BFS {
    private Node root;
    //constructor
    public BFS (Node root){
        this.root=root;
    }

    public void breadthFirstSearch(){

        int nodesExpanded=1;
        Node node = new Node(root.getBoardState());
        Node currentNode = node;

        //nodeSet is a set that contains nodes which are already visited
        Set<Board> boardSet = new HashSet<Board>();

        //queue of nodes to be expanded
        ArrayDeque<Node> queue = new ArrayDeque<Node>();

        //the goal state hasn`t been found
        while (!currentNode.isGoalState()){

            //add current node`s state to the explored states set
            boardSet.add(currentNode.getBoardState());
            nodesExpanded++;
            //add current node`s children to the queue of nodes to be explored
            for(Node n : currentNode.expandNode()){
                if(boardSet.contains(n.getBoardState()))
                    continue;

                boardSet.add(n.getBoardState());
                Node child = new Node(n.getBoardState());
                child.setParent(currentNode);
                queue.add(child);
            }

            currentNode=queue.poll();
        }

        System.out.println("Number of expanded nodes: " + nodesExpanded);
        //printing the path to the solution
        currentNode.showResults(currentNode);
    }
}
