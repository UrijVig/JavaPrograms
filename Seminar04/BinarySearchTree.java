package Seminar04;

public class BinarySearchTree {

    public class Tree<V extends Comparable<V>> {

        private TreeNode root;
    
        private class TreeNode {
            private V value;
            private TreeNode left;
            private TreeNode right;            
        }

        public boolean find(V value){
            TreeNode Treenode = root;
            while (Treenode != null){
               if (Treenode.value.equals(value)){
                  return true;
               }
               if (Treenode.value.compareTo(value) > 0) {
                   Treenode = Treenode.left;
                }else {
                   Treenode = Treenode.right;
                }
            }
         return false;
        }

        public boolean recursionFind(V value) {
            if (root == null){
                return false;
            }
            return recursionFind(root, value);
        }

        private boolean recursionFind(TreeNode Treenode, V value) {
            if (Treenode.value.equals(value)){
                return true;
            } else {
                if (Treenode.value.compareTo(value) > 0){
                    return recursionFind(Treenode.left, value);
                } else {
                    return recursionFind(Treenode.right, value);
                }
            }
        }

    }
    
}
