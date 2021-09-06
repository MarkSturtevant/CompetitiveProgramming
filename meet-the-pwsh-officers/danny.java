import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class danny {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine(); // this solution does not use N

        String[] input = br.readLine().split(" ");
        BigInteger max = BigInteger.ZERO;
        for (String next : input) {
            BigInteger temp = new BigInteger(next);
            if (temp.compareTo(max) > 0)
                max = temp;
        }

        System.out.println((int) Math.ceil(max.bitLength() / 8.0));
    }

}
