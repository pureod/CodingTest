import java.util.*;

class Solution {
    public int solution(int[][] visible, int[][] hidden, int k) {
        int answer = 0;

        //max : 행 조합의 모든 경우의 수
        double max = Math.pow(2, visible.length);
        // firstColumn[i] : true일 경우 i번 째 행을 뒤집는다.
        boolean[] firstColumn = new boolean[visible.length];
        for(int i = 0; i < max; i++){
            int idx = 0;
            // 모든 행 조합을 구하는 과정
            while(idx < firstColumn.length){
                if(firstColumn[idx]){
                    firstColumn[idx] = false;
                }
                else{
                    firstColumn[idx] = true;
                    break;
                }
                idx++;
            }

            answer = Math.max(answer, flipCards(firstColumn, visible, hidden, k));
        }

        return answer;
    }

    int flipCards(boolean[] firstColumn, int[][] visible, int[][] hidden, int k){
        int ret = 0;

        int n = visible.length;
        int m = visible[0].length;
        // 행과 열이 모두 짝수일 경우 '특수 케이스'
        boolean isSpecialCase = n % 2 == 0 && m % 2 == 0;
        int minLoss = 101;// 빼야할 최소 값. 격자 최대 값은 100이어서 101로 초기화.

        for(int i = 0; i < n; i++){
            if(firstColumn[i]){
                ret -= k;//행을 뒤집은 만큼 비용을 제외.
            }
        }

        // 각 열(세로줄)에 대해 순회하자.
        for(int x = 0; x < m; x++){
            int[] sum = new int[]{0,-k}; // 열을 안뒤집을 경우 / 뒤집을 경우 점수 총합.

            // 열을 안뒤집는 경우/뒤집는 경우 가장 작은 격자의 점수.
            int minNum[] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

            for(int y = 0; y < n; y++){
                for(int l = 0; l < 2; l++){
                    int num = ( (l==1) ^ firstColumn[y]) ? hidden[y][x] : visible[y][x];

                    sum[l] += num;

                    if(isSpecialCase && (x + y) % 2 == 1)
                    {
                        minNum[l] = Math.min(minNum[l], num);
                    }
                }
            }
            // 열을 안뒤집는 경우와 뒤집는 경우를 비교해,
            // 점수가 큰 쪽을 리턴값에 더한다.
            ret += Math.max(sum[0], sum[1]);

            // 특수 케이스일때.
            // loss는 이 열이 '격자 하나를 제외하는 열'로 선택되었을 때
            // 열의 최대 점수 총합에서 빠져나갈 점수이다.
            if(isSpecialCase){
                int loss = Math.max(sum[0], sum[1]) - Math.max(sum[0] - minNum[0], sum[1] - minNum[1]);
                minLoss = Math.min(minLoss, loss);
            }
        }

        return isSpecialCase ? ret - minLoss : ret;
    }
}