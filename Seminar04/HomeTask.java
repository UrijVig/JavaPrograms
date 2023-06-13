package Seminar04;

public class HomeTask {
    public class Tree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        
        private Color color;
        private Node leftChild;
        private Node rightChild;
    }
    
    private enum Color {
        RED, BLACK
    }

    private Node rightChildSwap(Node node) {
        Node rightChildChild = node.rightChild;
        Node betweenChild = rightChildChild.leftChild;
        rightChildChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChildChild.color = node.color;
        node.color = Color.RED;
        return rightChildChild;
    }

    private Node leftChildSwap(Node node) {
        Node leftChildChild = node.leftChild;
        Node betweenChild = leftChildChild.rightChild;
        leftChildChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChildChild.color = node.color;
        node.color = Color.RED;
        return leftChildChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } 
        else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(Node node, V value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } 
                else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } 
            else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                                        node.rightChild = rebalance(node.rightChild);
                    return result;
                } 
                else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightChildSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftChildSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    

    

    

    
}


    
}
