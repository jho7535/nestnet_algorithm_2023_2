package nestnet_algorithm_2023_2.JeongHanUl.winter_week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2206_1 {
    //public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m]; // 맵 저장
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited[0][0] = true;
        dfs(n, m, visited, map, 0, 0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    map[i][j] = '0';
                    dfs(n, m, visited, map, 0, 0, 1);
                    map[i][j] = '1';
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }

    static void dfs(int n, int m, boolean[][] visited, char[][] map, int r, int c, int cnt) {
        // 종료 조건: n, m에 도착함
        if (r == n - 1 && c == m - 1 && cnt < min) {
            min = cnt;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isRange(n, m, nr, nc)) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] != '0') continue;

            visited[nr][nc] = true;
            dfs(n, m, visited, map, nr, nc, cnt + 1);
            visited[nr][nc] = false;
        }
    }

    static boolean isRange(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
