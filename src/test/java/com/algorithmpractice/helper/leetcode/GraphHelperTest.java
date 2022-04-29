package com.algorithmpractice.helper.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphHelperTest {
    @Test
    public void testCourseSchedule1() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        Assert.assertTrue("Failed to judge if can finish courses", GraphHelper.canFinish(numCourses,prerequisites));
    }

    @Test
    public void testCourseSchedule2() {
        int numCourses = 5;
        int[][] prerequisites = {{0,1},{0,2},{1,3},{1,4},{3,4}};
        Assert.assertTrue("Failed to judge if can finish courses", GraphHelper.canFinish(numCourses,prerequisites));
    }

    @Test
    public void testCourseSchedule3() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        Assert.assertFalse("Failed to judge if can finish courses", GraphHelper.canFinish(numCourses,prerequisites));
    }

    @Test
    public void testCourseSchedule4() {
        int numCourses = 3;
        int[][] prerequisites = {{1,0},{0,2},{2,1}};
        Assert.assertFalse("Failed to judge if can finish courses", GraphHelper.canFinish(numCourses,prerequisites));
    }

    @Test
    public void testCourseSchedule5() {
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        Assert.assertTrue("Failed to judge if can finish courses", GraphHelper.canFinish(numCourses,prerequisites));
    }

    @Test
    public void testPacificAtlantic() {
        int[][] heights = new int[5][];
        heights[0] = new int[]{1,2,2,3,5};
        heights[1] = new int[]{3,2,3,4,4};
        heights[2] = new int[]{2,4,5,3,1};
        heights[3] = new int[]{6,7,1,4,5};
        heights[4] = new int[]{5,1,1,2,4};

        int[][] heights2 = new int[2][];
        heights2[0] = new int[]{1,2};
        heights2[1] = new int[]{3,4};

        List<List<Integer>> expectedResult = new ArrayList<>();
        Assert.assertEquals("Failed to get all coordinates", expectedResult, GraphHelper.pacificAtlantic(heights2));
    }
}
