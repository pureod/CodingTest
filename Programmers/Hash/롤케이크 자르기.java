import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer,Integer> old = new HashMap<>();
        HashMap<Integer,Integer> young = new HashMap<>();
        int answer = 0;

        for (int item : topping) {
            young.put(item, young.getOrDefault(item, 0) + 1);
        }

        for (int item : topping) {
            young.put(item, young.get(item) -1);
            old.put(item, old.getOrDefault(item, 0) + 1);
            young.remove(item,0);
            if (young.size() == old.size()) {
                answer += 1;
            }
        }

        return answer;
    }
}