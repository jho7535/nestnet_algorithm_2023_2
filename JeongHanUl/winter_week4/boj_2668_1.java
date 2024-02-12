package nestnet_algorithm_2023_2.JeongHanUl.winter_week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_2668_1 {
    //public class Main {
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[] picked = new boolean[n + 1];
        answer = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            combination(arr, picked, n, 0, i, 1);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (answer[i]) cnt++;
        }

        System.out.println(cnt);
        for (int i = 1; i <= n; i++) {
            if (answer[i]) System.out.println(i);
        }
    }

    public static void combination(int[] arr, boolean[] picked, int n, int level, int depth, int start) {
        if (level == depth) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                if (!picked[i]) continue;

                pq.add(arr[i]);
            }

            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                if (!picked[i]) continue;
                if (i != pq.poll()) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer = picked.clone();
        }

        for (int i = start; i <= n; i++) {
            picked[i] = true;
            combination(arr, picked, n, level + 1, depth, i + 1);
            picked[i] = false;
        }
    }
}
