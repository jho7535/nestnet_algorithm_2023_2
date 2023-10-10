package nestnet_algorithm_2023_2.JeongHanUl.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026 {
    //public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] falseMap = new char[n][n]; // 적록색약이 아닌 사람이 보는 그림
        char[][] trueMap = new char[n][n]; // 적록색약인 사람이 보는 그림. 녹색을 적색으로 입력

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                falseMap[i][j] = str.charAt(j);
                trueMap[i][j] = (str.charAt(j) == 'G' ? 'R' : str.charAt(j)); // 녹색이면 적색으로 입력
            }
        }

        int falseCnt = 0; // 색약이 아닌 사람이 보는 구역 개수 카운트
        int tureCnt = 0; // 색약인 사람이 보는 구역 개수 카운트
        boolean[][] falseVisited = new boolean[n][n]; // 방문 확인
        boolean[][] trueVisited = new boolean[n][n]; // 방문 확인

        // 색약이 아닌 사람이 보는 map을 돌며 방문하지 않은 지점에서 dfs. dfs가 끝나면 cnt++
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!falseVisited[i][j]) {
                    dfs(n, falseMap, falseVisited, falseMap[i][j], i, j);
                    falseCnt++;
                }
            }
        }

        // 색약인 사람이 보는 map을 돌며 방문하지 않은 지점에서 dfs. dfs가 끝나면 cnt++
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!trueVisited[i][j]) {
                    dfs(n, trueMap, trueVisited, trueMap[i][j], i, j);
                    tureCnt++;
                }
            }
        }

        System.out.println(falseCnt + " " + tureCnt);
    }

    //map: 그림이 저장되어 있는 map, visited: 방문 배열, color: 이웃한 색과 같은지 비교할 현재 자리의 색
    static void dfs(int n, char[][] map, boolean[][] visited, char color, int row, int col) {
        visited[row][col] = true; // 방문 표시

        // 상하좌우 순으로 이동
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];

            if (isRange(n, r, c) && !visited[r][c] && map[r][c] == color) { // 범위 내, 미방문, 이웃한 자리가 색이 같음
                dfs(n, map, visited, color, r, c);
            }
        }
    }

    static boolean isRange(int n, int row, int col) { // 범위 확인
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
