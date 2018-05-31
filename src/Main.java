/**
 * Created by Oana on 2017-11-21.
 */
public class Main {

    public static void main(String args[]){
        Board board = new Board(4);
        Node root = new Node(board);
        BFS breadth = new BFS(root);
        System.out.println("**********Breadth First Search**********");
        //breadth.breadthFirstSearch();
        DFS depth = new DFS(root);
        System.out.println("**********Depth First Search**********");
        //depth.depthFirstSearch();
        IDS iterative = new IDS (root);
        System.out.println("**********Iterative Deepening Search**********");
        iterative.IDS(root);
        Astar astar = new Astar(root);
        System.out.println("********** A* Search**********");
        //astar.aStar();
    }
}
