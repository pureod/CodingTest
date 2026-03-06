import java.util.*;

class Solution {
    private static class Word {
        String name;
        int count;

        public Word (String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];

        ArrayDeque<Word> queue = new ArrayDeque<>();
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word now = queue.pollFirst();

            if (now.name.equals(target)) return now.count;

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                String candidate = words[i];
                int diff = 0;

                for (int j = 0; j < candidate.length(); j++) {
                    if (candidate.charAt(j) != now.name.charAt(j)) diff++;
                }

                if (diff != 1) continue;

                visited[i] = true;
                queue.addLast(new Word(candidate, now.count + 1));
            }
        }

        return 0;
    }
}