// 4주차 - 1244. [S/W 문제해결 응용] 2일차 - 최대 상금 - 실패
package jung0115.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1244_fail {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String number = st.nextToken();
      int count = Integer.parseInt(st.nextToken());

      char[] numbers = new char[number.length()];

      int index = 0;

      for(int i = 0; i < number.length(); i++) {
        numbers[i] = number.charAt(i);
      }

      while (count > 0 && index < number.length()) {
        
        int maxIndex = index;
        for(int i = index + 1; i < number.length(); i++) {
          if(numbers[i] >= numbers[maxIndex]) {
            maxIndex = i; 
          }
        }

        // 최대값이 이미 해당 인덱스에 위치할 경우
        if(maxIndex == index) {
          index++;
          continue;
        }

        char temp = numbers[index];
        numbers[index] = numbers[maxIndex];
        numbers[maxIndex] = temp;

        System.out.println(numbers);

        index++;
        count--;
      }

      if(count > 0) {
        int change1 = number.length() - 1;
        int change2 = number.length() - 2;

        for(int i = 0; i < number.length(); i++) {
          for(int j = i + 1; j < number.length(); j++) {
            if(numbers[i] == numbers[j]) {
              change1 = i;
              change2 = j;
              break;
            }
          }
        }

        while (count > 0) {
          char temp = numbers[change1];
          numbers[change1] = numbers[change2];
          numbers[change2] = temp;

          System.out.print("test: ");
          System.out.println(numbers);

          count--;
        }
      }

      StringBuilder answer = new StringBuilder();
      for(int i = 0; i < number.length(); i++) {
        answer.append(numbers[i]);
      }
      
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
    }

    br.close();
    System.out.print(printSet);
  }
}