package nestnet_algorithm_2023_2.JeongHanUl.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2583 {
    //public class Main {
    static int m, n, cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[m][n]; // 직사각형이 있는 곳이 true
        ArrayList<Integer> arrayList = new ArrayList<>(); // 영역의 넓이 저장할 리스트

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            makeRectangle(y1, x1, y2, x2, map);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;

                if (!map[i][j]) {
                    dfs(i, j, map);
                    arrayList.add(cnt);
                }
            }
        }

        arrayList.sort(Comparator.naturalOrder());
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++)
            System.out.print(arrayList.get(i) + " ");
        System.out.println();
    }

    // map에 직사각형 만들기
    public static void makeRectangle(int r1, int c1, int r2, int c2, boolean[][] map) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++)
                map[i][j] = true;
        }
    }

    public static void dfs(int row, int col, boolean[][] map) {
        cnt++;
        map[row][col] = true;

        // 상하좌우 순으로 이동
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];

            if (isRange(n, m, r, c) && !map[r][c]) { // 범위 내, 미방문이고 직사각형으로 가려져 있지 않음
                dfs(r, c, map);
            }
        }
    }

    static boolean isRange(int n, int m, int row, int col) { // map 범위 확인
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
