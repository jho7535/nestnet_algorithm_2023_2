package nestnet_algorithm_2023_2.JeongHanUl.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20365 {
//public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char prev = str.charAt(0);
        int[] color = { 0, 0 };
        int colIndex = 0;
        for (int i = 1; i < n; i++) {
            if (prev != str.charAt(i)) {
                color[colIndex]++;
                colIndex = switchColor(colIndex);
            }

            prev = str.charAt(i);
        }
        color[colIndex]++;

        System.out.println(color[0] > color[1] ? (1 + color[1]) : (1 + color[0]));
    }

    static int switchColor(int current) {
        if (current == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}