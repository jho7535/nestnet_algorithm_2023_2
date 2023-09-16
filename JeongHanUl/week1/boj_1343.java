package nestnet_algorithm_2023_2.JeongHanUl.week1;

import java.util.Scanner;

public class boj_1343 {
//public class Main {
    public static void main(String[] args) {
        b_1343 a = new b_1343();
        a.play();
        System.out.println();
    }
}

class b_1343 {
    String input;
    StringBuffer output = new StringBuffer();
    int count = 0;

    public void play() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        boolean flag = true;

        for (int i = 0; i < input.length(); i++) {
            char indexChar = input.charAt(i);

            switch (indexChar) {
                case 'X' -> count++;
                case '.' -> {
                    if (count > 0) {
                        appendWord(count);
                    }

                    if (count > 0) {
                        flag = false;
                        break;
                    }

                    if (count == 0) {
                        output.append('.');
                    }
                }
            }
        }
        if (count > 0)
            appendWord(count);

        if (count > 0 || !flag) {
            System.out.println(-1);
        } else {
            System.out.println(output);
        }

    }

    public void appendWord(int length) {
        int quotient = length / 4, remainder = length % 4;

        for (int i = 0; i < quotient; i++) {
            output.append("AAAA");
            count -= 4;
        }

        if (remainder == 2) {
            output.append("BB");
            count -= 2;
        }
    }
}