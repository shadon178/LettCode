package com.pxd.lettcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosestTest {

    public int threeSumClosest(int[] nums, int target) {
        return 1;
    }

    @Test
    public void testThreeSumClosest() {
        Assert.assertEquals(2, threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(0, threeSumClosest(new int[]{0,0,0}, 1));
    }

}
