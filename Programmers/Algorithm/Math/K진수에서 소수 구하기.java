import java.util.*;

class Solution {
    private static boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i <= num / i ; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public int solution(int n, int k) {
        String temp = Integer.toString(n,k);
        String[] arr = temp.split("0");
        int answer = 0;

        for (String now : arr) {
            if (now.isEmpty()) continue;
            if (isPrime(Long.valueOf(now))) answer++;
        }

        return answer;
    }
}