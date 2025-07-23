package DSAPackage;



import java.util.List;



public class Node {
    public List<Node> children;
    public int value;
    public Node(List<Node> children, int value) {
        this.children = children;
        this.value = value;
    
    }
}