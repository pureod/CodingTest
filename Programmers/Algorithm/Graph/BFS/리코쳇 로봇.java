import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int n, m;
    private static boolean[][] visited;
    private static String[] map;

    private static class Node {
        int r, c, count;

        public Node (int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    private static boolean isValid (int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= n || nc >= m) return false;
        if (map[nr].charAt(nc) == 'D') return false;

        return true;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = board;
        Node red = new Node(0,0,0);
        Node green = new Node(0,0,0);

        visited = new boolean[n][m];
        ArrayDeque<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    red.r = i;
                    red.c = j;
                }
                else if (board[i].charAt(j) == 'G') {
                    green.r = i;
                    green.c = j;
                }
            }
        }

        visited[red.r][red.c] = true;
        queue.add(new Node(red.r,red.c,0));

        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();

            if (now.r == green.r && now.c == green.c) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r;
                int nc = now.c;

                while (isValid(nr+dx[i],nc+dy[i])) {
                    nr += dx[i];
                    nc += dy[i];
                }

                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.addLast(new Node(nr,nc,now.count+1));
            }
        }

        return -1;
    }
}