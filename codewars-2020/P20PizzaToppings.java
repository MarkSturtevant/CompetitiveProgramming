import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P20PizzaToppings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		map.put("Pepperoni", 32);
		map.put("Red Peppers", 16);
		map.put("Pineapple", 84);
		map.put("Olives", 20);
		map.put("Sardines", 12);
		map.put("Onion", 28);
		map.put("Sausage", 40);
		map.put("Ham", 36);
		Map<String, List<String>> map2 = new HashMap<>();
		map2.put("Hawaiian", Arrays.asList("Pineapple", "Ham"));
		map2.put("Combo", Arrays.asList("Red Peppers", "Olives", "Onion", "Sausage"));
		map2.put("Fishaster", Arrays.asList("Sardines", "Onion"));
		map2.put("Meat-Lovers", Arrays.asList("Pepperoni", "Sausage", "Ham"));
		map2.put("Cheese", new ArrayList<>());
		map2.put("Pepperoni", Arrays.asList("Pepperoni"));
		map2.put("Red Peppers", Arrays.asList("Red Peppers"));
		map2.put("Pineapple", Arrays.asList("Pineapple"));
		map2.put("Olives", Arrays.asList("Olives"));
		map2.put("Sardines", Arrays.asList("Sardines"));
		map2.put("Onion", Arrays.asList("Onion"));
		map2.put("Sausage", Arrays.asList("Sausage"));
		map2.put("Ham", Arrays.asList("Ham"));
		Map<String, Integer> map3 = new HashMap<>();
		map3.put("Pepperoni", 0);
		map3.put("Red Peppers", 0);
		map3.put("Pineapple", 0);
		map3.put("Olives", 0);
		map3.put("Sardines", 0);
		map3.put("Onion", 0);
		map3.put("Sausage", 0);
		map3.put("Ham", 0);
		//for (int i = 0; i < 4; ++i) {
		while (scanner.hasNextLine()) {
			Scanner scanner2 = new Scanner(scanner.nextLine());
			scanner2.useDelimiter("[ &]+");
			int multiplier = scanner2.nextInt();
			while (scanner2.hasNext()) {
				String item = scanner2.next();
				int fraction = 1;
				if (item.charAt(0) == '1') {
					fraction = Integer.parseInt(item.substring(2));
					item = scanner2.next();
				}
				// edge case - Red Peppers
				if (item.equals("Red"))
					item += " " + scanner2.next();
				//System.out.println(item);
				for (String topping : map2.get(item))
					map3.put(topping, map3.get(topping) + multiplier * map.get(topping) / fraction);
			}
			scanner2.close();
		}
		System.out.println("Pepperoni: " + map3.get("Pepperoni"));
		System.out.println("Red Peppers: " + map3.get("Red Peppers"));
		System.out.println("Pineapple: " + map3.get("Pineapple"));
		System.out.println("Olives: " + map3.get("Olives"));
		System.out.println("Sardines: " + map3.get("Sardines"));
		System.out.println("Onion: " + map3.get("Onion"));
		System.out.println("Sausage: " + map3.get("Sausage"));
		System.out.println("Ham: " + map3.get("Ham"));
		scanner.close();
	}
	
}
 