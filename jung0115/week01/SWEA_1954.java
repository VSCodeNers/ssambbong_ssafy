// 1주차 - 1954. 달팽이 숫자
package jung0115.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SWEA_1954 {
  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, 1, 0, -1 };
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int test_case = 1; test_case <= T; test_case++) {
      int N = Integer.parseInt(br.readLine());

      int[][] map = new int[N][N];
      int x = 0;
      int y = 0;
      int num = 1;
      int dir = 0;

      while (num <= N*N) {
        map[y][x] = num;

        if(num == N*N) break;

        int moveX = x + dx[dir];
        int moveY = y + dy[dir];

        // 범위를 벗어나거나 이미 숫자가 채워짐
        if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N || map[moveY][moveX] > 0) {
          dir = (dir + 1) % 4;
          continue;
        }
        x = moveX;
        y = moveY;
        
        num++;
      }

      printSet.append("#").append(test_case).append("\n");
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          printSet.append(map[i][j]).append(" ");
        }
        printSet.append("\n");
      }
    }

    br.close();
    System.out.print(printSet);
  }
}