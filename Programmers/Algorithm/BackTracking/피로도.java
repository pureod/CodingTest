import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int answer;
    private static int n;
    private static int[][] map;

    private static void dfs(int life, int level) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int[] now = map[i];

            if (life >= map[i][0]) {
                answer = Math.max(answer, level+1);
                visited[i] = true;
                dfs(life - map[i][1], level+1);
                visited[i] = false;
            }
        }

        return;
    }

    public int solution(int k, int[][] dungeons) {
        map = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        answer = 0;

        dfs(k, 0);

        return answer;
    }
}