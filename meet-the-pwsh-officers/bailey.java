import java.io.*;

public class bailey {

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]), M = Integer.parseInt(input1[1]);

        if (M == 0) {
            System.out.println("1.00000");
            return;
        }

        int[] interval = new int[1440];
        int[] values = new int[1440];
        long[] runningSum = new long[1440];
        long[][] dp = new long[1440][M];

        for (int i = 0; i < N; ++i) {
            String[] input2 = br.readLine().split(" ");
            int S = Integer.parseInt(input2[0]), E = Integer.parseInt(input2[1]);
            interval[S]++;
            if (E < 1399)
                interval[E + 1]--;
        }

        int counter = 0;
        for (int i = 0; i < 1440; ++i) {
            counter += interval[i];
            values[i] = counter;
        }

        runningSum[1399] = values[1399];
        for (int i = 1398; i >= 0; --i) {
            runningSum[i] = runningSum[i + 1] + values[i];

            if (i < 1400 - 60)
                dp[i][0] = Math.max(runningSum[i] - runningSum[i + 60], dp[i + 1][0]);
            for (int j = 1; j < M; ++j) {
                if (i >= 1400 - (j + 1) * 60)
                    break;
                dp[i][j] = Math.max(runningSum[i] - runningSum[i + 60] + dp[i + 60][j - 1], dp[i + 1][j]);
            }
        }

        System.out.printf("%.5f\n", 1 - (1.0 * dp[0][M - 1] / runningSum[0]));


    }

}
