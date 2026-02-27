import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static class Node {
        int r, c;

        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i],-1);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (maps[nr][nc] == 0) continue;
                if (dist[nr][nc] != -1) continue;

                queue.add(new Node(nr,nc));
                dist[nr][nc] = dist[now.r][now.c] + 1;
            }
        }

        return dist[n-1][m-1];
    }
}