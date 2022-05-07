package com.pxd.lettcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 */
public class ValidParenthesesTest {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            char preChar = stack.peek();
            if ((preChar == '(' && ')' == c)
                || (preChar == '[' && ']' == c)
                || (preChar == '{' && '}' == c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid() {
        ValidParenthesesTest test = new ValidParenthesesTest();
        Assert.assertFalse(test.isValid("([)]"));
        Assert.assertTrue(test.isValid("()"));
        Assert.assertTrue(test.isValid("()[]{}"));
        Assert.assertFalse(test.isValid("(]"));
        Assert.assertTrue(test.isValid("{[]}"));
        Assert.assertFalse(test.isValid("(){}}{"));
    }

}
