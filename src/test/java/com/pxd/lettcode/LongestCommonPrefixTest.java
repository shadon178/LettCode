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
        String firstString = strs[0];
        int idx = 0;
        for (int i = 0; i < firstString.length(); i++) {
            char c = firstString.charAt(i);
            for (String str : strs) {
                if (i > str.length() - 1) {
                    return getResult(firstString, idx);
                }
                char c1 = str.charAt(i);
                if (c != c1) {
                    return getResult(firstString, idx);
                }
            }
            idx = i + 1;
        }
        return getResult(firstString, idx);
    }

    private String getResult(String str, int idx) {
        if (idx == 0) {
            return "";
        } else {
            return str.substring(0, idx);
        }
    }

    @Test
    public void testLongestCommonPrefix() {
        LongestCommonPrefixTest test = new LongestCommonPrefixTest();

        assertEquals("fl", test.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", test.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("a", test.longestCommonPrefix(new String[]{"a"}));
    }

}
