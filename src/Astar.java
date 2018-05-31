import java.util.*;

/**
 * Created by Oana on 2017-11-29.
 */
public class Astar {
    private Node root;

    //constructor
    public Astar(Node root){
        this.root=root;
    }

   public void aStar(){

       int nodesExpanded=1;
       Set<Board> explored = new HashSet<Board>(); //Set of explored states
       Node node = new Node(root.getBoardState());
       node.setTotalCost(0);
       Node currentNode = node;
       //saves the nodes in a Priority Queue ordered by the totalCost
       PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(10, new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               if(o1.getTotalCost() < o2.getTotalCost()){
                   return -1;
               }
               if(o1.getTotalCost() > o2.getTotalCost()){
                   return 1;
               }
               return 0;
           }
       });


       /*while we haven`t found a solution generates a node`s children, gets
       each child`s total cost by adding its manhattan distance to the parent`s total cost
       and adds the child to the priority queue
         */
       while (!currentNode.isGoalState()){

           explored.add(currentNode.getBoardState());
           nodesExpanded++;
           for(Node n : currentNode.expandNode()){
               if(explored.contains(n))
                   continue;

               explored.add(n.getBoardState());
               Node child = new Node(n.getBoardState());
               child.setParent(currentNode);
               child.setTotalCost(currentNode.getTotalCost() + manhattan(child));
               nodePriorityQueue.add(child);
           }
           //the node having the lowest cost
           currentNode = nodePriorityQueue.poll();

       }
       System.out.println("Nodes expanded: " + nodesExpanded);
       currentNode.showResults(currentNode);
   }

   //calculates the sum of the manhattan distances between a Node`s 'A','B' and 'C' and the goal state`s 'A','B' and 'C'
   public int manhattan (Node node){

       int distance = 0;

       for(int i=0;i<node.getBoardState().getN();i++)
           for (int j=0;j<node.getBoardState().getN();j++) {

               if (node.getBoardState().getBoard()[i][j] == 'A')
                   distance += Math.abs(i - (node.getBoardState().getN() - 3)) + Math.abs(j - 1);
               if (node.getBoardState().getBoard()[i][j] == 'B')
                   distance += Math.abs(i - (node.getBoardState().getN() - 2)) + Math.abs(j - 1);
               if (node.getBoardState().getBoard()[i][j] == 'C')
                   distance += Math.abs(i - (node.getBoardState().getN() - 1)) + Math.abs(j - 1);

           }
       return distance;
   }
}
