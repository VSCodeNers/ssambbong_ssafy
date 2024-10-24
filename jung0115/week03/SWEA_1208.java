// 3주차 - 1208. [S/W 문제해결 기본] 1일차 - Flatten
package jung0115.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SWEA_1208 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    for(int test_case = 1; test_case <= 10; test_case++) {
      int dump = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] boxes = new int[100];
      for(int i = 0; i < 100; i++) {
        boxes[i] = Integer.parseInt(st.nextToken());
      }

      while(dump > 0) {
        Arrays.sort(boxes);

        boxes[0]++;
        boxes[99]--;

        dump--;
      }

      Arrays.sort(boxes);
      
      int answer =boxes[99] - boxes[0];
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}
