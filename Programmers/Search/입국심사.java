import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long mid = -1;
        long answer = 0;

        while (left <= right) {
            long count = 0;
            mid = (left+right) / 2;

            for (int time: times) {
                count += mid / time;
            }

            if (count < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                answer = mid;
            }

        }

        return answer;
    }
}