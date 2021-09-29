package com.algorithmpractice.helper;


import com.algorithmpractice.model.TreeNode;

import java.util.LinkedList;

public class TreeHelper {
    public static TreeNode convertLinkedListToBalancedBST(LinkedList<Integer> list) {
        TreeNode rootNode;
        if (list.size() == 1) {
            rootNode = new TreeNode(list.getFirst());
        } else if (list.size() == 2) {
            rootNode = new TreeNode(list.getLast());
            rootNode.setLeftNode(new TreeNode(list.getFirst()));
        } else {
            rootNode = new TreeNode(list.get(list.size() / 2));
            rootNode.setLeftNode(convertLinkedListToBalancedBST(new LinkedList<>(list.subList(0, list.size() / 2))));
            rootNode.setRightNode(convertLinkedListToBalancedBST(new LinkedList<>(list.subList(list.size() / 2+ 1, list.size()))));
        }
        return rootNode;
    }

}
