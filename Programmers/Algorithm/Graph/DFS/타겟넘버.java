import java.util.*;

class Solution {
    private static int[] map;
    private static int answer;
    private static int n;

    private static void dfs (int level, int sum, int target) {
        if (level == n) {
            if (sum == target) answer++;
            return;
        }

        dfs(level+1, sum+map[level], target);
        dfs(level+1, sum-map[level], target);

        return;
    }

    public int solution(int[] numbers, int target) {
        map = numbers;
        answer = 0;
        n = numbers.length;

        dfs(0,0, target);

        return answer;
    }
}