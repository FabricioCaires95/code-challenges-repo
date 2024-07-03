package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairsSolution {

    public static void main(String[] args) {

        System.out.println(climbStairsRecursiveApproach(5));
        System.out.println(climbStarsDpTabulation(5));
        System.out.println(climbStairsWithoutRecursionAndTabulation(5));
    }


    public static int climbStairsRecursiveApproach(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return climbStairsRecursiveApproach(n - 1) + climbStairsRecursiveApproach(n - 2);
    }

    public static int climbStarsDpTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStarsDpMemorization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climStairsDpMemorization(n, memo);
    }

    private static int climStairsDpMemorization(int n, Map<Integer, Integer> memo) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, climbStarsDpMemorization(n - 1) + climbStarsDpMemorization(n - 2));
        }
        return memo.get(n);
    }

    private static int climbStairsWithoutRecursionAndTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
        }

        return cur;
    }
}
