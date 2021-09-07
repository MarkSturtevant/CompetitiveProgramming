import java.io.*;
import java.util.*;

public class P25JumpSpaceMap {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		Map<String, Coord> map = new HashMap<>();
		String[] in = reader.readLine().split(" ");
		int N = Integer.parseInt(in[0]), Q = Integer.parseInt(in[1]);
		
		for (int i = 0; i < N; ++i) {
			in = reader.readLine().split(" ");
			map.put(in[1], new Coord(Integer.parseInt(in[0].substring(0, 2)), Integer.parseInt(in[0].substring(2))));
		}
		
		for (int i = 0; i < Q; ++i) {
			in = reader.readLine().split(" ");
			int x1 = map.get(in[0]).x, y1 = map.get(in[0]).y, x2 = map.get(in[1]).x, y2 = map.get(in[1]).y;
			int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
			if (y2 > y1) {
				int temp1 = x1, temp2 = y1;
				x1 = x2; y1 = y2;
				x2 = temp1; y2 = temp2;
			}
			int maxChange = Math.min(Math.abs(x1 - x2), Math.abs(y1 - y2));
			int changes = Math.abs(x2 - x1) / 2 + (x1 % 2 == 1 && Math.abs(x2 - x1) % 2 == 1 ? 1 : 0);
			distance -= Math.min(maxChange, changes);
			System.out.println(in[0] + " " + in[1] + " " + distance);
		}
		
		pw.close();
		reader.close();
	}
	
	static class Coord {
		int x, y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
