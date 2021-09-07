import java.util.*;

public class P15Duplicates {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int N = scanner.nextInt() + scanner.nextInt();
			if (N == 0)
				break;
			scanner.nextLine(); //split
			String line1 = scanner.nextLine(), line2 = scanner.nextLine();
			System.out.println(line1);
			System.out.println(line2);
			Set<String> words1 = new HashSet<>(Arrays.asList(line1.toLowerCase().split(" "))), words2 = new HashSet<>(Arrays.asList(line2.toLowerCase().split(" ")));
			Set<String> duplicates = new TreeSet<>();
			int count = 0;
			for (String next : words1)
				if (words2.contains(next))
					if (duplicates.add(next))
						++count;
			System.out.print(count);
			duplicates.forEach(d -> System.out.print(" " + d));
			System.out.println();
		}
		scanner.close();
	}

}
