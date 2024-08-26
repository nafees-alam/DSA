class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for(int i = 0; i < wordDict.size(); i++){
            insert(wordDict.get(i), root);
        }

        return wordBreakHelper(s, root, new Boolean[s.length()]);
    } 

    private boolean wordBreakHelper(String s, Node root, Boolean[] memo) {
        if(s.length() == 0){
            return true;
        }
        
        if (memo[s.length() - 1] != null) {
            return memo[s.length() - 1];
        }
        
        for(int i = 1; i <= s.length(); i++){
            if(search(s.substring(0, i), root) && wordBreakHelper(s.substring(i), root, memo)){
                memo[s.length() - 1] = true;
                return true;
            }
        }

        memo[s.length() - 1] = false;
        return false;
    }

    static class Node{
        Node[] child = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i < 26; i++){
                child[i] = null;
            }
        }
    }

    // static Node root = new Node();

    static void insert(String word, Node root){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        
        curr.eow = true;
    }

    static boolean search(String key, Node root){
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.child[idx] == null){
                return false;
            }
            curr = curr.child[idx];
        }
        
        return curr.eow == true;
    }
}