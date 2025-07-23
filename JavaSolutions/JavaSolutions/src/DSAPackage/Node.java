package DSAPackage;



import java.util.List;



public class Node {
    public List<Node> neighbors;
    public int value;
    public Node(List<Node> neighbors, int value) {
        this.neighbors = neighbors;
        this.value = value;
    
    }
}