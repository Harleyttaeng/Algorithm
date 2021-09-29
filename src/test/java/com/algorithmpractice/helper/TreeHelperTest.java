package com.algorithmpractice.helper;

import com.algorithmpractice.model.BinaryTree;
import com.algorithmpractice.model.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TreeHelperTest {
    @Test
    public void testConversionOfLinkedListToBalancedBST1(){
        LinkedList<Integer> testLinkedListInput = new LinkedList<>();
        testLinkedListInput.add(1);
        testLinkedListInput.add(2);
        testLinkedListInput.add(3);
        testLinkedListInput.add(4);
        testLinkedListInput.add(5);
        testLinkedListInput.add(6);

        TreeNode constructedBSTRootNode = TreeHelper.convertLinkedListToBalancedBST(testLinkedListInput);
        BinaryTree constructedBT = new BinaryTree(constructedBSTRootNode);
        
        Integer[] expectedInOrderArray = {1,2,3,4,5,6}; 
        assertEquals("Transformed in-order array is incorrect", Arrays.asList(expectedInOrderArray), constructedBT.getArrayInOrder());
    }

    @Test
    public void testConversionOfLinkedListToBalancedBST2(){
        LinkedList<Integer> testLinkedListInput = new LinkedList<>();
        testLinkedListInput.add(1);
        testLinkedListInput.add(2);
        testLinkedListInput.add(3);
        testLinkedListInput.add(4);

        TreeNode constructedBSTRootNode = TreeHelper.convertLinkedListToBalancedBST(testLinkedListInput);
        BinaryTree constructedBT = new BinaryTree(constructedBSTRootNode);

        Integer[] expectedInOrderArray = {1,2,3,4};
        assertEquals("Transformed in-order array is incorrect", Arrays.asList(expectedInOrderArray), constructedBT.getArrayInOrder());
    }
}
