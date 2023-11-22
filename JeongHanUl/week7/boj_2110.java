package nestnet_algorithm_2023_2.JeongHanUl.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기 개수

        int[] coordinate = new int[n]; // 집의 좌표
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate);

        int low = 1, high = (coordinate[n - 1] - coordinate[0]) / (c - 1) + 1; // 최소 거리 중 low, high
        int mid = 0;

        // 거리를 기준으로 이분 탐색
        while (low <= high) {
            mid = (low + high) / 2;
            int num = install(mid, coordinate, n);

            if (num < c) high = mid - 1;
            else low = mid + 1;
            //else break; num == c인 경우가 많이 나올 수 있음
        }

        System.out.println(high);
    }

    // 최소 거리가 주어졌을 때 설치할 수 있는 공유기 개수 return
    public static int install(int distance, int[] coordinate, int n) {
        int prev = 0, cnt = 1;

        for (int i = 1; i < n; i++) {
            if (coordinate[i] - coordinate[prev] >= distance) {
                prev = i;
                cnt++;
            }
        }

        return cnt;
    }
}
