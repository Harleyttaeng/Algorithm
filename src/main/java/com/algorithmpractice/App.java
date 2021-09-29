package com.algorithmpractice;

import com.algorithmpractice.model.TreeNode;

public class App {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        
        node3.setLeftNode(node5);
        node3.setRightNode(node6);
        rootNode.setLeftNode(node3);
        rootNode.setRightNode(node4);
        
        int treeFindSumResult = calculateTreeSum(rootNode);
        System.out.println("The sum found in the tree is " + treeFindSumResult);
    }
    
    private static int calculateTreeSum(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        } else {
            return rootNode.getValue() + calculateTreeSum(rootNode.getLeftNode()) + calculateTreeSum(rootNode.getRightNode());
        }
    }
    
}
