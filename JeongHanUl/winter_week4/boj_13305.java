package nestnet_algorithm_2023_2.JeongHanUl.winter_week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] road = new int[n]; // 도로 길이 배열
        int[] cost = new int[n]; // 주유 비용 배열

        // 도로 길이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        // 주유 비용 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0; // 총 비용 합
        int roadIndex = 0;
        int minCost = cost[0];
        for (int i = 0; i < n - 1; i++) {
            if (minCost <= cost[i]) continue;

            while (roadIndex < i) {
                sum += (long) minCost * road[roadIndex];
                roadIndex++;
            }

            minCost = cost[i];
        }
        while (roadIndex < n - 1) {
            sum += (long) minCost * road[roadIndex];
            roadIndex++;
        }

        System.out.println(sum);
    }
}
