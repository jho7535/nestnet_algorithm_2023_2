package nestnet_algorithm_2023_2.JeongHanUl.winter_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19637 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Title[] arr = new Title[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            arr[i] = new Title(name, power);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(br.readLine());

            int low = 0;
            int high = n - 1;
            int mid = 0;
            while (low <= high) {
                 mid = (low + high) / 2;

                if (input <= arr[mid].power) high = mid - 1;
                else low = mid + 1;
            }

            mid = (low + high + 1) / 2;
            sb.append(arr[mid].name).append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Title {
    public String name;
    public int power;

    Title(String name, int power) {
        this.name = name;
        this.power = power;
    }
}