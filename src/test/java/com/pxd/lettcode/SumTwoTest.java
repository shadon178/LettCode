package com.pxd.lettcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a>
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class SumTwoTest {

    public int[] twoSumV1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int subtrahend = target - nums[i];
            Integer idx = map.get(subtrahend);
            if (idx != null && idx != i) {
                return new int[]{i, idx};
            }
        }
        return null;
    }

    public int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subtrahend = target - nums[i];
            if (map.containsKey(subtrahend)) {
                return new int[]{map.get(subtrahend), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void testTwoSum() {
        SumTwoTest sumTwo = new SumTwoTest();
        Assert.assertArrayEquals(sumTwo.twoSumV3(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Assert.assertArrayEquals(sumTwo.twoSumV3(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        Assert.assertArrayEquals(sumTwo.twoSumV3(new int[]{3, 3}, 6), new int[]{0, 1});
        Assert.assertArrayEquals(sumTwo.twoSumV3(new int[]{-1, -2, -3, -4, -5}, -8), new int[]{2, 4});
    }

}
