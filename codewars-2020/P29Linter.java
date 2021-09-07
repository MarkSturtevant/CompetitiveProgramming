import java.io.*;
import java.util.*;

public class P29Linter {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> lines = new ArrayList<>();
		String next;
		//while (! (next = reader.readLine()).equals("END"))
		while ((next = reader.readLine()) != null)
			lines.add(next);
		boolean ind = false;
		for (int lineID = 0; lineID < lines.size(); ++lineID) {
			String line = lines.get(lineID);
			if (line.equals(""))
				continue;
			if (line.trim().equals("NEXT") || line.trim().equals("ENDIF") || line.trim().equals("ENDFUNC"))
				ind = false;
			if (line.contains("VAR") && ! line.trim().startsWith("#")) {
				String varName = "$" + line.trim().split(" ")[1];
				boolean found = false;
				for (int lineID2 = lineID + 1; lineID2 < lines.size(); ++lineID2) {
					String line2 = lines.get(lineID2);
					if (ind && (line2.trim().equals("NEXT") || line2.trim().equals("ENDIF") || line2.trim().equals("ENDFUNC")))
						break;
					if (line2.contains(varName) && (line2.indexOf('#') == -1 || line2.indexOf(varName) < line2.indexOf('#'))) {
						found = true;
						break;
					}
				}
				if (! found)
					System.out.println(lineID + 1 + ":10 Variable declared but not used");
			}
			boolean throw30 = Character.isWhitespace(line.charAt(line.length() - 1)) && line.indexOf('#') == -1;
			if (ind && ! line.matches("    \\S.*"))
				System.out.println(lineID + 1 + ":20 Unexpected indentation");
			else if (! ind && ! line.matches("\\S.*"))
				System.out.println(lineID + 1 + ":20 Unexpected indentation");
			
			if (throw30)
				System.out.println(lineID + 1 + ":30 Trailing whitespace");
			
			line = line.trim();
			if (line.startsWith("FUNC")) {
				if (lineID == 0)
					System.out.println(lineID + 1 + ":40 Func declaration without documentation");
				else {
					String prevLine = lines.get(lineID - 1);
					int inde = prevLine.indexOf('#');
					if (inde == -1 || ! prevLine.substring(inde).startsWith(("# " + line.substring(line.indexOf(' ') + 1, line.indexOf('(')))))
						System.out.println(lineID + 1 + ":40 Func declaration without documentation");
						
				}
			}
			
			if (line.trim().startsWith("FOR") || line.trim().startsWith("IF") || line.trim().startsWith("FUNC"))
				ind = true;
		}
		
		reader.close();
	}

}
