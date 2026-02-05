import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;

        long[] pos_dp = new long[n+1];
        long[] neg_dp = new long[n+1];

        int[] pos_seq = new int[n];
        int[] neg_seq = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) pos_seq[i] = sequence[i];
            else pos_seq[i] = sequence[i] * -1;
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) neg_seq[i] = sequence[i];
            else neg_seq[i] = sequence[i] * -1;
        }

        for (int i = 1; i < n+1; i++) {
            pos_dp[i] = Math.max(pos_seq[i-1], pos_dp[i-1] + pos_seq[i-1]);
        }

        for (int i = 1; i < n+1; i++) {
            neg_dp[i] = Math.max(neg_seq[i-1], neg_dp[i-1] + neg_seq[i-1]);
        }

        long pos_max = Long.MIN_VALUE;
        for (long v : pos_dp) pos_max = Math.max(v, pos_max);

        long neg_max = Long.MIN_VALUE;
        for (long v : neg_dp) neg_max = Math.max(v, neg_max);

        return Math.max(pos_max, neg_max);
    }
}