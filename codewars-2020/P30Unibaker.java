import java.util.*;
import java.io.*;

// Resembles a brute force solution; should not be used for N > 5

public class P30Unibaker {
	
	static int COUNTER = 0, SIZE = 5;
	
	static int[][] promised, map;
	static Stack<Move> moves;
	
	static int[][][] pairs = new int[][][] {{{2, 2}, {1, 2}}, {{2, 1}, {2, 2}}, {{1, 2}, {2, 2}}, {{2, 2}, {2, 1}}, {{2, 1}, {1, 1}}, {{1, 2}, {1, 1}}, {{1, 1}, {2, 1}}, {{1, 1}, {1, 2}}, 
		{{2, 1}, {2, 1}}, {{1, 2}, {1, 2}}, {{2, 2}, {1, 1}}, {{1, 1}, {2, 2}}};
		
	static int[][] jumps = new int[][] {{-2, -1}, {-2, -2}, {-1, -2}};

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		SIZE = scanner.nextInt();
		promised = new int[SIZE][SIZE];
		map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; ++i) {
			char[] in = scanner.next().toCharArray();
			for (int j = 0; j < SIZE; ++j) {
				if (in[j] == '#') {map[i][j] = 2;}
				if (in[j] == '.') {map[i][j] = 1;}
			}
		}
		scanner.close();
		
		nextMove(0, 0);
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j)
				System.out.print(map[i][j] == 1 ? '.' : (map[i][j] == 2 ? '#' : '?'));
			System.out.println();
		}
		
	}
	
	static boolean nextMove(int r, int c) {
		if (c == SIZE - 1) c--;
		if (c == SIZE) {
			c = 0;
			r += 2;
			if (r == SIZE - 1) r--;
			if (r == SIZE) return true;
		}
		for (int[][] match : pairs) {
			Move move = new Move(false);
			if (map[r][c] != 0 && map[r][c] != match[0][0]) continue;
			else if (map[r][c] == 0) move.coords.add(new Coord(r, c));
			if (map[r + 1][c] != 0 && map[r + 1][c] != match[1][0]) continue;
			else if (map[r + 1][c] == 0) move.coords.add(new Coord(r + 1, c));
			if (map[r][c + 1] != 0 && map[r][c + 1] != match[0][1]) continue;
			else if (map[r][c + 1] == 0) move.coords.add(new Coord(r, c + 1));
			if (map[r + 1][c + 1] != 0 && map[r + 1][c + 1] != match[1][1]) continue;
			else if (map[r + 1][c + 1] == 0) move.coords.add(new Coord(r + 1, c + 1));
			
			for (Coord coord : move.coords)
				map[coord.r][coord.c] = match[coord.r - r][coord.c - c];
			
			if (scan(r + 1, c + 1) && nextMove(r, c + 2))
				return true;
			
			for (Coord coord : move.coords)
				map[coord.r][coord.c] = 0;
			
		}
		return false;
	}
	
	static boolean scan(int topR, int topC) {
		for (int[] jump : jumps) {
			if (topR + jump[0] < 0 || topC + jump[1] < 0) continue;
			int counter = 0;
			for (int a = 0; a < 2; ++a)
				for (int b = 0; b < 2; ++b) {
					if (map[topR + jump[0] + a][topC + jump[1] + b] == 1)
						counter++;
					else counter--;
				}
			if (Math.abs(counter) == 4)
				return false;
		}
		boolean[][] visited = new boolean[SIZE][SIZE];
		int counter2 = 0;
		for (int k = 0; k <= topR; ++k)
			for (int l = 0; l <= topC; ++l)
				if (! visited[k][l]) {
					++counter2;
					boolean meet = false;
					Coord startCoord = new Coord(k, l);
					Queue<Coord> queue = new LinkedList<>();
					queue.add(startCoord);
					while (! queue.isEmpty()) {
						Coord next = queue.poll();
						if (topR < SIZE-1 && next.r == topR) meet = true;
						if (topC < SIZE-1 && next.c == topC) meet = true;
						visited[next.r][next.c] = true;
						if (next.r > 0 && ! visited[next.r - 1][next.c] && map[next.r - 1][next.c] == map[next.r][next.c])
							queue.add(new Coord(next.r - 1, next.c));
						if (next.r < SIZE - 1 && ! visited[next.r + 1][next.c] && map[next.r + 1][next.c] == map[next.r][next.c])
							queue.add(new Coord(next.r + 1, next.c));
						if (next.c > 0 && ! visited[next.r][next.c - 1] && map[next.r][next.c - 1] == map[next.r][next.c])
							queue.add(new Coord(next.r, next.c - 1));
						if (next.c < SIZE - 1 && ! visited[next.r][next.c + 1] && map[next.r][next.c + 1] == map[next.r][next.c])
							queue.add(new Coord(next.r, next.c + 1));
					}
					if (meet)
						--counter2;
				}
		if (topR == SIZE-1 && topC == SIZE-1 ? counter2 == 2 : counter2 == 0)
			return true;
		return false;
	}
	
	static class Move {
		boolean perfect;
		List<Coord> coords;
		
		public Move(boolean perfect) {
			this.coords = new ArrayList<>();
			this.perfect = perfect;
		}
	}
	
	static class Coord {
		int r, c;
		
		public Coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	/*
	static void solve(int[][] solution, int i, int j) {
		if (j >= SIZE) {
			++i;
			j = 0;
		} if (i >= SIZE) {
			boolean[][] visited = new boolean[SIZE][SIZE];
			int counter2 = 0;
			for (int k = 0; k < SIZE; ++k)
				for (int l = 0; l < SIZE; ++l)
					if (! visited[k][l]) {
						++counter2;
						Coord startCoord = new Coord(k, l);
						Queue<Coord> queue = new LinkedList<>();
						queue.add(startCoord);
						while (! queue.isEmpty()) {
							Coord next = queue.poll();
							visited[next.r][next.c] = true;
							if (next.r > 0 && ! visited[next.r - 1][next.c] && solution[next.r - 1][next.c] == solution[next.r][next.c])
								queue.add(new Coord(next.r - 1, next.c));
							if (next.r < SIZE - 1 && ! visited[next.r + 1][next.c] && solution[next.r + 1][next.c] == solution[next.r][next.c])
								queue.add(new Coord(next.r + 1, next.c));
							if (next.c > 0 && ! visited[next.r][next.c - 1] && solution[next.r][next.c - 1] == solution[next.r][next.c])
								queue.add(new Coord(next.r, next.c - 1));
							if (next.c < SIZE - 1 && ! visited[next.r][next.c + 1] && solution[next.r][next.c + 1] == solution[next.r][next.c])
								queue.add(new Coord(next.r, next.c + 1));
						}
					}
			if (counter2 == 2) {
				++COUNTER;
				for (int k = 0; k < SIZE; ++k)
					System.out.println(Arrays.toString(solution[k]));
				System.out.println();
			}
			return;
		}
		solution[i][j] = 1;
		int counter1 = 0;
		if (i > 0 && j > 0)
			for (int k = 0; k < 2; ++k)
				for (int l = 0; l < 2; ++l)
					if (solution[i][j] == solution[i - k][j - l])
						++counter1;
		if (counter1 < 4)
			solve(solution, i, j + 1);
		solution[i][j] = 2;
		counter1 = 0;
		if (i > 0 && j > 0)
			for (int k = 0; k < 2; ++k)
				for (int l = 0; l < 2; ++l)
					if (solution[i][j] == solution[i - k][j - l])
						++counter1;
		if (counter1 < 4)
			solve(solution, i, j + 1);
		solution[i][j] = 0;
	}
	
	static class Coord {
		int r, c;
		public Coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	*/
}
