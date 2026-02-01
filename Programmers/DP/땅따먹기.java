import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            dp[i] = land[i].clone();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    if (max < dp[i-1][k]) max = dp[i-1][k];
                }
                dp[i][j] = dp[i][j] + max;
            }
        }

        int answer = 0;
        for (int v : dp[n-1]) {
            if (answer < v) answer = v;
        }

        return answer;
    }
}