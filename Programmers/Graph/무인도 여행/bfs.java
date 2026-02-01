import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] visited;
    private static ArrayList<Integer> answer;
    private static int n;
    private static int m;
    private static String[] map;

    private static class Node {
        int r, c;

        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs (int r, int c) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(r,c));
        visited[r][c] = true;
        int sum = map[r].charAt(c) - '0';
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr].charAt(nc) == 'X') continue;
                if (visited[nr][nc]) continue;
                sum += map[nr].charAt(nc) - '0';
                queue.addLast(new Node(nr,nc));
                visited[nr][nc] = true;
            }
        }
        answer.add(sum);

        return;
    }

    public int[] solution(String[] maps) {
        map = maps;
        n = map.length;
        m = map[0].length();
        visited = new boolean[n][m];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    bfs(i,j);
                }
            }
        }
        if (answer.size() == 0) return new int[] {-1};

        int[] arr = answer.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);

        return arr;

    }
}