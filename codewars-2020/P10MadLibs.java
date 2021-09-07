import java.util.*;

public class P10MadLibs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] sentence = scanner.nextLine().split(" ");
		LinkedList<String> n = new LinkedList<>(), aj = new LinkedList<>(), v = new LinkedList<>(), av = new LinkedList<>();
		scanner.next();
		String next = scanner.next();
		while (! next.equals("ADVERBS")) {
			n.add(next);
			next = scanner.next();
		}
		next = scanner.next();
		while (! next.equals("VERBS")) {
			av.add(next);
			next = scanner.next();
		}
		next = scanner.next();
		while (! next.equals("ADJECTIVES")) {
			v.add(next);
			next = scanner.next();
		}
		next = scanner.next();
		while (! next.equals("END")) {
			aj.add(next);
			next = scanner.next();
		}
		
		for (int aa = 0; aa < 2; ++aa) {
			for (String item : sentence)
				switch(item) {
				case "[N]":
					System.out.print(n.removeFirst() + " "); break;
				case "[AJ]":
					System.out.print(aj.removeFirst() + " "); break;
				case "[V]":
					System.out.print(v.removeFirst() + " "); break;
				case "[AV]":
					System.out.print(av.removeFirst() + " "); break;
				default:
					System.out.print(item + " ");
				}
			System.out.println();
		}
			
	}

}
