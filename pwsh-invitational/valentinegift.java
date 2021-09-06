import java.io.*;
import java.util.*;

public class valentinegift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int numGifts = 0;

        numGifts = N;
        numGifts = Math.min(numGifts, B / 2);
        numGifts = Math.min(numGifts, C / 4);

        System.out.println(numGifts);
    }
}