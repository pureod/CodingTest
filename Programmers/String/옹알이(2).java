import java.util.*;

class Solution {
    private static boolean isValid(String str) {
        String prev = "";

        while (!str.isEmpty()) {
            if (str.startsWith("aya") && !prev.equals("aya")) {
                str = str.substring(3);
                prev = "aya";
            } else if (str.startsWith("ye") && !prev.equals("ye")) {
                str = str.substring(2);
                prev = "ye";
            } else if (str.startsWith("woo") && !prev.equals("woo")) {
                str = str.substring(3);
                prev = "woo";
            } else if (str.startsWith("ma") && !prev.equals("ma")) {
                str = str.substring(2);
                prev = "ma";
            } else {
                return false;
            }
        }
        return true;
    }


    public int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            if (isValid(s)) answer++;
        }

        return answer;
    }
}