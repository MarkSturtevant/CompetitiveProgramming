import java.util.*;

public class P17Neighbour {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		Map<String, City> map = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			String next = scanner.next();
			map.put(next, new City(next));
		}
		scanner.nextLine(); // flush
		 for (int aa = 0; aa < 3; ++aa) {
		//while (scanner.hasNext()) {
			String[] line = scanner.nextLine().split(" ");
			if (! line[8].equals("air")) {
				Set<City> combined = new HashSet<>();
				combined.addAll(map.get(line[1]).neighbors);
				combined.addAll(map.get(line[6]).neighbors);
				combined.forEach(city -> {
					city.neighbors.addAll(combined);
				});
			}
		}
		List<City> cities = new ArrayList<>(map.values());
		cities.sort((a, b) -> a.a - b.a);
		cities.forEach(city -> {
			if (city.neighbors.size() <= 1)
				System.out.println("City " + city.index + " is remote and has no neighbours!");
			else {
				city.neighbors.remove(city);
				List<City> neigh = new ArrayList<>(city.neighbors);
				neigh.sort((a, b) -> a.a - b.a);
				System.out.print("City " + city.index + " is neighbour to Cities ");
				for (int i = 0; i < neigh.size() - 1; ++i)
					System.out.print(neigh.get(i).index + ",");
				System.out.println(neigh.get(city.neighbors.size() - 1).index);
			}
		});
	}
	
	static class City {
		String index;
		static int counter = 0;
		int a;
		Set<City> neighbors;
		
		public City(String index) {
			this.index = index;
			this.a = counter++;
			this.neighbors = new HashSet<>();
			neighbors.add(this);
		}
	}

}
