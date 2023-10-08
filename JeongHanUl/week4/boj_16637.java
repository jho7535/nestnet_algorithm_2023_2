package nestnet_algorithm_2023_2.JeongHanUl.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_16637 {
    //public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] num; // 입력 받은 정수
    static boolean[] bracket; // 괄호의 위치 표시. 괄호가 잇는 곳 true
    static char[] operator; // 입력 받은 연산자

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();

        num = new int[n / 2 + 1];
        bracket = new boolean[n / 2 + 1];
        for (int i = 0; i < n / 2 + 1; i++) {
            num[i] = Character.getNumericValue(str.charAt(i * 2));
        }

        operator = new char[n / 2];
        for (int i = 0; i < n / 2; i++) {
            operator[i] = str.charAt(i * 2 + 1);
        }

        for (int i = 0; i < n / 2 + 1; i += 2) {
            dfs(i, 0);
        }

        System.out.println(max);
    }

    public static void dfs(int bracketNum, int index) { // 남아 있는 괄호 갯수, 분배할 때 시작 index
        if (bracketNum == 0) { // 재귀 종료 조건. 괄호 분배가 끝남
            ArrayList<Integer> arrayList = new ArrayList<>(); // 괄호 내의 값을 모두 계산한 이후 값들
            boolean[] usedOperator = new boolean[n / 2]; // 사용한 연산자. 사용했으면 ture


            for (int i = 0; i < n / 2 + 1; i++) {
                if (!bracket[i]) {
                    arrayList.add(num[i]);
                } else {
                    int result = num[i++];

                    while (true) { // 괄호 내 값 계산
                        switch (operator[i - 1]) {
                            case '+':
                                result += num[i];
                                break;
                            case '-':
                                result -= num[i];
                                break;
                            case '*':
                                result *= num[i];
                                break;
                        }
                        usedOperator[i - 1] = true; // 연산자 사용 표시

                        if (bracket[i]) { // 닫는 괄호
                            arrayList.add(result);
                            break;
                        }

                        i++;
                    }
                }
            }

            int result = arrayList.get(0);
            arrayList.remove(0);
            for (int i = 0; i < n / 2; i++) { // 리스트에 남아 있는 값 전체 연산
                if (!usedOperator[i]) {
                    switch (operator[i]) {
                        case '+':
                            result += arrayList.get(0);
                            break;
                        case '-':
                            result -= arrayList.get(0);
                            break;
                        case '*':
                            result *= arrayList.get(0);
                            break;
                    }
                    arrayList.remove(0);
                    usedOperator[i] = true; // 연산자 사용 표시
                }
            }

            if (result > max) {
                max = result;
            }
            return;
        }
        if (index > n / 2 + 1) { // 종료 조건. 시작 index가 범위를 벗어남. 배열을 다 돌았지만 괄호가 남음
            return;
        }

        for (int i = index; i < n / 2; i++) { // 괄호 분배
            bracket[i] = true;
            bracket[i + 1] = true;
            dfs(bracketNum - 2, i + 2);
            bracket[i] = false;
            bracket[i + 1] = false;
        }
    }
}
