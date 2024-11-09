// 4주차 - 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
package jung0115.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1244 {
  static char[] numbers;
  static int answer;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String number = st.nextToken();
      int chance = Integer.parseInt(st.nextToken());

      numbers = new char[number.length()];
      answer = 0;

      for(int i = 0; i < number.length(); i++) {
        numbers[i] = number.charAt(i);
      }

      if(chance > number.length()) {
        chance = number.length();
      }

      dfs(chance, 0, 0);
      
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }

  static void dfs(int chance, int current, int count) {
    if(chance == count) {
      StringBuilder num = new StringBuilder();
      for(int i = 0; i < numbers.length; i++) {
        num.append(numbers[i]);
      }
      answer = Math.max(answer, Integer.parseInt(num.toString()));
      return;
    }

    for(int i = current; i < numbers.length; i++) {
      for(int j = i + 1; j < numbers.length; j++) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        dfs(chance, i, count + 1);

        temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
      }
    }
  }
}