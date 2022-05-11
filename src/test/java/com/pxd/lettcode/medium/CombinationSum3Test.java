package com.pxd.lettcode.medium;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 * Constraints:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class CombinationSum3Test {

    /**
     * @param k 个数
     * @param n 和
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        combinationResult(result, new ArrayList<>(), num, k, n, 0);
        return result;
    }

    public void combinationResult(
        List<List<Integer>> result, List<Integer> list,
        int[] num, int k, int sum, int start) {
        if (k == 0 && sum == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < num.length && sum > 0 && k > 0; i++) {
                list.add(num[i]);
                combinationResult(result, list, num, k - 1, sum - num[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void testCombinationSum3() {
        List<List<Integer>> test1 = combinationSum3(3, 7);
        assertThat(test1.size(), is(1));
        assertThat(test1, contains(Arrays.asList(1, 2, 4)));

        List<List<Integer>> test2 = combinationSum3(3, 9);
        assertThat(test2.size(), is(3));
        assertThat(test2, contains(
                Arrays.asList(1, 2, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 3, 4)
            )
        );

        assertThat(combinationSum3(4, 1), IsEmptyCollection.empty());
    }

}
