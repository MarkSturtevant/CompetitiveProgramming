import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P11CyclopsNumber {

	public static void main(String[] args) {
		Set<Long> set = new HashSet<>();
		set.add(0L);
		for (int i = 2; i < 100; i += 2)
			set.add((long) Math.pow(2, i + 1) - 1 - (long) Math.pow(2, i / 2));
		
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLong()) {
			long next = scanner.nextLong();
			System.out.println(next + (set.contains(next) ? " yes" : " no"));
		}
		scanner.close();
	}
	
}
