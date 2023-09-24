package nestnet_algorithm_2023_2.JeongHanUl.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ClassTime implements Comparable<ClassTime> { // 강의 시작 시간, 종료 시간을 저장할 클래스
    public int s, t;

    ClassTime(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(ClassTime o) { // 시작, 종료 시간을 정렬 하기 위한 메소드
        if (this.s == o.s) {
            return this.t - o.t;
        } else {
            return this.s - o.s;
        }
    }
}

public class boj_11000 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<ClassTime> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            arr.add(new ClassTime(s, t));
        }

        // 종료 시간을 min heap에 넣고, 시작 시간의 최솟값들과 비교하여 같은 강의실을 사용할 수 있는지 판단
        Collections.sort(arr);
        priorityQueue.add(arr.get(0).t);
        arr.remove(0);

        for (int i = 0; i < n - 1; i++) {
            // 시작 시간의 최솟값을 min heap의 front와 비교
            if (arr.get(i).s >= priorityQueue.peek()) { // 같은 강의실 사용 가능
                priorityQueue.remove();
                priorityQueue.add(arr.get(i).t);
            } else { // 같은 강의실 사용 불가능. 별도의 강의실 필요
                priorityQueue.add(arr.get(i).t);
            }
        }

        System.out.println(priorityQueue.size()); // heap의 size == 필요한 강의실 갯수
    }
}