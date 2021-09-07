import java.util.Scanner;

public class P12MetricMeltdown {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] in = scanner.nextLine().split(" ");
			double result = 0.0;
			if (in.length >= 1)
				result += Double.parseDouble(in[0]) * 3 * 0.3048 * 100;
			if (in.length >= 2)
				result += Double.parseDouble(in[1]) * 0.3048 * 100;
			if (in.length >= 3)
				result += Double.parseDouble(in[2]) * 2.54;
			System.out.printf("%.2f\n", result);
		}
		scanner.close();
	}
	
}
