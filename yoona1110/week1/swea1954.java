// 1954.달팽이 숫자
import java.util.Scanner;

class swea1954 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int num = 1;                                                // 1부터 시작
            int dir = 0;                                                // 방향 전환 용도..
            int[][] snail = new int[N][N];      

            int row = 0, col = 0;                                    
            int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };           // 동서남북 방향
            
            while (num <= N * N) {
                snail[row][col] = num++;
                int nrow = row + dx[dir];
                int ncol = col + dy[dir];

                // 범위를 벗어나거나, 이미 숫자가 있는 경우 제외
                if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= N || snail[nrow][ncol] != 0) {   
                    dir = (dir + 1) % 4;
                    nrow = row + dx[dir];
                    ncol = col + dy[dir];
                }
                row = nrow;
                col = ncol;
                // num++;
            }
            
            System.out.println("#" + (i + 1));
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(snail[j][k] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}