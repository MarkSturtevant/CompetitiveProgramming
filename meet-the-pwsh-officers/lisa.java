import java.io.IOException;
import java.util.Scanner;

public class lisa {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in); // this should work...

        int I = scan.nextInt();
        int operation = 0;

        while (scan.hasNextInt()) {
            int next = scan.nextInt();
            switch(operation) {
                case 0:
                    I += next;
                    break;
                case 1:
                    I -= next;
                    break;
                case 2:
                    I *= next;
                    break;
                case 3:
                    if (next == 0)
                        continue;
                    I /= next;
                    break;
            }
            operation++;
            operation %= 4;
        }

        System.out.println(I);
        scan.close();
    }

}
