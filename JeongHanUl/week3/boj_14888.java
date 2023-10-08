package nestnet_algorithm_2023_2.JeongHanUl.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    //public class Main {
    static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] num; // n개의 숫자
    static int[] operatorNum; // 연산자 개수. + - * / 순
    static int[] operator; // 대입된 연산자. 0 == +...

    public static void dfs(int level) {
        if (level == n - 1) { // 재귀 종료 조건
            int result = num[0];
            for (int i = 0; i < n - 1; i++) {
                switch (operator[i]) {
                    case 0: // +
                        result += num[i + 1];
                        break;
                    case 1: // -
                        result -= num[i + 1];
                        break;
                    case 2: // *
                        result *= num[i + 1];
                        break;
                    case 3: // /
                        result /= num[i + 1];
                        break;
                }
            }

            if (result < min) { // 최소값 바꾸기
                min = result;
            }
            if (result > max) { // 최대값 바꾸기
                max = result;
            }
            return;
        }

        for (int j = 0; j < 4; j++) { // 남아 있는 연산자 체크
            if (operatorNum[j] > 0) { // 연산자 개수가 남아 있는 경우
                operator[level] = j;
                operatorNum[j]--;
                dfs(level + 1);
                operatorNum[j]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력값 받아서 대입
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        num = new int[n];
        operatorNum = new int[4];
        operator = new int[n - 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operatorNum[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }
}
