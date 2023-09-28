package nestnet_algorithm_2023_2.JeongHanUl.week2;

import java.util.Scanner;

public class boj_14916 {
    //public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0; // cnt: 총 동전 카운트

        while (n > 0) {
            if (n - 8 == 0) {
                cnt += 4;
                n -= 8;
            } else if (n - 6 == 0) {
                cnt += 3;
                n -= 6;
            } else if (n - 4 == 0) {
                cnt += 2;
                n -= 4;
            } else if (n - 2 == 0) {
                cnt++;
                n -= 2;
            } else {
                cnt++;
                n -= 5;
            }
        }
        System.out.println(n == 0 ? cnt : -1);
    }
}
