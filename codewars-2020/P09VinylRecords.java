import java.util.Scanner;

public class P09VinylRecords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int secondsIn = scanner.nextInt() * 60 + scanner.nextInt();
			if (! scanner.hasNextInt())
				break;
			int remaining = 60 * 50 - secondsIn;
			int minutes = remaining / 60;
			int seconds = remaining - minutes * 60;
			System.out.print("Time remaining " + minutes + " minutes and " + seconds + " seconds");
			if (remaining >= 25 * 60)
				System.out.println();
			else if (remaining >= 0)
				System.out.println(" (we'll need both sides)");
			else System.out.println(" (we're gonna need a bigger record)");
		}
		scanner.close();
	}

}
