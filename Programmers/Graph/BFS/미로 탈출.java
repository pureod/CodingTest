import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static String[] map;
    private static int n, m;

    private static class Node {
        int r, c;

        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int bfs (Node start, Node end) {
        int startR = start.r;
        int startC = start.c;
        int endR = end.r;
        int endC = end.c;
        int[][] dist = new int[n][m];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(startR,startC));
        dist[startR][startC] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr].charAt(nc) == 'X') continue;
                if (dist[nr][nc] != 0) continue;
                if (nr == endR && nc == endC) return dist[now.r][now.c] + 1;

                queue.addLast(new Node(nr,nc));
                dist[nr][nc] = dist[now.r][now.c] + 1;
            }
        }

        return 0;
    }

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = maps;
        Node start = new Node(0,0);
        Node lever = new Node(0,0);
        Node end = new Node(0,0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char now = maps[i].charAt(j);

                if (now == 'S') {
                    start.r = i;
                    start.c = j;
                }
                else if (now == 'L') {
                    lever.r = i;
                    lever.c = j;
                }
                else if (now == 'E') {
                    end.r = i;
                    end.c = j;
                }
            }
        }

        int dist1 = bfs(start, lever);
        if (dist1 == 0) return -1;
        int dist2 = bfs(lever, end);
        if (dist2 == 0) return -1;

        return dist1 + dist2 - 2;
    }
}