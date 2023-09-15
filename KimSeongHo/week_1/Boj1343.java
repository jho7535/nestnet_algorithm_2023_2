package nestnet_algorithm_2023_2.KimSeongHo.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1343 {
    //public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String input = bufferedReader.readLine();       //입력

        int curr = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '.'){
                if(curr == 2){
                    stringBuilder.append("BB");
                    curr = 0;
                }
                else if(curr % 2 == 1){
                    stringBuilder.setLength(0);
                    stringBuilder.append("-1");
                    break;
                }
                stringBuilder.append(".");
            }
            else{
                curr++;
                if(curr == 4){
                    stringBuilder.append("AAAA");
                    curr = 0;
                }
            }
        }

        if(curr == 2){
            stringBuilder.append("BB");
        }
        else if(curr != 0){
            stringBuilder.setLength(0);
            stringBuilder.append("-1");
        }

        System.out.println(stringBuilder.toString());
    }
}
