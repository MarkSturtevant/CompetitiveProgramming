import java.util.*;

public class P06MartianNumerals {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);
		map.put(1000, "R");
		map.put(900, "BR");
		map.put(800, "GBBB");
		map.put(700, "GBB");
		map.put(600, "GB");
		map.put(500, "G");
		map.put(400, "BG");
		map.put(300, "BBB");
		map.put(200, "BB");
		map.put(100, "B");
		map.put(90, "ZB");
		map.put(80, "PZZZ");
		map.put(70, "PZZ");
		map.put(60, "PZ");
		map.put(50, "P");
		map.put(40, "ZP");
		map.put(30, "ZZZ");
		map.put(20, "ZZ");
		map.put(10, "Z");
		map.put(9, "BK");
		map.put(8, "WBBB");
		map.put(7, "WBB");
		map.put(6, "WB");
		map.put(5, "W");
		map.put(4, "BW");
		map.put(3, "BBB");
		map.put(2, "BB");
		map.put(1, "B");
		while (scanner.hasNext()) {
			int next = scanner.nextInt();
			String result = "";
			while (next > 1) {
				Iterator<Integer> iter = map.keySet().iterator();
				while (iter.hasNext()) {
					int nextInt = iter.next();
					if (next >= nextInt) {
						next -= nextInt;
						result += map.get(nextInt);
						break;
					}
				}
			}
			System.out.println(result);
		}
		scanner.close();
	}

}
