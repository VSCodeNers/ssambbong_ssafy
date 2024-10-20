// 2주차 - 1859. 백만 장자 프로젝트
package jung0115.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      int N = Integer.parseInt(br.readLine());

      int[] cost = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        cost[i] = Integer.parseInt(st.nextToken());
      }
      
      long answer = 0L;
      int max = cost[N - 1];

      for(int i = N - 2; i >= 0; i--) {
        if(cost[i] > max) {
          max = cost[i];
        }
        else {
          answer += (max - cost[i]);
        }
      }

      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}
