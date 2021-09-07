import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class P26CountdownClock {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\\s\\-:]+");
		while (scanner.hasNext()) {
			GregorianCalendar gc1 = new GregorianCalendar(scanner.nextInt(), scanner.nextInt() - 1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			String lineage = scanner.nextLine();
			Scanner scanner2 = new Scanner(lineage);
			scanner2.useDelimiter("[\\s\\-:]+");
			GregorianCalendar gc2 = new GregorianCalendar(scanner2.nextInt(), scanner2.nextInt() - 1, scanner2.nextInt(), scanner2.nextInt(), scanner2.nextInt(), scanner2.nextInt());
			String output = scanner2.next();
			
			String a = gc1.getTime().toString(), b = gc2.getTime().toString();
			long difference = gc2.getTimeInMillis() - gc1.getTimeInMillis();
			if (a.contains("CST") && b.contains("CDT"))
				difference += 1000 * 60 * 60;
			else if (b.contains("CST") && a.contains("CDT"))
				difference -= 1000 * 60 * 60;
			
			System.out.print("there are ");
			long subtraction = 0;
			long days = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
			long hours = TimeUnit.HOURS.convert(difference, TimeUnit.MILLISECONDS);
			long minutes = TimeUnit.MINUTES.convert(difference, TimeUnit.MILLISECONDS);
			long seconds = TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);
			
			if (output.contains("D")) {
				System.out.print(days + " days ");
				subtraction = days;
			}
			subtraction *= 24;
			if (output.contains("H")) {
				System.out.print(hours - subtraction + " hours ");
				subtraction = hours;
			}
			subtraction *= 60;
			if (output.contains("M")) {
				System.out.print(minutes - subtraction + " minutes ");
				subtraction = minutes;
			}
			subtraction *= 60;
			if (output.contains("S"))
				System.out.print(seconds - subtraction + " seconds ");
			System.out.println("remaining until" + lineage.substring(0, lineage.lastIndexOf(" ")));
			scanner2.close();
		}
		scanner.close();
	}

}
