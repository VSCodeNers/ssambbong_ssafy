// 4주차 - 5215. 햄버거 다이어트
package jung0115.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
  static int N, L;
  static int[][] ingredients;
  static int answer;
  static boolean[] visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken()); // 재료의 수
      L = Integer.parseInt(st.nextToken()); // 제한 칼로리

      ingredients = new int[N][2];
      for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());

        ingredients[i][0] = Integer.parseInt(st.nextToken()); // 맛에 대한 점수
        ingredients[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
      }

      answer = 0;
      visited = new boolean[N];
    
      dfs(0, 0, 0);

      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }

  static void dfs(int score, int calories, int currentIndex) {
    if(calories > L) return;
    if(answer < score) answer = score;

    for(int i = currentIndex; i < N; i++) {
      if(!visited[i]) {
        visited[i] = true;

        dfs(score + ingredients[i][0], calories + ingredients[i][1], i + 1);

        visited[i] = false;
      }
    }
  }
}
