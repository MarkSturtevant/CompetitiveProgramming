import java.util.*;

public class P19HiddenHexMessage {

	public static void main(String[] args) {
		char[] chars = new Scanner(System.in).nextLine().toCharArray();
		List<String> codes = new ArrayList<>();
		for (int i = 0; i < chars.length; ++i)
			if (chars[i] != ' ')
				codes.add(Integer.toHexString(0 + chars[i]));
		codes.forEach(str -> System.out.print(str + " "));
		System.out.println();
		String message1 = "";
		for (int i = codes.size() % 2 == 0 ? 1 : 0; i < codes.size(); i += 2)
			message1 += codes.get(i).charAt(1);
		System.out.println(message1);
		String message2 = "";
		for (int i = 0; i < message1.length() - 1; i += 2)
			message2 += (char) Integer.parseInt(message1.substring(i, i + 2), 16);
		System.out.println(message2);
	}

}
