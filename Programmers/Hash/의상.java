import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();

        for (String[] product : clothes) hash.put(product[1], hash.getOrDefault(product[1], 0) + 1);

        int answer = 1;

        for (int num : hash.values()) answer *= num + 1;

        return answer - 1;
    }
}