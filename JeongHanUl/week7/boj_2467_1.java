package nestnet_algorithm_2023_2.JeongHanUl.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2467_1 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> negativeNums = new ArrayList<>(); // 음수 값 배열
        ArrayList<Integer> positiveNums = new ArrayList<>(); // 양수 값 배열. 0 포함

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (input < 0)
                negativeNums.add(input);
            else
                positiveNums.add(input);
        }

        int negativeMinIndex = 0, positiveMinIndex = 0;
        /*
        3가지 케이스로 분류.
        1) 산성, 알칼리성 용액이 둘 다 있음. 이분 탐색
        2) 산성만 있음
        3) 알칼리성만 있음
         */
        if (!negativeNums.isEmpty() && !positiveNums.isEmpty()) { // 둘 다 있음
            for (int i = 0; i < negativeNums.size(); i++) {
                int index = binarySearch(0, positiveNums.size() - 1, -negativeNums.get(i), positiveNums);

                // 합이 0이 되면 출력 후 종료
                if (negativeNums.get(i) + positiveNums.get(index) == 0) {
                    System.out.println(negativeNums.get(i) + " " + positiveNums.get(index));
                    break;
                }

                // 합이 0에 가까운 index를 기억
                if (Math.abs(negativeNums.get(i) + positiveNums.get(index)) <
                        Math.abs(negativeNums.get(negativeMinIndex) + positiveNums.get(positiveMinIndex))) {
                    negativeMinIndex = i;
                    positiveMinIndex = index;
                }
            }

            // 합이 0에 가까운 값 출력
            System.out.println(negativeNums.get(negativeMinIndex) + " " + positiveNums.get(positiveMinIndex));
        } else if (negativeNums.isEmpty()) { // 산성만
            System.out.println(positiveNums.get(0) + " " + positiveNums.get(1));
        } else // 알칼리성만
            System.out.println(negativeNums.get(negativeNums.size() - 2) + " " + negativeNums.get(negativeNums.size() - 1));
    }


    public static int binarySearch(int start, int end, int target, ArrayList<Integer> numbers) {
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (numbers.get(mid) < target)
                start = mid + 1;
            else if (numbers.get(mid) > target)
                end = mid - 1;
            else
                return mid;
        }

        // 합이 0에 가까운 index return
        if (numbers.size() >= 3) {
//            if (Math.abs(numbers.get(start) - target) < Math.abs(numbers.get(end) - target))
//                return start;
//            else
//                return end;
            return mid;
        } else if (numbers.size() == 2) {
            if (Math.abs(numbers.get(1) - target) < Math.abs(numbers.get(0) - target))
                return 1;
            else
                return 0;
        } else
            return mid;
    }
}
