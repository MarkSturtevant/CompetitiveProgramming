import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class anh {

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[][] dp = new long[N][1];
        for (int i = N - 1; i >= 0; --i) {
            long value = Integer.parseInt(input[i]);
            int M = (int) Math.ceil(0.5 * (Math.sqrt(9 + 8 * i)));
            dp[i] = new long[M + 2];
            for (int j = 2; j < M + 2; ++j) {
                if (i + j < N) {
                    if (dp[i + j].length > j + 1)
                        dp[i][j] = value + Math.max(dp[i + j][j], dp[i + j][j + 1]);
                    else dp[i][j] = value + dp[i + j][j];
                } else dp[i][j] = value;
            }
        }
        System.out.println(Math.max(dp[0][2], dp[0][3]));
    }

}
