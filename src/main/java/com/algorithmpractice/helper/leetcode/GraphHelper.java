package com.algorithmpractice.helper.leetcode;

import java.util.*;

public class GraphHelper {

   static Set<Integer> courseVisited = new HashSet<>();
   static Map<Integer, ArrayList<Integer>> coursePrerequisites = new HashMap<>();
   static Set<String> hashSetPacific = new HashSet<>();
   static Set<String> hashSetAtlantic = new HashSet<>();
   static Set<List<Integer>> numIslandsVisited = new HashSet<>();

    /**
     * 133. Clone Graph
     * Given a reference of a node in a connected undirected graph.
     *
     * Return a deep copy (clone) of the graph.
     *
     * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
     */
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private final HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node nodeClone = new Node(node.val);
        map.put(node.val,nodeClone);
        for (Node neighbour: node.neighbors) {
            nodeClone.neighbors.add(clone(neighbour));
        }
        return nodeClone;
    }


    /**
     * 200. Number of Islands
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     */
    public static int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length, columns = grid[0].length;

        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                if (String.valueOf(grid[i][j]).equals("1") && !numIslandsVisited.contains(Arrays.asList(i,j))) {
                    numIslandsVisited.add(Arrays.asList(i,j));
                    numIslandsBFS(i,j, grid, rows, columns);
                    result++;
                }
            }
        }
        return result;
    }

    private static void numIslandsBFS(int x, int y, char[][] grid, int rows, int columns) {
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<List<Integer>> trackedCells = new LinkedList<>();
        trackedCells.add(Arrays.asList(x,y));
        while (!trackedCells.isEmpty()) {
            List<Integer> currentCell = trackedCells.remove();
            for (int[] direction: directions) {
                if (currentCell.get(0) + direction[0] < rows && currentCell.get(0) + direction[0] >=0
                        && currentCell.get(1) + direction[1] < columns && currentCell.get(1) + direction[1] >=0) {
                    List<Integer> newCellToCheck = Arrays.asList(currentCell.get(0) + direction[0], currentCell.get(1) + direction[1]);
                    if (!numIslandsVisited.contains(newCellToCheck)
                            && String.valueOf(grid[currentCell.get(0) + direction[0]][currentCell.get(1) + direction[1]]).equals("1")) {
                        trackedCells.add(newCellToCheck);
                        numIslandsVisited.add(newCellToCheck);
                    }
                }
            }
        }
    }


    /**
     * 207. Course Schedule
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i <= numCourses - 1; i++) {
            coursePrerequisites.put(i, new ArrayList<>());
        }
        for (int[] pair: prerequisites) {
            ArrayList<Integer> auxPrerequisites = coursePrerequisites.get(pair[0]);
            auxPrerequisites.add(pair[1]);
            coursePrerequisites.put(pair[0], auxPrerequisites);
        }
        for (int i = 0; i <= numCourses - 1; i++) {
            if (!takeCourse(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean takeCourse(int course) {
        if (courseVisited.contains(course)) return false;
        if (coursePrerequisites.get(course).size() == 0) return true;
        courseVisited.add(course);
        for (Integer prerequisiteCourse: coursePrerequisites.get(course)) {
            if (!takeCourse(prerequisiteCourse)) return false;
        }
        courseVisited.remove(course);
        coursePrerequisites.put(course,new ArrayList<>());
        return true;
    }

    /**
     * 417. Pacific Atlantic Water Flow
     * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
     *
     * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
     *
     * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
     *
     * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
     */
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultSet = new ArrayList<>();

        for (int i = 0; i <= heights[0].length - 1; i++) {
            pacificAtlanticDFS(0, i, hashSetPacific, heights[0][i], heights);
            pacificAtlanticDFS(heights.length - 1, i, hashSetAtlantic,heights[heights.length - 1][i], heights);
        }
        for (int i = 0; i <= heights.length - 1; i++) {
            pacificAtlanticDFS(i, 0, hashSetPacific, heights[i][0], heights);
            pacificAtlanticDFS(i, heights[0].length - 1, hashSetAtlantic, heights[i][heights[0].length - 1], heights);
        }

        for (int i = 0; i <= heights.length - 1; i++) {
            for (int j = 0; j <= heights[i].length - 1; j++) {
                String tmpCoordinates = i + String.valueOf(j);
                Integer[] coordinatesList = {i,j};
                if (hashSetPacific.contains(tmpCoordinates) && hashSetAtlantic.contains(tmpCoordinates)) {
                    resultSet.add(Arrays.asList(coordinatesList));
                }
            }
        }
        return resultSet;

    }

    private static void pacificAtlanticDFS(int r, int c, Set<String> visited, int previousHeight, int[][] heights) {
        if (visited.contains(r + String.valueOf(c)) || r < 0 || c < 0 || r == heights.length || c == heights[0].length
                  || heights[r][c] < previousHeight) {
            return;
        }

        visited.add(r + String.valueOf(c));
        pacificAtlanticDFS(r + 1, c, visited, heights[r][c], heights);
        pacificAtlanticDFS(r - 1, c, visited, heights[r][c], heights);
        pacificAtlanticDFS(r, c + 1, visited, heights[r][c], heights);
        pacificAtlanticDFS(r, c - 1, visited, heights[r][c], heights);
    }

}
