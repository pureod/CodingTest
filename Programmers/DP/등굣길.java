import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] blocked = new boolean[n + 1][m + 1]; // [y][x]
        for (int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            blocked[y][x] = true;
        }

        int[][] dp = new int[n + 1][m + 1]; // [y][x]
        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (x == 1 && y == 1) continue;
                if (blocked[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
