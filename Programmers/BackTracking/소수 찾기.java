import java.util.*;

class Solution {
    private static int answer;
    private static int n;
    private static String target;
    private static HashSet<Integer> set = new HashSet<>();

    private static void backtrack(boolean[] visited, StringBuilder path) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            path.append(target.charAt(i));
            visited[i] = true;
            isPrime(Integer.parseInt(path.toString()));
            backtrack(visited, path);
            visited[i] = false;
            path.setLength(path.length()-1);
        }
    }

    private static void isPrime(int num) {
        if (num <= 1) return;
        if (set.contains(num)) return;

        set.add(num);

        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) return;
        }
        answer++;
    }

    public int solution(String numbers) {
        n = numbers.length();
        answer = 0;
        target = numbers;

        backtrack(new boolean[n], new StringBuilder());

        return answer;
    }
}