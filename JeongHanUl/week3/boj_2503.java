package nestnet_algorithm_2023_2.JeongHanUl.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2503 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] num = new boolean[1000]; // 가능성 있는 답에 false

        for (int i = 0; i < 100; i++) { // 3자리 이하 숫자들 true
            num[i] = true;
        }

        for (int index = 100; index < 1000; index++) { // 1~9 중 2번 이상 사용된 숫자들 true, 0이 들어가는 숫자들 true
            int temp = index;
            boolean flag = true;
            boolean[] arr = new boolean[10]; // 0~9까지 한 번 이상 사용되면 true

            for (int i = 0; i < 3; i++) {
                if (arr[temp % 10] || temp % 10 == 0) { // 이미 한 번 사용됨 or 0이 포함됨
                    flag = false;
                    break;
                }
                arr[temp % 10] = true; // 사용됨
                temp /= 10;
            }

            if (!flag) {
                num[index] = true;
            }
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        while (N-- != 0) {
            int target, strike, ball;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            target = Integer.parseInt(stringTokenizer.nextToken());
            strike = Integer.parseInt(stringTokenizer.nextToken());
            ball = Integer.parseInt(stringTokenizer.nextToken());;

            for (int index = 100; index < 1000; index++) { // 모든 숫자들을 입력받은 숫자와 비교하여 스트라이크, 볼 여부 체크
                int strikeNum = 0, ballNum = 0; // 카운트해서 비교할 변수
                int tagertNum = target;
                int temp = index;

                for (int i = 0; i < 3; i++) { // 스트라이크 여부 체크
                    if (tagertNum % 10 == temp % 10) { // 각 자리수 비교
                        strikeNum++;
                    }
                    tagertNum /= 10;
                    temp /= 10;
                }

                tagertNum = target;
                for (int i = 0; i < 3; i++) { // 볼 여부 체크
                    String targetStr = String.valueOf(tagertNum % 10);
                    String str = String.valueOf(index);
                    if (str.contains(targetStr)) {
                        ballNum++;
                    }
                    tagertNum /= 10;
                }

                ballNum -= strikeNum; // 볼에 스트라이크도 포함되어 있기 때문에 빼주기

                if(strike != strikeNum || ball != ballNum) { // 스트라이크 or 볼 중 하나라도 다르면 불가능
                    num[index] = true;
                }
            }
        }

        int cnt = 0;
        for (int index = 100; index < 1000; index++) { // 가능성 있는 답 카운트
            if(!num[index]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
