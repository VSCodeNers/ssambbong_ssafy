// 2주차 - 1206. [S/W 문제해결 기본] 1일차 - View
package jung0115.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1206 {
  static int[] dx = { -2, -1, 1, 2 };
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    for(int test_case = 1; test_case <= 10; test_case++) {
      int N = Integer.parseInt(br.readLine());

      int[] buildings = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int i = 0; i < N; i++) {
        buildings[i] = Integer.parseInt(st.nextToken());
      }

      int answer = 0;
      for(int i = 2; i < N - 2; i++) {
        int view = buildings[i];

        for(int j = 0; j < 4; j++) {
          int moveIdx = i + dx[j];
          if(buildings[i] <= buildings[moveIdx]) {
            view = 0;
            break;
          }
          
          int v = buildings[i] - buildings[moveIdx];
          if(v < view) view = v;
        }

        answer += view;
      }
      
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}
