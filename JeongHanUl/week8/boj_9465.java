package nestnet_algorithm_2023_2.JeongHanUl.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- != 0) {
            // 스티커 점수 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[2][n];
            int[][] dp = new int[2][n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map[1][i] = Integer.parseInt(st.nextToken());
            }

            // dp 시작
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if (n > 1) {
                dp[0][1] = dp[1][0] + map[0][1];
                dp[1][1] = dp[0][0] + map[1][1];
            }

            // 0, 1행을 같이 계산. 단일 for문
            for (int i = 2; i < n; i++) {
                dp[0][i] = (dp[1][i - 2] > dp[1][i - 1] ? dp[1][i - 2] + map[0][i] : dp[1][i - 1] + map[0][i]);
                dp[1][i] = (dp[0][i - 2] > dp[0][i - 1] ? dp[0][i - 2] + map[1][i] : dp[0][i - 1] + map[1][i]);
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
