import java.io.IOException;
import java.util.Scanner;

class swea1206 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = 10;         // testcase 10개

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] building = new int[N];

            // 건물 높이 입력받음
            for (int j = 0; j < N; j++) {
                building[j] = sc.nextInt();
            }
            
            int house = 0;

            for (int j = 2; j < N - 2; j++) {
                int max = 0; 
                // 양 옆 건물 높이 비교해서 제일 높은 건물 높이 구함
                max = Math.max(building[j - 2], building[j - 1]);
                max = Math.max(max, building[j + 1]);
                max = Math.max(max, building[j + 2]);

                // 현재 건물 > max면 조망권 확보된 것이므로
                if (building[j] > max) {
                    house += building[j] - max;
                }
            }
            System.out.println("#" + (i + 1) + " " + house);
        }
        sc.close();
    }
}