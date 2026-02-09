import java.util.*;

class Solution {
    private static boolean canCross(int[] stone, int k, int target) {
        int imp = 0;
        for (int s : stone) {
            if (s < target) {
                imp++;
                if (imp == k) return false;
            }
            else {
                imp = 0;
            }
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1;
        int high = 0;
        for (int s : stones) high = Math.max(high, s);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return answer;
    }
}