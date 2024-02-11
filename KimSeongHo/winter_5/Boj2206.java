package nestnet_algorithm_2023_2.KimSeongHo.winter_5;

import java.util.Scanner;

// 0 -> 이동 가능 1 -> 벽   최단경로로 이동(시작, 끝 포함) 벽 한개 부숴도 됨
// 다익스트라 DFS로 해결. 근데 이제 벽을 부수는 경우까지 고려
public class Boj2206 {
//public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static void DFS(int[][] arr, int[][] dp, boolean[][] check, boolean canCrash, int currX, int currY){

        for(int i = 0; i < 4; i++){
            int nextX = currX + dirX[i];
            int nextY = currY + dirY[i];

            if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

            // 갈 수 있고 더 최단거리일 때
            if(!check[nextY][nextX] && (arr[nextY][nextX] == 0 && dp[currY][currX] + 1 < dp[nextY][nextX])){
                dp[nextY][nextX] = dp[currY][currX] + 1;
                check[nextY][nextX] = true;
                DFS(arr, dp, check, canCrash, nextX, nextY);
                check[nextY][nextX] = false;
            }
            if(!check[nextY][nextX] && ((arr[nextY][nextX] == 1 && canCrash) && dp[currY][currX] + 1 < dp[nextY][nextX])){
                dp[nextY][nextX] = dp[currY][currX] + 1;
                canCrash = false;
                check[nextY][nextX] = true;
                DFS(arr, dp, check, canCrash, nextX, nextY);
                canCrash = true;
                check[nextY][nextX] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row  = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            String oneRow = scanner.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = oneRow.charAt(j) - 48;
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        boolean[][] check = new boolean[row][col];
        check[0][0] = true;
        boolean canCrash = true;
        dp[0][0] = 1;

        DFS(arr, dp, check, canCrash, 0, 0);

//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(dp[row - 1][col - 1] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[row - 1][col - 1]);

    }
}
