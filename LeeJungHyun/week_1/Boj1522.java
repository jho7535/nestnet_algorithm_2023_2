package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1522 {

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str=br.readLine();

        int a_cnt=0;
        int ret=Integer.MAX_VALUE;
        int len=str.length();

        for(int i=0;i<len;i++) {
            if(str.charAt(i)=='a')
                a_cnt++;
        }

        for(int i=0;i<len;i++) {
            int b_cnt=0;
            for(int j=i;j<i+a_cnt;j++) {
                if(str.charAt(j%len)!='a'){
                    b_cnt++;
                }
            }
            ret=Math.min(b_cnt,ret);
        }


        System.out.println(ret);
    }
}