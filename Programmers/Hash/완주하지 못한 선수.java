import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();

        for (String person : participant) {
            hash.put(person, hash.getOrDefault(person,0)+1);
        }

        for (String person : completion) {
            hash.put(person, hash.getOrDefault(person,1)-1);
            hash.remove(person, 0);
        }

        for (String answer : hash.keySet()) return answer;


        return "";
    }
}