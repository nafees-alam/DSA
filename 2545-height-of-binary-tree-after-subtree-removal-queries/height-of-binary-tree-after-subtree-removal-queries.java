/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
    int[] level = new int[100001];
    int[] levelMaxHt = new int[100001];
    int[] levelSecondMaxHt = new int[100001];
    int[] ht = new int[100001];

    // Compute the height of each node and update level, levelMaxHt, and levelSecondMaxHt arrays
    computeHeights(root, 0, level, levelMaxHt, levelSecondMaxHt, ht);

    int[] ans = new int[queries.length];
    int k = 0;

    for (int val : queries) {
        int L = level[val];
        // Calculate the answer for each query
        ans[k++] = L + ((levelMaxHt[L] == ht[val]) ? levelSecondMaxHt[L] : levelMaxHt[L]) - 1;
    }

    return ans;
}

private int computeHeights(TreeNode root, int l, int[] level, int[] levelMaxHt, int[] levelSecondMaxHt, int[] ht) {
        if (root == null) {
            return 0;
        }

        level[root.val] = l;
        int leftHeight = computeHeights(root.left, l + 1, level, levelMaxHt, levelSecondMaxHt, ht);
        int rightHeight = computeHeights(root.right, l + 1, level, levelMaxHt, levelSecondMaxHt, ht);
        ht[root.val] = Math.max(leftHeight, rightHeight) + 1;

        if (ht[root.val] > levelMaxHt[l]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = ht[root.val];
        } else if (ht[root.val] > levelSecondMaxHt[l]) {
            levelSecondMaxHt[l] = ht[root.val];
        }

        return ht[root.val];
    }
}