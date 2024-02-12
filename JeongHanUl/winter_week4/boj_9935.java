package nestnet_algorithm_2023_2.JeongHanUl.winter_week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9935 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        int strLen = str.length();
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < strLen; i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombLen) {
                boolean flag = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

//        if (stack.isEmpty()) {
//            System.out.println("FRULA");
//        } else {
//            for (int i = 0; i < stack.size(); i++) {
//                System.out.print(stack.get(i));
//            }
//        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack)
            sb.append(ch);

        System.out.println(!sb.isEmpty() ? sb.toString() : "FRULA");
    }
}
