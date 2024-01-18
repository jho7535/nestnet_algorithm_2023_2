package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {

    private static int N,M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[][] distance;

    public static void main(String[] args) throws IOException {


        map = new int[N][M];

        distance = new int[N][M];

        visit = new boolean[N][M];

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        // 지도의 크기
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        distance=new int[N][M];

        visit=new boolean[N][M];


        int x=0,y=0;
        for(int i=0; i<N; i++) {
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    x=i;
                    y=j;
                    visit[i][j]=true;
                }else if(map[i][j]==0)
                    visit[i][j]=true;
            }
        }


        bfs(x,y);


        for (int i = 0; i < N; ++i) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j])
                    distance[i][j]=-1;
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void bfs(int startX,int startY) {

        Queue<Points>q=new LinkedList<>();

        int[] dx= {1,0,0,-1};
        int[] dy= {0,-1,1,0};


        q.add(new Points(startX,startY));

        while(!q.isEmpty()) {


            Points current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < N && nextY < M && nextX >= 0 && nextY >= 0)
                    if (!visit[nextX][nextY]) {
                        distance[nextX][nextY] = distance[current.x][current.y] + 1;
                        q.add(new Points(nextX, nextY));
                        visit[nextX][nextY] = true;
                    }
            }
        }
    }

    public static class Points{

        public int x,y;

        Points(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

}