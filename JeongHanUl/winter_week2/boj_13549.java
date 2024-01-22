package nestnet_algorithm_2023_2.JeongHanUl.winter_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549 {
    //public class Main {
    static int[] d = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];

        bfs(n, time, visited);

        System.out.println(time[k]);
    }

    public static void bfs(int start, int[] time, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 순간이동 하는 경우
            int nx = current * 2;

            if (isRange(nx) && !visited[nx]) {
                queue.add(nx);
                visited[nx] = true;
                time[nx] = time[current]; // 시간이 추가로 걸리지 않음
            }

            // 걷는 경우
            for (int i = 0; i < 2; i++) {
                nx = current + d[i];

                if (isRange(nx) && !visited[nx]) {
                    queue.add(nx);
                    visited[nx] = true;
                    time[nx] = time[current] + 1; // 1초의 시간이 추가로 걸림
                }
            }
        }
    }

    public static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }
}
