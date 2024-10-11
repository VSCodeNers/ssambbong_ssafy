// 1주차 - 2072. 홀수만 더하기
package jung0115.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2072 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int answer = 0;
      while (st.hasMoreTokens()) {
        int num = Integer.parseInt(st.nextToken());
        if(num % 2 == 1) answer += num;
      }

      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}
