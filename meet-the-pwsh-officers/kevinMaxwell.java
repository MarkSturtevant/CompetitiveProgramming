import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kevinMaxwell {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            double B = Double.parseDouble(br.readLine()) - 0.00005; // adj for rounding.
            double min = 1, max = 3.141, mid = -1;
            while (max - min > 0.000004) {
                mid = (min + max) / 2.0;
                double eval = evaluate(mid);
                if (eval < B)
                    min = mid;
                else max = mid;
            }
            System.out.printf("%.4f\n", (min + max) / 2);
        }
    }

    public static double evaluate(double A) {
        int NUM_DIV = (int) Math.round((A - 1) * 4000.0);
        double dx = (A - 1) / NUM_DIV;
        double sum = 0;
        for (int i = 0; i < NUM_DIV; ++i) {
            double x = 1 + dx * (i + 0.5); // center riemann sum approximation
            sum += dx * Math.atan(x) * Math.log10(x) / Math.sqrt(Math.sin(x)) / x / x;
        }
        return sum;
    }

}
