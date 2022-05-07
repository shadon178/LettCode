package com.pxd.lettcode;

import com.sun.istack.internal.localization.NullLocalizable;
import org.junit.Assert;
import org.junit.Test;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToIntTest {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        int maxValue = 0;
        for (int i = chars.length - 1; i >= 0; i--) {

            int value = char2Int(chars[i]);
            if (maxValue == 0) {
                total += value;
                maxValue = value;

            } else {
                if (maxValue > value) {
                    total -= value;
                } else {
                    total += value;
                    maxValue = value;
                }
            }
        }
        return total;
    }

    private int char2Int(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                throw new RuntimeException("无法识别的字符：" + c);
        }
    }

    @Test
    public void testRomanToInt() {
        //III = 3.
        Assert.assertEquals(3, romanToInt("III"));

        //L = 50, V= 5, III = 3.
        Assert.assertEquals(58, romanToInt("LVIII"));

        //M = 1000, CM = 900, XC = 90 and IV = 4.
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

}
