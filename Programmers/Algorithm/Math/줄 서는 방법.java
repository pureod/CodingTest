import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        if (n == 1) return new int[] {1};

        long[] dp = new long[21];
        dp[0] = 1;
        for (int i = 1; i <= 20; i++) dp[i] = dp[i-1] * i;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int[] answer = new int[n];

        k--;
        int idx = 0;

        while (n > 0) {
            int group = (int)(k / dp[n-1]);

            answer[idx++] = list.remove((int) group);

            k %= dp[n-1];
            n--;
        }

        return answer;
    }
}