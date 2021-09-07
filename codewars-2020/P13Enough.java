import java.util.*;

public class P13Enough {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int TOTAL = scanner.nextInt(), N = scanner.nextInt();
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < N; ++i)
			items.add(new Item(scanner.next(), scanner.nextInt()));
		items.sort((a, b) -> a.cost - b.cost);
		boolean broke = true;
		
		for (Item i : items) {
			if (TOTAL >= i.cost) {
				i.bought = true;
				broke = false;
				TOTAL -= i.cost;
			}
			else break;
		}
		
		items.sort((a, b) -> a.id - b.id);
		items.forEach(i -> System.out.println((i.bought ? "I can afford " : "I can't afford ") + i.name));
		if (broke)
			System.out.println("I need more Yen!");
		System.out.println(TOTAL);
		scanner.close();
	}
	
	static class Item {
		String name;
		int id;
		static int nextID = 0;
		int cost;
		boolean bought;
		
		public Item(String name, int cost) {
			this.name = name;
			this.cost = cost;
			this.id = nextID++;
			this.bought = false;
		}
	}

}
