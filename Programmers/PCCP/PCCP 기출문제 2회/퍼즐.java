import java.util.*;

class Solution {
    private static int[] different;
    private static int[] time;
    private static long lim;
    private static int n;

    private static boolean isValid (long level) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (different[i] <= level) sum += time[i];
            else {
                long timeCur = time[i];
                long timePrev = i == 0 ? 0 : time[i-1];

                sum += (different[i] - level) * (timeCur + timePrev) + timeCur;
            }
        }

        if (sum > lim) return false;

        return true;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        n = diffs.length;
        different = diffs;
        time = times;
        lim = limit;
        long left = 0;
        long right = 0;
        for (int diff : diffs) right = (long)Math.max(right,diff);

        int answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isValid(mid)) {
                right = mid - 1;
                answer = (int) mid;
            }
            else {
                left = mid + 1;
            }
        }

        return Math.max(answer,1);
    }
}