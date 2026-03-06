import java.util.*;

// Out of Stack Memory 문제 가능성으로 인해 BFS를 추천 (이 코드로도 통과 가능하긴 함)
class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static String[] map;
    private static int n, m;
    private static ArrayList<Integer> answer;
    private static boolean[][] visited;

    private static int dfs (int r, int c) {
        visited[r][c] = true;
        int sum = map[r].charAt(c) - '0';

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (map[nr].charAt(nc) == 'X') continue;
            if (visited[nr][nc]) continue;

            sum += dfs(nr, nc);
        }
        return sum;
    }

    public int[] solution(String[] maps) {
        map = maps;
        n = maps.length;
        m = maps[0].length();
        answer = new ArrayList<>();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X') continue;
                if (visited[i][j]) continue;

                int result = dfs(i, j);
                answer.add(result);
            }
        }

        if (answer.size() == 0) return new int[] {-1};

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}