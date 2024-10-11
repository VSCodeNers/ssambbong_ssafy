// 1주차 - 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
package jung0115.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class SWEA_1204 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int test_case = 1; test_case <= T; test_case++) {
      br.readLine();
      StringTokenizer st = new StringTokenizer(br.readLine());

      Map<Integer, Integer> scoreMap = new HashMap<>();

      while (st.hasMoreTokens()) {
        int score = Integer.parseInt(st.nextToken());
        scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
      }

      int answer = 0;
      int max = 0;

      for (int key : scoreMap.keySet() ) {
        int count = scoreMap.get(key);
        
        // count가 더 크거나,
        // count가 같고 점수가 큰 경우
        if(max < count || (max == count && answer < key)) {
          max = count;
          answer = key;
        }
      }

      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}