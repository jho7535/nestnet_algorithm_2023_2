package nestnet_algorithm_2023_2.JeongHanUl.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889 {
    //public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] team; // ture 팀과 false 팀으로 나눔
    static int[][] status; // 시너지 능력치

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        team = new boolean[n];
        StringTokenizer stringTokenizer;

        status = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < n; j++) {
                status[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        combination(n / 2, 0);

        System.out.println(min);
    }

    public static void combination(int r, int startIndex) { // 조합을 통해 팀을 구성
        if (r == 0) { // 종료 조건. 팀을 다 나눔
            compareTeam();
            return;
        }

        for (int i = startIndex; i <= n - r; i++) { // n - r 번째에선 뽑아야 됨
            team[i] = true;
            combination(r - 1, i + 1);
            team[i] = false;
        }
    }
    public static void compareTeam() { // 나눈 팀을 바탕으로 팀 능력치 계산하여 비교
        int trueSum = 0, falseSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (team[i] && team[j]) {
                    trueSum += status[i][j];
                } else if (!team[i] && !team[j]) {
                    falseSum += status[i][j];
                }
            }
        }

        if (Math.abs(trueSum - falseSum) < min) {
            min = Math.abs(trueSum - falseSum);
        }
    }
}
