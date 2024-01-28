package nestnet_algorithm_2023_2.JeongHanUl.week8;

import java.util.Scanner;

public class boj_2193 {
    //public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] dp = new long[n + 1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        System.out.println(dp[n]);
    }
}
