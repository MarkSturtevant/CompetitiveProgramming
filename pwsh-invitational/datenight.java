import java.io.*;
import java.util.*;

public class datenight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        double mul = 1;
        for (int i = 0; i < 10; ++i) {
            double next = scanner.nextInt();
            sum += next;
            mul *= next;
        }
        System.out.printf("%.5f", mul / sum);
    }
}