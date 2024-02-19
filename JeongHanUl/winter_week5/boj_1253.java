package nestnet_algorithm_2023_2.JeongHanUl.winter_week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] isGood = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int low = 0;
            int high = n - 1;

            while (true) {
                if (low == i) low++;
                else if (high == i) high--;

                if (low >= high) break;

                int sum = arr[low] + arr[high];
                if (sum < target) low++;
                else if (sum > target) high--;
                else {
                    isGood[i] = true;
                    break;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isGood[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
