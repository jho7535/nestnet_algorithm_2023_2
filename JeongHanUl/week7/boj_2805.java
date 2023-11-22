package nestnet_algorithm_2023_2.JeongHanUl.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2805 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무 개수
        int m = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>(); // 나무 높이 저장할 리스트
        for (int i = 0; i < n; i++)
            arrayList.add(Integer.parseInt(st.nextToken()));
        arrayList.sort(Comparator.reverseOrder()); // 리스트 내림차순 정렬

        int result = binarySearch(0, arrayList.get(0), m, arrayList, n); // 이분 탐색.
        System.out.println(result);
    }

    /*
    이분 탐색. 0과 입력 받은 나무의 최댓값 사이에서 구하고자 하는 h의 최댓값을 찾음.
    mid 값보다 큰 나무들을 자른 합을 sum에 저장. target(m)보다 sum이 크면 mid 값을 올릴 수 있음. 반대의 경우 mid 값을 내려야함.
    target이 sum과 같으면 바로 mid 값 return.
    target이 sum과 같은 경우가 없어 종료되어도 결국 mid 값이 구하는 값임. mid 값 return.
     */
    public static int binarySearch(int low, int high, int target, ArrayList<Integer> list, int n) {
        int mid = (low + high) / 2;

        while (mid >= low && mid <= high) {
            int i = 0;
            long sum = 0; // 나무 길이의 최댓값은 20억. 자르고 남은 길이의 합을 구하는 과정에서 overflow가 발생할 수 있기 때문에 long

            while (i < n && list.get(i) > mid) // 나무의 높이가 mid보다 클 동안
                sum += list.get(i++) - mid;

            if (sum > target) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else if (sum < target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else
                return mid;
        }

        return mid;
    }
}
