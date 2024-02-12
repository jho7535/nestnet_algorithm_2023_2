package nestnet_algorithm_2023_2.JeongHanUl.winter_week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중

        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Truck> bridge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 1;
        int weight = 0;
        int ptr = 0;

        int current = queue.poll();
        weight += current;
        bridge.add(new Truck(current, w));

        while (!queue.isEmpty() || weight != 0) {
            cnt++;

            for (int i = ptr; i < bridge.size(); i++) {
                bridge.get(i).distance--;
            }

            if (bridge.get(ptr).distance == 0) {
                weight -= bridge.get(ptr).weight;
                ptr++;
            }

            if (!queue.isEmpty() && weight + queue.peek() <= l) {
                current = queue.poll();
                weight += current;
                bridge.add(new Truck(current, w));
            }
        }

        System.out.println(cnt);
    }
}

class Truck {
    public int weight;
    public int distance;

    public Truck(int w, int d) {
        this.weight = w;
        this.distance = d;
    }
}