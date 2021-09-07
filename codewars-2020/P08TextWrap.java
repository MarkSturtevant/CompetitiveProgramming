import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08TextWrap {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		List<String> materials = new ArrayList<>();
		String next = "";
		while (! (next = scanner.nextLine()).equals("ENDINPUT")) {
			if (next.trim().startsWith("public"))
				materials.add(next.substring(next.indexOf("ial ") + 4, next.indexOf(";")));
		}
		System.out.println();
		String[] output = new String[5];
		output[1] = "List<ItemStack> earlyGame = Arrays.asList(";
		output[2] = "List<ItemStack> midGame = Arrays.asList(";
		output[3] = "List<ItemStack> lateGame = Arrays.asList(";
		output[4] = "List<ItemStack> explor = Arrays.asList(";
		for (String mat : materials) {
			System.out.println();
			System.out.print(mat + " ? : ");
			int take = scanner.nextInt();
			if (take == 5)
				continue;
			else output[take] += "new ItemStack(Material." + mat + "), ";
		}
		
		for (int i = 1; i < 5; ++i) {
			output[i] += ");";
			System.out.println(output[i]);
			System.out.println();
		}
		scanner.close();
	}
	
	private static void output(String line) {
		int start = 0, end = -1;
		start = 0;
		while (true) {
			end = start + 200;
			if (end > line.length() - 1) {
				System.out.println(line.substring(start));
				break;
			}
			while (line.charAt(end) != ' ')
				end--;
			System.out.println(line.substring(start, end));
			start = end + 1;
		}
	}

}

/*
public class P08TextWrap {

public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	int start = 0, end = -1;
	String line = "";
	while ((line = reader.readLine()) != null) {
		start = 0;
		while (true) {
			end = start + 80;
			if (end > line.length() - 1) {
				System.out.println(line.substring(start));
				break;
			}
			while (line.charAt(end) != ' ')
				end--;
			System.out.println(line.substring(start, end));
			start = end + 1;
		}
	}
	
	reader.close();
}

}
*/