import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        int sum = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < i; k++) {
                    sum += elements[(j+k)%n];
                }
                set.add(sum);
                sum = 0;
            }
        }

        return set.size();
    }
}