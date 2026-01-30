import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            pq.add(e);
            n -= e;
            
            if (n < 0) {
                if (k == 0) break;
                
                n += pq.poll();
                k--;
            }
            answer++;
        }
        
        return answer;
    }
}