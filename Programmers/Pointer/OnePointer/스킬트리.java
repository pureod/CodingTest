import java.util.*;

class Solution {

    private static boolean isValid(String skill, String skillTree) {
        int[] order = new int[128];
        Arrays.fill(order, -1);

        for (int i = 0; i < skill.length(); i++) {
            order[skill.charAt(i)] = i;
        }

        int idx = 0;

        for (int i = 0; i < skillTree.length(); i++) {
            char c = skillTree.charAt(i);

            int pos = order[c];
            if (pos == -1) continue;

            if (pos != idx) return false;
            idx++;
        }

        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            if (isValid(skill, tree)) answer++;
        }
        return answer;
    }
}
