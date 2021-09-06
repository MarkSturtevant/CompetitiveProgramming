import java.io.*;
import java.util.*;

public class align {

    public static void main(String[] args) {
        char[] map = new Scanner(System.in).nextLine().toCharArray();
        int[] sums = new int[4];
        boolean[] uses = new boolean[2];
        int max = 0;
        for (int i = 0; i < map.length; ++i) {
            if (map[i] == '>') {
                if (uses[0])
                    sums[1]++;
                else sums[0]++;
                if (uses[1]) {
                    max = Math.max(sums[2] + sums[3] + 1, max);
                    sums[2] = sums[3];
                    sums[3] = 0;
                } else uses[1] = true;
            } else {
                if (uses[1])
                    sums[3]++;
                else sums[2]++;
                if (uses[0]) {
                    max = Math.max(sums[0] + sums[1] + 1, max);
                    sums[0] = sums[1];
                    sums[1] = 0;
                } else uses[0] = true;
            }
        }
        if (uses[0])
            max = Math.max(sums[0] + sums[1] + 1, max);
        else max = Math.max(sums[0], max);
        if (uses[1])
            max = Math.max(sums[2] + sums[3] + 1, max);
        else max = Math.max(sums[2], max);

        System.out.println(max);
    }
}