import java.util.*;

public class P27RhymesWithAblaut {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int N = scanner.nextInt();
			if (N == 0)
				break;
			String[] words = new String[N];
			for (int i = 0; i < N; ++i)
				words[i] = scanner.next();
			int length = words[0].length();
			for (int i = 1; i < N; ++i)
				if (words[i].length() != length)
					length = -1;
			boolean found = true;
			if (length > -1) { // all words are same length
				int index = -1;
				for (index = words[0].length() - 1; index >= 0; --index)
					if (words[0].charAt(index) != words[1].charAt(index))
						break;
				if (index == -1)
					print(words, "COPY");
				else if (getValue(words[0].charAt(index)) > 0) {
					boolean progressive = true;
					int value = getValue(words[0].charAt(index));
					for (int i = 1; i < words.length; ++i) {
						if (getValue(words[i].charAt(index)) > value)
							progressive = false;
						else value = getValue(words[i].charAt(index));
					}
					if (progressive)
						print(words, "PROGRESSIVE");
					else print(words, "ABLAUT");
				}
				else found = false;
			}
			else found = false;
			
			if (! found) {
				boolean shm = false;
				for (int i = 0; i < words.length; ++i)
					if (words[i].startsWith("SHM"))
						shm = true;
				if (shm)
					print(words, "SHM");
				else print(words, "RHYMING");
			}
			
		}
		scanner.close();
	}
	
	static void print(String[] words, String title) {
		for (int i = 0; i < words.length; ++i)
			System.out.print(words[i] + " ");
		System.out.println(title);
	}
	
	static int getValue(char c) {
		switch(c) {
		case 'I': return 5;
		case 'A': return 4;
		case 'E': return 3;
		case 'O': return 2;
		case 'U': return 1;
		default: return 0;
		}
	}

}
