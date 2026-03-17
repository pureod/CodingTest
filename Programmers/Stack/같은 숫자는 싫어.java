import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peekLast() == arr[i]) continue;
            stack.addLast(arr[i]);
        }
        int size = stack.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = stack.pollFirst();
        }

        return answer;
    }
}