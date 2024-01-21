package nestnet_algorithm_2023_2.JeongHanUl.winter_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {
    //public class Main {
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startRow = 0, startCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        bfs(startRow, startCol, map, distance, visited);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && distance[i][j] == 0) distance[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int row, int col, int[][] map, int[][] distance, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];

                if (isRange(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.add(new Coordinate(nr, nc));
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[current.row][current.col] + 1;
                }
            }
        }
    }

    static boolean isRange(int row, int col) { // map 범위 확인
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}

class Coordinate {
    public int row, col;

    public Coordinate(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
