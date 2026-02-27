import java.util.*;

class Solution {
    private static int answer;

    private static void magic(int floor, int sum) {
        if (floor == 0) {
            if (answer > sum) answer = sum;
            return;
        }

        int remain = floor % 10;
        int quotient = floor / 10;

        if (remain < 5) {
            magic(quotient, sum + remain);
        }
        else if (remain > 5) {
            magic(quotient + 1, sum + (10 - remain));
        }
        else {
            magic(quotient, sum + remain);
            magic(quotient + 1, sum + (10 - remain));
        }

        return;
    }

    public int solution(int storey) {
        answer = Integer.MAX_VALUE;

        magic(storey, 0);

        return answer;
    }
}