import java.util.Scanner;

public class everyone {

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); scanner.nextLine();
        String next = scanner.nextLine();
        while (true) {
            int i = next.indexOf("&");
            if (i == -1) {
                System.out.println(next);
                return;
            } else {
                int code = Integer.parseInt("" + next.charAt(i + 1));
                next = decode(scanner.nextLine(), key(code));
            }
        }

    }

    public static String decode(String encrypted, String key) {
        String toBuild = "";
        int[] keyArr = new int[key.length()];
        for (int i = 0; i < keyArr.length; ++i)
            keyArr[i] = intVal(key.charAt(i));
        int keyIndex = 0;
        for (int i = 0; i < encrypted.length(); ++i) {
            int val = intVal(encrypted.charAt(i));
            if (val == Integer.MAX_VALUE) {
                toBuild += encrypted.charAt(i);
                continue;
            }
            val -= keyArr[keyIndex++];
            if (val < 0)
                val += 27;
            toBuild += charVal(val);

            keyIndex %= keyArr.length;
        }
        return toBuild;
    }

    public static String key(int id) {
        switch(id) {
            case 0:
                return "marksturtevant";
            case 1:
                return "dannychen";
            case 2:
                return "jimmyding";
            case 3:
                return "anhnguyen";
            case 4:
                return "robinbailey";
            case 5:
                return "collinjakubik";
            case 6:
                return "ericzhang";
            case 7:
                return "aaronchang";
            case 8:
                return "maxwelljiang";
            case 9:
                return "saibommisetty";
            default:
                return "";
        }
    }

    public static int intVal(char c) {
        if (c == '&')
            return 26;
        else if (c >= 'a' && c <= 'z')
            return c - 'a';
        else return Integer.MAX_VALUE;
    }

    public static char charVal(int i) {
        if (i == 26)
            return '&';
        else if (i < 26)
            return (char) (i + 'a');
        else return '~';
    }

}
