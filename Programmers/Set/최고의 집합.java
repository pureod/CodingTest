import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[] {-1};

        int[] answer = new int[n];

        int quotient = s / n;
        int remain = s % n;

        Arrays.fill(answer,quotient);

        for (int i = 0; i < remain; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);

        return answer;
    }
}