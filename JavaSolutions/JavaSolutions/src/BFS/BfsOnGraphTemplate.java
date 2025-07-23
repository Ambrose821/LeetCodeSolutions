package BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import DSAPackage.Node;

public class BfsOnGraphTemplate {
    public void bfs(Node root) {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Set<Node> visited = new HashSet<>();
    visited.add(root);
    while (queue.size() > 0) {
        Node node = queue.pop();
        for (Node neighbor : node.neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            queue.add(neighbor);
            visited.add(neighbor);
        }
    }
}

}
