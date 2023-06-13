package Seminar04;

public class BinarySearchTree {

    public class Tree {

        private TreeNode root;
    
        private class TreeNode {
            private int value;
            private TreeNode left;
            private TreeNode right;            
        }

        public boolean find(int value){
            TreeNode Treenode = root;
            while (Treenode != null){
                if (Treenode.value == value){
                    return true;
                }
                else if (Treenode.value > value) {
                    Treenode = Treenode.left;
                }
                else{
                    Treenode = Treenode.right;
                }
            }
         return false;
        }

        public boolean recursionFind(int value) {
            if (root == null){
                return false;
            }
            return recursionFind(root, value);
        }

        private boolean recursionFind(TreeNode Treenode, int value) {
            if (Treenode.value == value){
                return true;
            } 
            else {
                if (Treenode.value > value){
                    return recursionFind(Treenode.left, value);
                } 
                else {
                    return recursionFind(Treenode.right, value);
                }
            }
        }

    }
    
}
