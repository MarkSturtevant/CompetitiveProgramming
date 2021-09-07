import java.util.*;

public class P21TimeClock {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			scanner.next();
			String name = scanner.next();				scanner.next();
			double rate = scanner.nextDouble();
			double gain = 0.0;
			for (int i = 0; i < 2; ++i) {
				scanner.next();
				String in = scanner.next();					scanner.next();
				String out = scanner.next();				
				int hours = Integer.parseInt(out.substring(0, 2)) - Integer.parseInt(in.substring(0, 2));
				int minutes = Integer.parseInt(out.substring(2, 4)) - Integer.parseInt(in.substring(2, 4));
				gain += hours * rate + minutes * rate / 60;
			}
			System.out.printf("%s earned $%.2f\n", name, gain);
			
		}
		scanner.close();
	}

}
