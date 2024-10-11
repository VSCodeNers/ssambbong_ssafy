// 1204.최빈수 구하기
import java.util.Scanner;

class swea1204 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] choibinsoCheck = new int[101];
            int score = 0;

            for (int j = 0; j < 1000; j++) {
                score = sc.nextInt();
                choibinsoCheck[score]++;
            }

            int max = 0, choibinso = 0;

            for (int j = 0; j < 100; j++) {
                if (max <= choibinsoCheck[j]) {
                    max = choibinsoCheck[j];
                    choibinso = j;
                }
            }

            System.out.println("#" + (i + 1) + " " + choibinso);   
        }

        sc.close();
    }
}