import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (A[idx] < B[i]) {
                answer += 1;
                idx++;
            }
        }

        return answer;
    }
}