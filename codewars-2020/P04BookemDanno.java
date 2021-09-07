import java.util.Scanner;

public class P04BookemDanno {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long A = scanner.nextLong(), B = scanner.nextLong();
		if (A == 0 || B == 0)
			System.out.println("0");
		else System.out.println(A * B / gcd(A, B));
	}
	
	private static long gcd(long A, long B) {
		while (B != 0) {
			long temp = B;
			B = A % B;
			A = temp;
		}
		return A;
	}
	
}
