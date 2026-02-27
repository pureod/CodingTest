import java.util.*;

class Solution {
    private static int mod (int num, int[] data) {
        int result = 0;
        
        for (int d : data) {
            result += d % num;
        }
        
        return result;
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1,o2) -> {
            if (o1[col-1] != o2[col-1]) return Integer.compare(o1[col-1],o2[col-1]);
            else return Integer.compare(o2[0],o1[0]);
        });
        
        int range = row_end - row_begin + 1;
        int[] mod_arr = new int[range];
        
        int idx = 0;
        for (int i = row_begin-1; i < row_end; i++) {
            mod_arr[idx] = mod(i+1, data[i]);
            idx++;
        }
           
        int answer = 0;
        for (int value : mod_arr) {
            answer = answer ^ value;
        }
        
        return answer;
    }
}