package nestnet_algorithm_2023_2.JeongHanUl.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class boj_20115 {
//public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> list = new ArrayList<>();
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
        double temp;

        for (int i = 0; i < n - 1; i++) {
            temp = list.get(0) / 2 + list.get(list.size() - 1);
            list.remove(0);
            list.remove(list.size() - 1);
            list.add(temp);
        }
        System.out.println(list.get(0));
    }
}