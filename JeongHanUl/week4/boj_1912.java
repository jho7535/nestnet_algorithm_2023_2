package nestnet_algorithm_2023_2.JeongHanUl.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {
    //public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        max = arr[0];

        for (int i = 1; i < n; i++) { // 배열의 값과 누적합의 값을 비교하여 택1
            if (arr[i - 1] + arr[i] > arr[i]) {
                arr[i] += arr[i - 1];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
