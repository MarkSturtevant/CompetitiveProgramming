import java.util.*;

public class P24Crossword {
	
	static char[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		map = new char[11][11];
		for (int i = 0; i < 11; ++i) for (int j = 0; j < 11; ++j) map[i][j] = '?';
		List<Word> words = new ArrayList<>();
		List<String> wordsList = new ArrayList<>();
		while (scanner.hasNextInt())
			words.add(new Word(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		scanner.next();
		while (scanner.hasNextInt()) {
			int c = scanner.nextInt(), r = scanner.nextInt();
			map[r][c] = scanner.next().charAt(0);
		}
		scanner.next();
		//for (int i = 0; i < 17; ++i)
		while (scanner.hasNext())
			wordsList.add(scanner.next());
		fill(new ArrayList<>(words), wordsList);
		words.forEach(w -> w.print());
		scanner.close();
	}
	
	static boolean fill(List<Word> words, List<String> wordList) {
		if (words.size() == 0)
			return true;
		
		Word next = words.remove(words.size() - 1);
		String nextW = next.getWord();
		for (int i = 0; i < wordList.size(); ++i) {
			String nextS = wordList.get(i);
			if (next.length != nextS.length())
				continue;
			boolean fits = true;
			for (int j = 0; j < next.length; ++j)
				if (nextW.charAt(j) != '?' && nextW.charAt(j) != nextS.charAt(j)) {
					fits = false;
					break;
				}
			if (fits) {
				wordList.remove(i);
				next.fillWord(nextS);
				if (fill(words, wordList))
					return true;
				next.fillWord(nextW);
				wordList.add(i, nextS);
			}
		}
		words.add(next);
		return false;
	}
	
	static class Word {
		int index;
		boolean horizontal;
		int length, c, r;
		String filledWord;
		
		public Word(int index, String vert, int leng, int c, int r) {
			this.index = index;
			this.horizontal = vert.equals("H");
			this.length = leng;
			this.c = c;
			this.r = r;
			this.filledWord = "";
		}
		
		public String getWord() {
			String output = "";
			for (int i = 0; i < length; ++i) {
				if (horizontal)
					output += map[r][c + i];
				else output += map[r + i][c];
			}
			return output;
		}
		
		public void fillWord(String word) {
			this.filledWord = word;
			for (int i = 0; i < length; ++i) {
				if (horizontal)
					map[r][c + i] = word.charAt(i);
				else map[r + i][c] = word.charAt(i);
			}
		}
		
		public void print() {
			String num = index < 10 ? "0" + index : "" + index;
			System.out.println(num + " is " + filledWord);
		}
	}

}
