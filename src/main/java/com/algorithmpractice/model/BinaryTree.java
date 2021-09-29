package com.algorithmpractice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
    TreeNode rootNode;
    List<Integer> inOrderArray = new ArrayList<>();

    private int traversalArrayPointer = 0;

    public BinaryTree(TreeNode rootNode) {
        this.rootNode = rootNode;
        printInOrder(rootNode);
    }

    public List<Integer> getArrayInOrder() {
        return inOrderArray;
    }
    
    public void convertToBinarySearchTree() {
        List<Integer> inOrderArrayAux = inOrderArray;
        Collections.sort(inOrderArrayAux);
        updateInOrder(rootNode, inOrderArrayAux);
        
        inOrderArray.clear();
        printInOrder(rootNode);
        traversalArrayPointer = 0;
    }
    
    private void updateInOrder(TreeNode treeNode, List<Integer> newValueArray) {
        if (treeNode == null) {
            return;
        }
        updateInOrder(treeNode.getLeftNode(), newValueArray);
        treeNode.setValue(newValueArray.get(traversalArrayPointer));
        traversalArrayPointer++;
        updateInOrder(treeNode.getRightNode(), newValueArray);
    }

    void printInOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printInOrder(treeNode.getLeftNode());
        inOrderArray.add(treeNode.getValue());
        printInOrder(treeNode.getRightNode());
    }
    
}
