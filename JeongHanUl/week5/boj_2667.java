package nestnet_algorithm_2023_2.JeongHanUl.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_2667 {
    //public class Main {
    static int n;
    static int cnt; // 이웃한 집 카운트
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited; // 방문 체크
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new int[n][n];
        ArrayList<Integer> arrayList = new ArrayList<>(); // 각 단지에 속하는 집의 수를 넣을 리스트

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        // 방문하지 않은 배열 중 집인 경우는 dfs, 아닌 경우는 방문
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 1) {
                        cnt = 1; // cnt 초기화 및 최초 방문하는 집 카운트
                        dfs(i, j);
                        arrayList.add(cnt); // dfs가 종료된 시점의 cnt를 리스트에 add
                    } else {
                        visited[i][j] = true;
                    }
                }
            }
        }

        Collections.sort(arrayList);
        int size = arrayList.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arrayList.get(0));
            arrayList.remove(0);
        }
    }

    public static void dfs(int row, int col) {
        visited[row][col] = true; // 방문 체크

        // 상 하 좌 우 방문
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];

            if (isRange(r, c) && !visited[r][c] && map[r][c] == 1) { // 범위에 들고, 방문하지 않았고, 집인 경우
                cnt++; // 집 갯수 카운트
                dfs(r, c);
            }
        }
    }

    public static boolean isRange(int row, int col) { // 행과 열 범위 확인
        return row < n && row >= 0 && col < n && col >= 0;
    }
}
