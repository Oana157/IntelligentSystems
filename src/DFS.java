import java.util.*;

/**
 * Created by Oana on 2017-11-26.
 */
public class DFS {
    private Node root;
    //constructor
    public DFS (Node root){
        this.root=root;
    }

    public void depthFirstSearch() {

        Set<Board> boards = new HashSet<Board>();   //set of already explored states
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        int nodesExpanded = 1;

        Node currentNode = new Node(root.getBoardState());

        //while the goal state is not reached
        while (!currentNode.isGoalState()) {

            //adds current node`s state to the set of existing states
            boards.add(currentNode.getBoardState());

            //randomizes the expansion order by shuffling the array of successors
            ArrayList<Node> successors = currentNode.expandNode();
            Collections.shuffle(successors);
            nodesExpanded++;

            //adds the current node`s children to the stack and sets their parent to currentNode
            for (Node n : successors) {
                if (boards.contains(n.getBoardState()))
                    continue;
                boards.add(n.getBoardState());
                Node child = new Node(n.getBoardState());
                child.setParent(currentNode);
                stack.add(child);
            }

            //gets the currentNode from the top of the stack
            currentNode = stack.pop();

        }
        System.out.println(nodesExpanded);
        currentNode.showResults(currentNode);
    }
}
