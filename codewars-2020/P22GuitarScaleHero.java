import java.util.*;

public class P22GuitarScaleHero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, String> aMap1 = new HashMap<>(), eMap1 = new HashMap<>();
		Map<String, Integer> aMap2 = new HashMap<>(), eMap2 = new HashMap<>();
		aMap1.put(0, "A");
		aMap1.put(2, "B");
		aMap1.put(3, "C");
		aMap1.put(5, "D");
		aMap1.put(7, "E");
		aMap1.put(8, "F");
		aMap1.put(10, "G");
		aMap1.put(12, "A");
		eMap1.put(0, "E");
		eMap1.put(1, "F");
		eMap1.put(3, "G");
		eMap1.put(5, "A");
		eMap1.put(7, "B");
		eMap1.put(8, "C");
		eMap1.put(10, "D");
		eMap1.put(12, "E");
		aMap2.put("A", 0);
		aMap2.put("B", 2);
		aMap2.put("C", 3);
		aMap2.put("D", 5);
		aMap2.put("E", 7);
		aMap2.put("F", 8);
		aMap2.put("G", 10);
		eMap2.put("E", 0);
		eMap2.put("F", 1);
		eMap2.put("G", 3);
		eMap2.put("A", 5);
		eMap2.put("B", 7);
		eMap2.put("C", 8);
		eMap2.put("D", 10);
		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(" ");
			if (line.length == 1) {
				System.out.print(eMap2.get(line[0]) + " E ");
				if (eMap2.get(line[0]) == 0) System.out.print(12 + " E ");
				System.out.print(aMap2.get(line[0]) + " A");
				if (aMap2.get(line[0]) == 0) System.out.print(" 12 A");
				System.out.println();
			} else {
				int id = Integer.parseInt(line[0]);
				Map<Integer, String> map = line[1].equals("E") ? eMap1 : aMap1;
				do {
					id++;
					id %= 13;
				} while (map.get(id) == null);
				System.out.println(map.get(id));
			}
		}
		scanner.close();
	}

}
