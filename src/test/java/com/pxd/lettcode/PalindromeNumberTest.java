package com.pxd.lettcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumberTest {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            //负数情况
            return false;

        } else if (x < 10) {
            //1位情况
            return true;
        }
        int length = getIntLen(x);
        int halfIdx = length / 2;
        for (int i = 1; i <= halfIdx; i++) {
            if (getXPlaceInt(x, i) != getXPlaceInt(x, length - i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取value的第idx位的值
     * @param value
     * @param idx
     */
    public int getXPlaceInt(int value, int idx) {
        return (int) (value / Math.pow(10, idx - 1)) % 10;
    }

    public int getIntLen(int value) {
        int newValue = value / 10;
        if (newValue >= 1) {
            return getIntLen(newValue) + 1;
        } else {
            return 1;
        }
    }

    @Test
    public void testGetIntLen() {
        Assert.assertEquals(2, getIntLen(10));
        Assert.assertEquals(3, getIntLen(107));
        Assert.assertEquals(4, getIntLen(1071));
        Assert.assertEquals(5, getIntLen(10711));
    }

    @Test
    public void testGetXPlaceInt() {
        Assert.assertEquals(0, getXPlaceInt(10, 1));
        Assert.assertEquals(0, getXPlaceInt(101, 2));
        Assert.assertEquals(4, getXPlaceInt(1411, 3));
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(isPalindromeV2(121));
        Assert.assertFalse(isPalindromeV2(-121));
        Assert.assertFalse(isPalindromeV2(10));
        Assert.assertTrue(isPalindromeV2(1001));
    }

    public boolean isPalindromeV2(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself),
        // we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }

}
