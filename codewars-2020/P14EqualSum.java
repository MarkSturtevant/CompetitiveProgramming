import java.util.Scanner;

public class P14EqualSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(), E = scanner.nextInt();
		boolean found = false;
		for (; N < E; ++N) {
			int copy = N;
			int sum1 = 0, sum2 = 0;
			boolean left = true;
			while (copy > 0) {
				if (left)
					sum1 += copy % 10;
				else sum2 += copy % 10;
				copy /= 10;
				left = ! left;
			}
			if (sum1 == sum2 && N != 0) {
				found = true;
				System.out.print(N + " ");
			}
		}
		if (! found)
			System.out.println("No Numbers found with Equal Sum in the given range!!");
		scanner.close();
	}

}
