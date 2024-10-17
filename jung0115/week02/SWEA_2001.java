// 2주차 - 2001. 파리 퇴치
package jung0115.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_2001 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int C = N - M + 1;
      int[][] sum = new int[C][C];

      for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
          int fly = Integer.parseInt(st.nextToken());

          for(int mi = i - M + 1; mi <= i; mi++) {
            for(int mj = j - M + 1; mj <= j; mj++) {
              if(mi < 0 || mj < 0 || mi >= C || mj >= C) continue;

              sum[mi][mj] += fly;
            }
          }
        }
      }

      int answer = 0;

      for(int i = 0; i < C; i++) {
        for(int j = 0; j < C; j++) {
          if(answer < sum[i][j])
            answer = sum[i][j];
        }
      }

      
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}
