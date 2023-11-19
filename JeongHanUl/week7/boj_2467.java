package nestnet_algorithm_2023_2.JeongHanUl.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] solution = new int[n];

        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE; // 합이 제일 0에 가까운 값 저장
        int index1 = 0, index2 = 0; // min일 때 두 원소들의 index

        // i번째와 i+1 ~ n-1번째 합이 0에 제일 가까울 때 구하기.
        // 합이 음수면 더 큰 수를 더해줘야 함. right
        // 합이 양수면 더 작은 수를 더해줘야 함. left
        for (int i = 0; i < n - 1; i++) {
            int start = i + 1, end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                int sum = solution[i] + solution[mid];
                if (Math.abs(sum) < min) { // 합의 절댓값으로 비교
                    index1 = i;
                    index2 = mid;
                    min = Math.abs(sum);
                }

                if (sum < 0) start = mid + 1;
                else if (sum > 0) end = mid - 1;
                else break;
            }

            if (min == 0) break;
        }

        System.out.println(solution[index1] + " " + solution[index2]);
    }
}