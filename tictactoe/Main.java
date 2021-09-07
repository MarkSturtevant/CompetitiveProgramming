package marks.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Random rand = new Random();
    	
    	System.out.println("1000 1000");
    	for (int i = 0; i < 1000; ++i)
    		System.out.print(rand.nextInt(10000) + 1 + " ");
    	System.out.println();
		
		/*Random rand = new Random();
		int N = 2000, M = 2;
		List<String> toppings2 = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O");
		List<String> toppings = new ArrayList<>(toppings2);
		Collections.shuffle(toppings);
		while (toppings.size() > M)
			toppings.remove(0);
		System.out.println(N + " " + M);
		for (String next : toppings)
			System.out.print(next + " ");
		System.out.println();
		for (int i = 0; i < N; ++i)
			System.out.println(toppings.get(rand.nextInt(toppings.size())));*/
		
		/*
		Board b = new Board(Board.STARTING_BOARD);
		
		System.out.println(Arrays.toString(b.b[0]));
		System.out.println(Arrays.toString(b.b[1]));
		System.out.println(Arrays.toString(b.b[2]));
		
		b.doBestMove();
		
		System.out.println();
		System.out.println(Arrays.toString(b.b[0]));
		System.out.println(Arrays.toString(b.b[1]));
		System.out.println(Arrays.toString(b.b[2]));*/
	}
	
}
