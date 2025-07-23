package DFS;

import java.util.Set;

import DSAPackage.Node;

public class DFSOnGraphTemplate {

    public void dfs(Node root, Set<Node> visited) {
    for (Node neighbor : root.neighbors) {
        if (visited.contains(neighbor)) {
            continue;
        }
        visited.add(neighbor);
        dfs(neighbor, visited);
    }
}

    
}
