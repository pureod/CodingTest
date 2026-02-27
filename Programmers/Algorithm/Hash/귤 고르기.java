import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : tangerine) freq.put(v, freq.getOrDefault(v, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freq.values());

        int sum = 0, kinds = 0;
        while (!pq.isEmpty() && sum < k) {
            sum += pq.poll();
            kinds++;
        }
        return kinds;
    }
}
