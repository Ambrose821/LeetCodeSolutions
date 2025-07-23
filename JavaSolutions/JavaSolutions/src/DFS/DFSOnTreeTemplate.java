package DFS;

import DSAPackage.TreeNode;

public class DFSOnTreeTemplate {

    public static TreeNode dfs(TreeNode root, int target) {
    if (root == null) return null;
    if (root.value == target) {
        return root;
    }
    TreeNode left = dfs(root.left, target);
    if (left != null) {
        return left;
    }
    return dfs(root.right, target);
}

    
}
