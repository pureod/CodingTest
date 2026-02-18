import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;

        if (n == 1) return 0;

        for (int m = 0; m < n-1; m++) {
            int old = cookie[m];
            int young = cookie[m+1];

            int l = m;
            int r = m+1;

            while (l >= 0 && r <= n-1) {
                if (old < young) {
                    l--;
                    if (l < 0) break;
                    old += cookie[l];
                }
                else {
                    if (old == young) {
                        answer = Math.max(answer, old);
                    }
                    r++;
                    if (r >= n) break;
                    young += cookie[r];
                }
            }

        }

        return answer;
    }
}