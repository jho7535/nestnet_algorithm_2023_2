package nestnet_algorithm_2023_2.JeongHanUl.winter_week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206 {
    //public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m]; // 맵 저장
        boolean[][][] visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs(n,m,visited,map,0,0));
    }

    static int bfs(int n, int m, boolean[][][] visited, char[][] map, int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c, 1, false));
        visited[r][c][0] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.row == n - 1 && current.col == m - 1)  return current.distance;

            for (int i = 0; i < 4; i++) {
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];

                if (!isRange(n, m, nr, nc)) continue;

                if (map[nr][nc] == '0') {
                    if (!current.broken && !visited[nr][nc][0]) {
                        visited[nr][nc][0] = true;
                        queue.add(new Coordinate(nr, nc, current.distance + 1, false));
                    } else if (current.broken && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.add(new Coordinate(nr, nc, current.distance + 1, true));
                    }
                } else if (map[nr][nc] == '1') {
                    if (!current.broken) {
                        visited[nr][nc][1] = true;
                        queue.add(new Coordinate(nr, nc, current.distance + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isRange(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

class Coordinate {
    public int row, col, distance;
    public boolean broken;

    public Coordinate(int r, int c, int d, boolean b) {
        this.row = r;
        this.col = c;
        this.distance = d;
        this.broken = b;
    }
}
