import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character,Integer> hash = new HashMap<>();
        for (char c : X.toCharArray()) hash.put(c, hash.getOrDefault(c,0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (char now : Y.toCharArray()) {
            if (hash.containsKey(now)) {
                hash.put(now, hash.get(now) - 1);
                hash.remove(now, 0);

                int target = now - '0';
                pq.add(target);
            }
        }

        if (pq.isEmpty()) return "-1";
        if (pq.peek() == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now);
        }


        return sb.toString();
    }
}