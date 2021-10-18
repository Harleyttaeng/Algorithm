package com.algorithmpractice.model;

public class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public void setValue(Integer value) {this.value = value;}
    
    public void setLeftNode(TreeNode treeNode) {
        this.left = treeNode;
    }

    public void setRightNode(TreeNode treeNode) {
        this.right = treeNode;
    }
    
    public Integer getValue() {return value;}

    public TreeNode getLeftNode() {return left;}

    public TreeNode getRightNode() {return right;}
}
