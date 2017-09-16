/**
 * Created by Momo on 9/15/17
 */
import java.util.*;

public class RouteBetweenNodes {
  public static void main(String[] args){
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    a.addChild(b);
    a.addChild(c);
    b.addChild(e);
    c.addChild(f);
    d.addChild(b);
    d.addChild(h);
    e.addChild(c);
    e.addChild(d);
    f.addChild(g);
    i.addChild(g);
    i.addChild(h);
    System.out.println(isRoute(a, e));
    System.out.println(isRoute(e, h));
    System.out.println(isRoute(a, i));



  }

  public static boolean isRoute(Node start, Node end){
    // Use a HashSet to keep track of the visited nodes by their id
    HashSet<Integer> visited = new HashSet<>();
    // By using a queue representation of a linkedlist we can run a Breadth First Search
    // Algorithm on our graph
    LinkedList<Node> queue = new LinkedList<>();
    Node current;
    queue.add(start);
    // While the queue isn't empty we continue iterating through the graph
    while(!queue.isEmpty()){
      // Pull the value from the front of the queue, and mark it as visited
      current = queue.pop();
      visited.add(current.id);
      // If the ID matches our end ID we have a route
      if(current.id == end.id)
        return true;
      // Otherwise we need to add all unvisited children of the current node
      // To our queue
      for(Node child : current.children){
        if(!visited.contains(child.id))
          queue.add(child);
      }
    }
    // If the queue is empty and our ID never matched, this means there is no
    // route between the nodes
    return false;
  }

  private static class Node {
    // We treat the ID as data here, obviously there could be duplicates
    // But for the sake of the example the node was not written to have a unique
    // id, since we planned on feeding unique values in
    int id;
    // We also use an arraylist to represent the children of the node, since this
    // is meant to run on a digraph this means that although there are child nodes
    // for this specific node, this node does not have to be a child of the nodes
    // in the arraylist (in a digraph there isn't always a two way connection)
    ArrayList<Node> children;
    public Node(int id){
      this.id = id;
      children = new ArrayList<>();
    }

    public void addChild(Node child){
      children.add(child);
    }
  }
}
