import java.util.Scanner;

public class P16MathChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double a = scanner.nextDouble(), b = scanner.nextDouble();
			String operation = scanner.next();
			double c = scanner.nextDouble();
			double result = Double.NEGATIVE_INFINITY;
			String operator = "";
			switch(operation) {
			case "POWER":
				result = Math.pow(a, b); operator = "^"; break;
			case "DIVIDE":
				result = a / b; operator = "/"; break;
			case "MULTIPLY":
				result = a * b; operator = "*"; break;
			case "ADD":
				result = a + b; operator = "+"; break;
			case "SUBTRACT":
				result = a - b; operator = "-"; break;
			}
			result = Math.round(result * 10) / 10.0;
			c = Math.round(c * 10) / 10.0;
			if (result == c)
				System.out.printf("%.1f is correct for %.1f %s %.1f\n", result, a, operator, b);
			else System.out.printf("%.1f %s %.1f = %.1f, not %.1f\n", a, operator, b, result, c);
		}
		scanner.close();
	}

}
