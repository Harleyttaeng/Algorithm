package com.algorithmpractice.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    private final int[] testTraversalSet = {10,5,1,7,40,50};
    private final TreeNode rootNode = new TreeNode(10);
    private final TreeNode node5 = new TreeNode(5);
    private final TreeNode node40 = new TreeNode(40);
    private final TreeNode node1 = new TreeNode(1);
    private final TreeNode node7 = new TreeNode(7);
    private final TreeNode node50 = new TreeNode(50);
    BinarySearchTree testBST = new BinarySearchTree(new TreeNode(10), testTraversalSet);
    
    @Before
    public void setup() {
        //Set up a expected BST object
        node5.setLeftNode(node1);
        node5.setRightNode(node7);
        node40.setRightNode(node50);
        rootNode.setLeftNode(node5);
        rootNode.setRightNode(node40);
    }

    @Test
    public void testTransformBSTToArrayInOrder() {
        Integer[] expectedInOrderArray = new Integer[]{1,5,7,10,40,50};
        assertEquals("Transformed in-order array is incorrect", Arrays.asList(expectedInOrderArray), testBST.getArrayInOrder());
    }
}
