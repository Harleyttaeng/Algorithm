package com.algorithmpractice.model;

public class BinarySearchTree extends BinaryTree{
    
    public BinarySearchTree(TreeNode rootNode, int[] traversalSet) {
        super(rootNode);
        super.rootNode = constructBST(traversalSet);
        
        super.inOrderArray.clear();
        super.printInOrder(super.rootNode);
    }
    
    private TreeNode constructBST(int[] traversalSet) {
        TreeNode bstRoot = new TreeNode(traversalSet[0]);
        for (int i=1; i<traversalSet.length; i++) {
            insertNode(bstRoot, traversalSet[i]);
        }
        return bstRoot;
    }

    private void insertNode(TreeNode rootNode, int value) {
        if (value < rootNode.getValue()) {
            if (rootNode.getLeftNode() == null) {
                rootNode.setLeftNode(new TreeNode(value));
            } else {
                insertNode(rootNode.getLeftNode(), value);
            }
        } else {
            if (rootNode.getRightNode() == null) {
                rootNode.setRightNode(new TreeNode(value));
            } else {
                insertNode(rootNode.getRightNode(), value);
            }
        }
    }
}
