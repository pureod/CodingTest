import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[i][j] = triangle[i][j];
            }
        }

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i-1][j-1];
            }
        }

        return Arrays.stream(dp[n]).max().getAsInt();
    }
}