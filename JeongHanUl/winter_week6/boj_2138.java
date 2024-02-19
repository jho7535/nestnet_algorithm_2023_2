package nestnet_algorithm_2023_2.JeongHanUl.winter_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2138 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        boolean[] start = new boolean[n]; // 전구 현재 상태
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') start[i] = true;
        }

        str = br.readLine();
        boolean[] end = new boolean[n]; // 만들고자 하는 상태
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') end[i] = true;
        }

        boolean[] state = start.clone();
        int cnt0 = solve(0, state, end, n);
        state = start.clone();
        int cnt1 = solve(1, state, end, n);

        if (cnt0 == Integer.MAX_VALUE && cnt1 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(cnt0, cnt1));
        }
    }

    public static int solve(int o, boolean[] start, boolean[] end, int n) {
        int cnt = 0;

        if (o == 1) {
            start[0] = !start[0];
            start[1] = !start[1];
            cnt++;
        }

        for (int i = 1; i < n - 1; i++) {
            if (end[i - 1] != start[i - 1]) {
                start[i - 1] = !start[i - 1];
                start[i] = !start[i];
                start[i + 1] = !start[i + 1];
                cnt++;
            }
        }

        if (end[n - 2] != start[n - 2]) {
            start[n - 2] = !start[n - 2];
            start[n - 1] = !start[n - 1];
            cnt++;
        }

        return (Arrays.equals(start, end)) ? cnt : Integer.MAX_VALUE;
    }
}
