import java.util.*;

class Solution {
    private static int[] dp;

    private static int cal(int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = prev1;

            prev1 = Math.max(prev1, prev2 + dp[i]);
            prev2 = current;
        }

        return prev1;
    }

    public int solution(int sticker[]) {
        int n = sticker.length;
        dp = sticker;

        if (n == 1) return sticker[0];

        int first = cal(0, n-2);
        int second = cal(1, n-1);

        return Math.max(first, second);
    }
}