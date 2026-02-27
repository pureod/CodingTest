import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;

        HashMap<String,Integer> hash = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String gem : gems) set.add(gem);

        int allKinds = set.size();

        int left = 0;
        int min = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;

        for (int right = 0; right < n; right++) {
            String now_gem = gems[right];
            hash.put(now_gem, hash.getOrDefault(now_gem,0)+1);

            while (hash.size() == allKinds && left <= right) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    minL = left;
                    minR = right;
                }

                String rm_gem = gems[left];
                hash.put(rm_gem,hash.get(rm_gem)-1);
                hash.remove(rm_gem,0);
                left++;
            }
        }

        return new int[] {minL+1, minR+1};
    }
}