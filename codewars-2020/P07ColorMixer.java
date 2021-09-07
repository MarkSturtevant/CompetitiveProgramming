import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P07ColorMixer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		map.put("RED RED", "RED");
		map.put("ORANGE ORANGE", "ORANGE");
		map.put("YELLOW YELLOW", "YELLOW");
		map.put("GREEN GREEN", "GREEN");
		map.put("BLUE BLUE", "BLUE");
		map.put("PURPLE PURPLE", "PURPLE");
		map.put("WHITE WHITE", "WHITE");
		map.put("BLACK BLACK", "BLACK");
		map.put("BLUE RED", "PURPLE");
		map.put("BLUE YELLOW", "GREEN");
		map.put("RED YELLOW", "ORANGE");
		map.put("BLACK RED", "DARK RED");
		map.put("BLACK ORANGE", "DARK ORANGE");
		map.put("BLACK YELLOW", "DARK YELLOW");
		map.put("BLACK GREEN", "DARK GREEN");
		map.put("BLACK BLUE", "DARK BLUE");
		map.put("BLACK PURPLE", "DARK PURPLE");
		map.put("RED WHITE", "LIGHT RED");
		map.put("ORANGE WHITE", "LIGHT ORANGE");
		map.put("WHITE YELLOW", "LIGHT YELLOW");
		map.put("GREEN WHITE", "LIGHT GREEN");
		map.put("BLUE WHITE", "LIGHT BLUE");
		map.put("PURPLE WHITE", "LIGHT PURPLE");
		
		while (scanner.hasNext()) {
			String A = scanner.next(), B = scanner.next();
			if (A.compareTo(B) > 0) {
				String temp = A;
				A = B;
				B = temp;
			}
			System.out.println(map.get(A + " " + B));
		}
		
		scanner.close();
	}

}
