import java.util.*;

class Solution {
    private static ArrayList<Info>[] adjList;
    private static int N;

    private static class Info {
        int dest, cost;

        public Info (int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static int[] makeDijk (int num) {
        PriorityQueue<Info> pq = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.cost,o2.cost));

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[num] = 0;
        pq.add(new Info(num,0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (dist[now.dest] < now.cost) continue;

            for (Info next : adjList[now.dest]) {
                if (dist[next.dest] <= now.cost + next.cost) continue;
                dist[next.dest] = now.cost + next.cost;
                pq.add(new Info(next.dest, dist[next.dest]));
            }
        }

        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        adjList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) adjList[i] = new ArrayList<>();

        for (int[] fare : fares) {
            adjList[fare[0]].add(new Info(fare[1],fare[2]));
            adjList[fare[1]].add(new Info(fare[0],fare[2]));
        }

        int[] dijk_A = makeDijk(a);
        int[] dijk_B = makeDijk(b);
        int[] dijk_S = makeDijk(s);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n+1; i++) {
            int sum = dijk_A[i] + dijk_B[i] + dijk_S[i];

            if (sum < answer) answer = sum;
        }

        return answer;
    }
}