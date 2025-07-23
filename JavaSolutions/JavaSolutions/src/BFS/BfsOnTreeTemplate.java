package BFS;

import java.util.ArrayDeque;

import DSAPackage.Node;

public class BfsOnTreeTemplate {
    

    private static final Node NOT_FOUND = null;

    public Node bfs(Node root) {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (queue.size() > 0) {
        Node node = queue.poll();
        for (Node child : node.children) {
            if (isGoal(child)) {
                return FOUND(child);
            }
            queue.add(child);
        }
    }
    return NOT_FOUND;
}

    private Node FOUND(Node child) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'FOUND'");
    }

    private boolean isGoal(Node child) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGoal'");
    }

}
