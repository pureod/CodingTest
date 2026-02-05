import java.util.*;

class Solution {
    private static class Node {
        int d, r, c, cost;

        public Node (int d, int r, int c, int cost) {
            this.d = d;
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int n = board.length;
        int[][][] dist = new int[2][n][n];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(-1,0,0,0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0 ; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                int nd = i % 2;
                int ncost = now.cost + ((now.d == -1 || now.d == nd) ? 100 : 600);

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (board[nr][nc] == 1) continue;
                if (dist[nd][nr][nc] != 0 && dist[nd][nr][nc] <= ncost) continue;

                queue.addLast(new Node(nd,nr,nc,ncost));
                dist[nd][nr][nc] = ncost;
            }
        }

        if (dist[0][n-1][n-1] == 0) return dist[1][n-1][n-1];
        if (dist[1][n-1][n-1] == 0) return dist[0][n-1][n-1];

        return Math.min(dist[0][n-1][n-1],dist[1][n-1][n-1]);
    }
}