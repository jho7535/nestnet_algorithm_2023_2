package nestnet_algorithm_2023_2.JeongHanUl.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {
    //public class Main {
    static int max = 0; // 최대 칸 수를 저장
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //visited가 없는 이유: 같은 알파벳은 못 지나가기 때문에 alphabet 배열에 이미 포함되어 있음
        boolean[] alphabet = new boolean[26]; // 알파벳 사용을 표시. [0]: A, [1]: B...

        dfs(r, c, map, alphabet, 0, 0, 1);

        System.out.println(max);
    }

    // cnt: 지나간 칸 수. max와 매번 대소비교
    static void dfs(int r, int c, char[][] m, boolean[] a, int row, int col, int cnt) {
        if (cnt > max) { // 지나갈 수 있는 최대의 칸 수를 저장해야 함. max보다 클 때마다 저장
            max = cnt;
        }

        int alphaIndex = m[row][col] - 'A'; // 0번지가 'A'를 나타냄. 문자에서 'A'를 빼주면 아스키 코드로 접근 가능
        a[alphaIndex] = true; // 알파벳 방문 표시

        // 상하좌우 순으로 이동
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (isRange(r, c, nr, nc)) { // 범위 확인
                alphaIndex = m[nr][nc] - 'A';
                if (!a[alphaIndex]) { // 미방문한 알파벳이면
                    dfs(r, c, m, a, nr, nc, cnt + 1);
                    a[alphaIndex] = false;
                }
            }
        }
    }

    static boolean isRange(int r, int c, int row, int col) { // 범위 확인
        return row >= 0 && row < r && col >= 0 && col < c;
    }
}
