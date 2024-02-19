package nestnet_algorithm_2023_2.JeongHanUl.winter_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19941 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        boolean[] burger = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'H') burger[i] = true;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0) continue;
                    if (j > n - 1) continue;

                    if (burger[j]) {
                        burger[j] = false;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
