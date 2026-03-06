import java.util.*;

class Solution {
    private static class Node {
        int dest, cost;

        public Node (int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.cost, o2.cost));

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < road.length; i++) {
            adjList[road[i][0]].add(new Node(road[i][1],road[i][2]));
            adjList[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }

        pq.add(new Node(1,0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) continue;

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] < now.cost + next.cost) continue;

                dist[next.dest] = now.cost + next.cost;
                pq.add(new Node(next.dest, dist[next.dest]));
            }
        }

        int answer = 0;

        for (int i = 1; i < N+1; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}