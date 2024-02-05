package nestnet_algorithm_2023_2.JeongHanUl.winter_week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_2668 {
    //public class Main {
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(arr, visited, i, arr[i]);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int[] arr, boolean[] visited, int start, int index) {
        if (!visited[index]) {
            visited[index] = true;
            dfs(arr, visited, start, arr[index]);
            visited[index] = false;
        }

        if (start == index) answer.add(start);
    }
}
