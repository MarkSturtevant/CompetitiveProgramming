import java.util.*;

public class P23DownYouMop {

	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<>();
		map.put('o', 'o');
		map.put('s', 's');
		map.put('x', 'x');
		map.put('z', 'z');
		map.put('a', 'e');
		map.put('e', 'a');
		map.put('b', 'q');
		map.put('q', 'b');
		map.put('d', 'p');
		map.put('p', 'd');
		map.put('h', 'y');
		map.put('y', 'h');
		map.put('m', 'w');
		map.put('w', 'm');
		map.put('n', 'u');
		map.put('u', 'n');
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		for (int aa = 0; aa < N; ++aa) {
			List<Character> list1 = getChars(scanner.nextLine().toLowerCase().toCharArray());
			List<Character> list2 = new ArrayList<>();
			boolean is = true;
			for (int i = list1.size() - 1; i >= 0; --i) {
				if (map.get(list1.get(i)) == null) {
					list2.add(list1.get(i));
					if (list1.get(i) != ' ')
						is = false;
				}
					
				else list2.add(map.get(list1.get(i)));
			}
			int j = 0, k = 0;
			
			while (j < list1.size() && is) {
				while (list1.get(j) == ' ') ++j;
				while (list2.get(k) == ' ') ++k;
				if ((char) list1.get(j) != (char) list2.get(k))
					is = false;
				++j;  ++k;
			}
			list1.forEach(c -> System.out.print(c));
			System.out.print(is ? " (is) " : " (not) ");
			list2.forEach(c -> System.out.print(c));
			System.out.println();
		}
		scanner.close();
	}
	
	static List<Character> getChars(char[] list) {
		List<Character> chars = new ArrayList<>();
		for (char c : list)
			if (Character.isLetter(c) || c == ' ')
				chars.add(c);
		return chars;
	}

}
