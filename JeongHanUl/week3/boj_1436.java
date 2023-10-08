package nestnet_algorithm_2023_2.JeongHanUl.week3;

import java.util.Scanner;

public class boj_1436 {
    //public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int nCnt = 0, num = 665; // n번째 카운트, num++ 통해 666 체크

        while (nCnt != N) {
            int sCnt = 0, i = 1; // 연속된 6 카운트
            num++;
            String strNum = String.valueOf(num);

            for (int j = 0; j < strNum.length(); j++) {
                if (num / i % 10 == 6) {
                    sCnt++;
                } else {
                    sCnt = 0;
                }

                if (sCnt >= 3) { // 6이 3번 연속으로 나옴
                    nCnt++;
                    break;
                } else {
                    i *= 10;
                }
            }
        }

        System.out.println(num);
    }
}
