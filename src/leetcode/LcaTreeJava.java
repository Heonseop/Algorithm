package leetcode;

/*
leetcode 236 Lowest Common Ancestor of a Binary Tree
Runtime: 7 ms, faster than 80.29% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
Memory Usage: 47.5 MB, less than 38.73% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
kotlin에서는 도저히 `val` 인식이 안되서 java로 변환
이진 탐색 트리에서 주어진 노드의 LCA(최소 공통 조상)을 찾는 문제
자기자신이 조상가능
노드의 left는 항상 그 노드의 값보다 작고, right는 항상 그 노드의 값보다 크다
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LcaTreeJava {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}
