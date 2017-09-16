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
    HashSet<Integer> visited = new HashSet<>();
    LinkedList<Node> queue = new LinkedList<>();
    Node current;
    queue.add(start);
    while(!queue.isEmpty()){
      current = queue.pop();
      visited.add(current.id);
      if(current.id == end.id)
        return true;
      for(Node child : current.children){
        if(!visited.contains(child.id))
          queue.add(child);
      }
    }
    return false;
  }

  private static class Node {
    int id;
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
