package nestnet_algorithm_2023_2.JeongHanUl.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxFloor = Integer.parseInt(st.nextToken());
        int currentFloor = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[maxFloor + 1];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentFloor);
        int[] cnt = new int[maxFloor + 1];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) continue;
            visited[current] = true;

            if (current == target) break;

            if (current + up <= maxFloor && !visited[current + up]) {
                queue.add(current + up);
                cnt[current + up] = cnt[current] + 1;
            }
            if (current - down >= 1 && !visited[current - down]) {
                queue.add(current - down);
                cnt[current - down] = cnt[current] + 1;
            }
        }

        if (currentFloor == target) {
            System.out.println(cnt[target]);
        } else if (cnt[target] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(cnt[target]);
        }
    }
}
