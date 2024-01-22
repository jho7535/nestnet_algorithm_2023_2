package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2304 {

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        ArrayList<Rect>array=new ArrayList<Rect>();

        int x,h;

        for(int i=0;i<N;i++){

            StringTokenizer st=new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());

            h=Integer.parseInt(st.nextToken());

            array.add(new Rect(x,h));
        }


        Collections.sort(array,(o1,o2)->o1.x-o2.x);


        Rect Max_R=find_Max(array);

        int ret=Left_Side(array,Max_R)+Right_Side(array,Max_R)+Max_R.h;

        System.out.println(ret);

    }



    public static class Rect{

        int x,h;

        public Rect(int x,int h) {
            this.x=x;
            this.h=h;
        }
    }

    public static Rect find_Max(ArrayList<Rect>array) {
        Rect max_R=array.get(0);

        for(Rect rect:array) {
            if(rect.h>max_R.h) {
                max_R=rect;
            }
        }
        return max_R;
    }

    public static int Left_Side(ArrayList<Rect>array,Rect Max_R) {

        int left_area=0;
        int height=array.get(0).h;

        for (int i = 0; i < array.indexOf(Max_R); i++) {
            Rect currentRect = array.get(i);
            Rect nextRect=array.get(i+1);

            left_area+=(nextRect.x-currentRect.x)*height;

            if(currentRect.h<nextRect.h)
                height=nextRect.h;
        }
        return left_area;
    }

    public static int Right_Side(ArrayList<Rect>array,Rect Max_R) {

        int right_area=0;
        int height=array.get(array.size()-1).h;


        for (int i = array.size()-1; i > array.indexOf(Max_R); i--) {
            Rect currentRect = array.get(i);
            Rect prevRect=array.get(i-1);

            right_area+=(currentRect.x-prevRect.x)*height;

            if(currentRect.h<prevRect.h)
                height=prevRect.h;
        }
        return right_area;
    }

}