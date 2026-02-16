class Solution {
    private static int n;
    private static int[] map;
    private static List<List<Integer>> answer;
    private static boolean[] visited;

    private static void dfs(List<Integer> path) {
        if (path.size() == n) {
            List<Integer> temp = new ArrayList(path);
            answer.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            for (int v : path) {
                System.out.print(v);
            }
            System.out.println("");

            visited[i] = true;
            path.add(map[i]);
            dfs(path);
            path.remove(path.size()-1);
            visited[i] = false;
        }

        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        n = nums.length;
        map = nums;
        visited = new boolean[n];

        List<Integer> list = new ArrayList<>();

        dfs(list);

        return answer;
    }
}