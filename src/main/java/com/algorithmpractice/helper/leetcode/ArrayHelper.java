package com.algorithmpractice.helper.leetcode;

import java.util.*;

public class ArrayHelper {

    public static<T> int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    //Merge sort
    public static int[] MergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else if (array.length == 2) {
            if (array[1] < array[0]) {
                int tmp = array[1];
                array[1] = array[0];
                array[0] = tmp;   
            }
            return array;
        } else {
            int mid = array.length / 2;
            int[] leftHalf = subArray(array, 0 , mid);
            int[] rightHalf = subArray(array, mid + 1, array.length - 1);
            return combineTwoSortedArray(MergeSort(leftHalf), MergeSort(rightHalf));
        }
    }
    
    
    public static int[] combineTwoSortedArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int resultIndexPointer = 0;
        
        int i = 0;
        int j = 0;
        
        while (i <= nums1.length - 1 && j <= nums2.length - 1){
            if (nums1[i]<nums2[j]) {
                result[resultIndexPointer] = nums1[i];
                resultIndexPointer++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                result[resultIndexPointer] = nums2[j];
                resultIndexPointer++;
                j++;
            } else {
                result[resultIndexPointer] = nums1[i];
                resultIndexPointer++;
                i++;
                result[resultIndexPointer] = nums2[j];
                resultIndexPointer++;
                j++;
            }
        }
        if (i == nums1.length && j == nums2.length){
            return result;
        } else if (i == nums1.length && j <= nums2.length - 1) {
            for (int index = j; index <= nums2.length - 1; index++) {
                result[resultIndexPointer] = nums2[index];
                resultIndexPointer++;
            }
        } else {
            for (int index = i; index <= nums1.length - 1; index++) {
                result[resultIndexPointer] = nums1[index];
                resultIndexPointer++;
            }
        }
        return result;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     * @return median of 2 sorted arrays
     */
    public static double findMediumOfTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMediumOfTwoSortedArray(nums2, nums1);
        }
        
        int totalLength = nums1.length + nums2.length;
        boolean isTotalLengthEven = totalLength % 2 == 0;

        if (nums1.length == 0 && nums2.length != 0) {
            return isTotalLengthEven ? (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2 : nums2[nums2.length / 2];         
        }

        int partitionX = nums1.length == 1 ? 1 : nums1.length / 2;
        int partitionY = isTotalLengthEven ? totalLength / 2 - partitionX : (totalLength + 1) / 2 - partitionX;
        int highP1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
        int highP2 = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
        int lowP1 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
        int lowP2 = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];

        while (partitionX >=0 && partitionX <= nums1.length) {
            highP1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            highP2 = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
            lowP1 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            lowP2 = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
            if (highP1 <= lowP2 && lowP1 <= highP2) {
                break;
            } else if (highP1 > lowP2) {
                partitionX--;
                partitionY = isTotalLengthEven ? totalLength / 2 - partitionX : (totalLength + 1) / 2 - partitionX;
            } else {
                partitionY--;
                partitionX = isTotalLengthEven ? totalLength / 2 - partitionY : (totalLength + 1) / 2 - partitionY;
            }
        }
        if (isTotalLengthEven) {
            return (double) (Math.max(highP1, lowP1) + Math.min(highP2, lowP2)) / 2;
        } else {
            return Math.max(highP1, lowP1);
        }
    }

    /**
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     *
     * Notice that you may not slant the container.
     */
    public static int maxAreaWaterContainer(int[] height) {
        int length = height.length;
        int pA = 0, pB = length - 1;
        int borderLeft = height[0], borderRight = height[length-1];
        int maxArea = Math.min(height[pA],height[pB]) * (pB-pA), maxAreaAux;

        while (pA < pB) {
            if (borderLeft < borderRight) {
                pA++;
                if (height[pA] > borderLeft) {
                    borderLeft=height[pA];
                    maxAreaAux = Math.min(height[pA],height[pB]) * (pB-pA);
                    maxArea = Math.max(maxArea, maxAreaAux);
                }
            } else {
                pB--;
                if (height[pB] > borderRight) {
                    borderRight=height[pB];
                    maxAreaAux = Math.min(height[pA],height[pB]) * (pB-pA);
                    maxArea = Math.max(maxArea, maxAreaAux);
                }
            }
        }
        return maxArea;
    }

    /**
     * 19. Remove Nth Node From End of List
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode auxHead = head;
        int length = 1;
        while (auxHead.next != null) {
            auxHead = auxHead.next;
            length++;
        }

        ListNode lastNode = head;
        if (length == 1) return null;
        if (length - n - 1 == -1) return head.next;
        for (int i = 0; i <= length - n - 1; i++) {
            if (i == length - n -1) {
                assert lastNode != null;
                lastNode.next = lastNode.next != null ? lastNode.next.next : null;
            }
            lastNode = lastNode != null ? lastNode.next : null;
        }
        return head;
    }



    /**
     * 55. Jump Game
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     */
    public static boolean canJump(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 1) {
            return true;
        }
        int tmpMaxIndexReachable = 0;
        for (int i = 0; i <= numsLength - 2; i++) {
            if (i == 0) {
                tmpMaxIndexReachable = nums[0];
            } else {
                tmpMaxIndexReachable = Math.max(tmpMaxIndexReachable, tmpMaxIndexReachable >= i ?  i + nums[i] : Integer.MIN_VALUE);
            }
            if (tmpMaxIndexReachable >= numsLength - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 152. Maximum Product Subarray
     * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
     *
     * It is guaranteed that the answer will fit in a 32-bit integer.
     *
     * A subarray is a contiguous subsequence of the array.
     */
    public static int maxProduct(int[] nums) {
        int maxValue = nums[0];
        int auxMin = 1, auxMax = 1;
        int tmp;

        for (int num: nums) {
            if (num == 0) {
                auxMin = 1;
                auxMax = 1;
            }
            auxMax = Math.max(num * auxMax, Math.max(num * auxMin, num));
            auxMin = Math.min(num * auxMax, Math.min(num * auxMin, num));
            maxValue = Math.max(maxValue, auxMax);
        }
        return maxValue;
    }

    /**
     * 198. House Robber
     * Medium
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     */
    public static int rob(int[] nums){
        int size = nums.length;
        int[] storedMaxVal = new int[size];
        int maxAmount = nums[0];

        for (int i = 0;i <= size - 1; i++) {
            if (i == 0) {
                storedMaxVal[i] = maxAmount;
                continue;
            } else if (i == 1) {
                maxAmount = Math.max(maxAmount, nums[1]);
            } else {
                maxAmount = Math.max(maxAmount, nums[i] + storedMaxVal[i-2]);
            }
            storedMaxVal[i] = maxAmount;
        }
        return maxAmount;
    }

    /**
     * 213. House Robber II
     * Medium
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     */
    public static int robII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] numsCandidate1 = new int[nums.length-1];
        int[] numsCandidate2 = new int[nums.length-1];
        System.arraycopy(nums, 0, numsCandidate1, 0, nums.length - 2 + 1);
        System.arraycopy(nums, 1, numsCandidate2, 0, nums.length - 1);
        return Math.max(rob(numsCandidate1),rob(numsCandidate2));
    }

    /**
     * 238. Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * @return product of input array except self
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] numAuxLeft = new int[length];
        int[] numAuxRight = new int[length];
        int[] result = new int[length];
        
        for (int i = 0; i <= length - 1; i++) {
            numAuxLeft[i] = i == 0 ? 1 : nums[i-1] * numAuxLeft[i-1]; 
        }
        for (int k = length - 1; k >= 0; k--) {
            numAuxRight[k] = k == length - 1 ? 1 : nums[k+1] * numAuxRight[k+1];
        }
        
        for (int j = 0; j <= length - 1; j++) {
            result[j] = numAuxLeft[j] * numAuxRight[j];
        }
        return result;
    }

    /**
     300. Longest Increasing Subsequence
     Given an integer array nums, return the length of the longest strictly increasing subsequence.

     A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int numAux;
        int maxLengthLITAux;
        int maxLength = 1;
        Map<Integer, Integer> calculatedLTS = new HashMap<>();

        calculatedLTS.put(length-1,1);

        for (int i = length-2;i >= 0;i--) {
            numAux = nums[i];
            maxLengthLITAux = 1;
            for (int j = i+1;j<=length-1;j++) {
                if (nums[j] > numAux) {
                    maxLengthLITAux = Math.max(maxLengthLITAux, 1 + calculatedLTS.get(j));
                }
            }
            calculatedLTS.put(i,maxLengthLITAux);
            maxLength = Math.max(maxLengthLITAux, maxLength);
        }
        return maxLength;
    }

    /**
     * 322. Coin Change
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     * @param coins
     * @param amount
     * @return the fewest number of coins that you need to make up that amount
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        Map<Integer, Integer> recordedResults = new HashMap<>();
        int minNumCoinsAux;

        for (int val = 0;val <= amount; val++) {
            minNumCoinsAux = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (val == coin) {
                    recordedResults.put(val,1);
                    break;
                } else if (val > coin) {
                    if (recordedResults.containsKey(val - coin)) {
                        minNumCoinsAux = Math.min(1 + recordedResults.get(val - coin), minNumCoinsAux);
                        recordedResults.put(val,minNumCoinsAux);
                    }
                }
            }
        }
        return recordedResults.getOrDefault(amount, -1);
    }


    /**
     * 121. Best Time to Buy and Sell Stock
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */
    public static int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;
        int maxProfit = 0;

        while (end < prices.length) {
            if (prices[start] < prices[end]) {
                maxProfit = Math.max(maxProfit,  prices[end] - prices[start]);
            } else {
                start = end;
            }
            end++;
        }
        return maxProfit;
    }

    /**
     * 1366. Rank Teams by Votes
     * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
     * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved.
     * If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
     * Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
     * Return a string of all teams sorted by the ranking system.
     *
     * Example 1:
     * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
     * Output: "ACB"
     * Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
     * Team B was ranked second by 2 voters and was ranked third by 3 voters.
     * Team C was ranked second by 3 voters and was ranked third by 2 voters.
     * As most of the voters ranked C second, team C is the second team and team B is the third.
     *
     *
     * Example 2:
     * Input: votes = ["WXYZ","XYZW"]
     * Output: "XWYZ"
     * Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position but X has one vote as second position while W doesn't have any votes as second position.
     *
     *
     * Example 3:
     * Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
     * Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
     * Explanation: Only one voter so his votes are used for the ranking.
     */
    public static String rankTeams(String[] votes) {
        int teamCount = votes[0].length();
        Map<Character, int[]> teamVotesMap = new HashMap<>();

        for (String vote: votes) {
            for (int j = 0; j <= teamCount - 1; j++) {
                Character c = vote.charAt(j);
                teamVotesMap.putIfAbsent(c, new int[teamCount]);
                teamVotesMap.get(c)[j]++;
            }
        }

        List<Character> list = new ArrayList<>(teamVotesMap.keySet());
        list.sort((a,b) -> {
            for (int i = 0; i <= teamCount - 1; i++) {
                if (teamVotesMap.get(a)[i] != teamVotesMap.get(b)[i]) {
                    return teamVotesMap.get(b)[i] - teamVotesMap.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder result = new StringBuilder();
        for (Character team: list) {
            result.append(team);
        }
        return result.toString();
    }


    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     *
     *
     * STDIN       Function
        -----       --------
        2           t = 2
        5           n = 5
        2 1 5 3 4   q = [2, 1, 5, 3, 4]
        5           n = 5
        2 5 1 3 4   q = [2, 5, 1, 3, 4]
        *
        * 3 Too chaotic
     */
    public static void minimumBribes(List<Integer> q) {
        int overallCounter = 0;
        Integer tmp;
        for (int i = q.size() - 1; i >= 2; i--) {
            if (q.get(i) != i+1) {
                if (q.get(i-1) == i) {
                    tmp = q.get(i);
                    q.set(i, q.get(i -1));
                    q.set(i-1,tmp);
                    overallCounter++;
                } else if (q.get(i-2) == i) {
                    tmp = q.get(i);
                    q.set(i, q.get(i - 2));
                    q.set(i-2,tmp);
                    overallCounter = overallCounter + 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(overallCounter);
    }

    /**
        Jesse loves cookies and wants the sweetness of some cookies to be greater than value . To do this, two cookies with the least sweetness are repeatedly mixed. This creates a special combined cookie with:

        sweetness  Least sweet cookie 2nd least sweet cookie).

        This occurs until all the cookies have a sweetness.

        K = 9
        A = [2,3,4,6,6,7]

     */
    public static int cookies(int k, List<Integer> A) {
        Collections.sort(A);
        int numberOfOperations = 0;

        while (A.get(0) < k) {
            int cookieReplacement = A.get(0) + A.get(1) * 2;
            A.remove(0);
            A.remove(0);
            if (A.isEmpty() || cookieReplacement > A.get(A.size() - 1)) {
                A.add(cookieReplacement);
            } else {
                for (int i = 0; i <= A.size() - 1; i++) {
                    if (A.get(i) >= cookieReplacement) {
                        A.add(i,cookieReplacement);
                          break;
                    }
                }
            }
            numberOfOperations++;
            if (A.size() == 1 && A.get(0) < k) {
                return -1;
            }
        }
        return numberOfOperations;
    }


    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i <= digits.length()-1; i++) {
            while (ans.peek().length() == i) {
                char[] letterCombo = mapping[Character.getNumericValue(digits.charAt(i))].toCharArray();
                String t = ans.remove();
                for (char alphabet: letterCombo) {
                    ans.add(t+alphabet);
                }
            }
        }
        return ans;
    }











}
