import java.util.Scanner;

public class P18ClockHands {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] in = scanner.nextLine().split(":");
			int H = Integer.parseInt(in[0]);
			int M = Integer.parseInt(in[1]);
			double theta1 = H * (360.0/12) + M * (360.0/(12 * 60));
			double theta2 = M * (360.0 / 60);
			double dif = Math.abs(theta1 - theta2);
			if (dif > 180)
				dif = 360 - dif;
			System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.\n", dif);
		}
		scanner.close();
	}
	
}
