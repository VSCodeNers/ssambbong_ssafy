import java.io.IOException;
import java.util.Scanner;

class swea2001 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] paris = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    paris[j][k] = sc.nextInt();
                }
            }

            int max = 0;

            for (int j = 0; j <= N - M; j++) {
                for (int k = 0; k <= N - M; k++) {
                    int sum = 0;

                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += paris[j + x][k + y];
                        }
                    }

                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
        sc.close();
    }
}