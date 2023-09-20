package nestnet_algorithm_2023_2.JeongHanUl.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16953 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        int a, b, cnt = 1; // a, b, 연산 횟수 카운트
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());

        // b에 연산을 통해 a로 만들 수 있는지 여부를 확인
        while (b > a) {
            if (b % 2 == 0) { // b가 2로 나누어 떨어짐
                b /= 2;
                cnt++;
            } else if (b % 10 == 1) { // b의 1의 자리가 1
                b /= 10;
                cnt++;
            } else { // 불가능 판단
                cnt = -1;
                break;
            }
        }

        if (b < a) { // while 문의 조건식을 통해 탈출한 경우
            cnt = -1;
        }

        System.out.println(cnt);
    }
}
