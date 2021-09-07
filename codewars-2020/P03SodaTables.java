import java.util.Scanner;

public class P03SodaTables {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long A = scanner.nextLong(), B = scanner.nextLong();
		if (A == 0 && B == 0)
			System.out.println("0");
		else if (A == 0)
			System.out.println(B);
		else if (B == 0)
			System.out.println(A);
		else System.out.println(gcd(A, B));
		scanner.close();
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
