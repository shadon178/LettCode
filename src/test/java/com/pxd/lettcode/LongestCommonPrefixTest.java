package com.pxd.lettcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefixTest {

    public String longestCommonPrefix(String[] strs) {

        int minSize = 0;
        for (int i = 0; i < strs.length; i++) {
            int length = strs[i].length();
            if (length < minSize) {
                minSize = length;
            }
            if (i == 0) {
                minSize = length;
            }
        }

        String result = "";
        char[] firstChars = strs[0].toCharArray();

        for (int i = 0; i <= minSize - 1; i++) {
            char c = firstChars[i];
            for (int j = 0; j < strs.length; j++) {
                char c1 = strs[j].toCharArray()[i];
                if (c != c1) {
                    return result;
                }
            }
            result += c;
        }

        return result;
    }

    @Test
    public void testLongestCommonPrefix() {
        LongestCommonPrefixTest test = new LongestCommonPrefixTest();

        assertEquals("fl", test.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", test.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("a", test.longestCommonPrefix(new String[]{"a"}));
    }

}
