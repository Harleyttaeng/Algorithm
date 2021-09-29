package com.algorithmpractice.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    @Test 
    public void testBinaryTreeToBinarySearchTreeConversion() {
        Integer[] expectedInOrderArrayBS = new Integer[]{8,2,4,10,7};
        Integer[] expectedInOrderArrayBST = new Integer[]{2,4,7,8,10};
        TreeNode rootNode = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.setLeftNode(treeNode8);
        treeNode2.setRightNode(treeNode4);
        rootNode.setLeftNode(treeNode2);
        rootNode.setRightNode(treeNode7);
        
        BinaryTree testBT = new BinaryTree(rootNode);
        assertEquals("Raw in-order array is incorrect", Arrays.asList(expectedInOrderArrayBS), testBT.getArrayInOrder());
        testBT.convertToBinarySearchTree();
        assertEquals("Transformed in-order array is incorrect", Arrays.asList(expectedInOrderArrayBST), testBT.getArrayInOrder());
    }
}
