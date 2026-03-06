import java.util.*;

class Solution {
    private boolean[] used;
    private String[] answer;
    private int n;

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        used = new boolean[n];

        // (출발, 도착) 사전순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path, 0);
        return answer;
    }

    // cur: 현재 공항, depth: 사용한 티켓 수
    private boolean dfs(String cur, String[][] tickets, List<String> path, int depth) {
        // 티켓을 다 썼으면 경로 완성
        if (depth == n) {
            answer = path.toArray(new String[0]);
            return true; // 첫 정답이 사전순 최소 -> 탐색 종료
        }

        // 현재 공항에서 출발 가능한 티켓들을 순서대로 시도
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (!tickets[i][0].equals(cur)) continue;

            used[i] = true;
            path.add(tickets[i][1]);

            // 다음 단계로
            if (dfs(tickets[i][1], tickets, path, depth + 1)) return true;

            // 되돌리기(백트래킹)
            path.remove(path.size() - 1);
            used[i] = false;
        }

        return false;
    }
}
