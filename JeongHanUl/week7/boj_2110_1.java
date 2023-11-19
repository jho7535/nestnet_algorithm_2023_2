package nestnet_algorithm_2023_2.JeongHanUl.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_1 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기 개수

        int[] coordinate = new int[n]; // 집의 좌표
        int[] installed = new int[c]; // 설치된 집의 index
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate);

        int distance = (coordinate[n - 1] - coordinate[0]) / (c - 1);
        // 양끝은 무조건 설치
        installed[0] = 0;
        installed[c - 1] = n - 1;

        for (int i = 1; i < c - 1; i++) {
            int target = coordinate[0] + i * distance;
            int start = 0, end = n - 1;
            int min = Integer.MAX_VALUE, minIndex = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (Math.abs(target - coordinate[mid]) < min) {
                    minIndex = mid;
                    min = (int) Math.abs(target - coordinate[mid]);
                }

                if (coordinate[mid] < target) start = mid + 1;
                else if (coordinate[mid] > target) end = mid - 1;
                else break;
            }

            installed[i] = minIndex;
        }

        for (int i = 0; i < c - 1; i++) {
            if (coordinate[installed[i + 1]] - coordinate[installed[i]] < distance)
                distance = coordinate[installed[i + 1]] - coordinate[installed[i]];
        }

        System.out.println(distance);
    }
}
