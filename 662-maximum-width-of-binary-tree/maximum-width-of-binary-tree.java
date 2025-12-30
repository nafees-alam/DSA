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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0;
            int last = 0;
            for(int i = 0; i < size; i++){
                TreeNode currNode = q.peek().node;
                int curr_idx = q.peek().num;
                q.poll();

                if(i == 0){
                    first = curr_idx-mmin;
                }
                if(i == size-1){
                    last = curr_idx -mmin;
                }

                if(currNode.left != null){
                    q.offer(new Pair(currNode.left, curr_idx*2+1));
                }
                if(currNode.right != null){
                    q.offer(new Pair(currNode.right, curr_idx*2+2));
                }
            }

            ans = Math.max(ans, last-first+1);
        }

        return ans;
    }
}

class Pair{
    TreeNode node;
    int num;

    public Pair(TreeNode _node, int _num){
        this.node = _node;
        this.num = _num;
    }
}