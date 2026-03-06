import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        for (int weight: weights) {
            count[weight] += 1;
        }

        for (int w = 100; w < 1001; w++) {
            long c = count[w];
            if (c == 0) continue;

            answer += c * (c-1) / 2;

            if ((w * 3) % 2 == 0) {
                if ((w * 3) / 2 <= 1000) answer += c * count[(w * 3) / 2];
            }

            if (w * 2 <= 1000) answer += c * count[w * 2];

            if ((w * 4) % 3 == 0) {
                if ((w * 4) / 3 <= 1000) answer += c * count[(w * 4) / 3];
            }
        }
        return answer;
    }
}