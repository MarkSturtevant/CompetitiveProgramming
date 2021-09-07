import java.util.Scanner;

public class P02MirroredNumber {

	public static void main(String[] args) {
		char[] arr = new Scanner(System.in).next().toCharArray();
		for (int i = arr.length - 1; i >= 0; --i)
			System.out.print(arr[i]);
	}
	
}
