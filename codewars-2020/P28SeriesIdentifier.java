import java.util.*;
import java.io.*;

public class P28SeriesIdentifier {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String nextLine = null;
		while ((nextLine = reader.readLine()) != null) {
			String[] in = nextLine.split(" ");
			long[] terms = new long[in.length];
			for (int i = 0; i < terms.length; ++i)
				terms[i] = Long.parseLong(in[i]);
			String result = null;
			if (result == null) { // testing X^2
				boolean fits = true;
				for (int i = 1; i < terms.length; ++i)
					if (terms[i] != terms[i-1] * terms[i-1]) {
						fits = false;
						break;
					}
				if (fits)
					result = "X^2";
			}
			if (result == null) { // testing X^3
				boolean fits = true;
				for (int i = 1; i < terms.length; ++i)
					if (terms[i] != terms[i-1] * terms[i-1] * terms[i-1]) {
						fits = false;
						break;
					}
				if (fits)
					result = "X^3";
			}
			if (result == null) { // testing fibonachi
				boolean fits = true;
				for (int i = 2; i < terms.length; ++i)
					if (terms[i] != terms[i-1] + terms[i-2]) {
						fits = false;
						break;
					}
				if (fits)
					result = "Fibonacci";
			}
			if (result == null) { // testing geometric + geometric w/ gaps
				Set<Double> divides = new TreeSet<>(Double::compareTo);
				for (int i = 1; i < terms.length; ++i) {
					double div = (double) terms[i] / terms[i-1];
					divides.add(div < 1 ? 1 / div : div);
				}
					
				//System.out.println(divides);
				if (divides.size() == 1)
					result = "Geometric";
				else if (divides.size() == 2) {
					Iterator<Double> iter = divides.iterator();
					double div1 = iter.next(), div2 = iter.next();
					double val = Math.log(div2) / Math.log(div1);
					if (Math.abs(val - Math.round(val)) < 0.000000001)
						result = "Geometric (With Gaps)";
				}
			}
			if (result == null) {
				for (long term : terms)
					System.out.print(term + " ");
				System.out.println("is an Unknown series");
			} else System.out.println(result);
		}
	}

}

/* Scrapped Code: Identify multiple gaps.
 * List<Double> vals = new ArrayList<>(divides);
					for (int x = 1; x <= 150; ++x) {
						double a = Math.pow(vals.get(0), 1.0 / x);
						boolean fits = true;
						for (int i = 1; i < vals.size(); ++i) {
							double x2 = Math.log(vals.get(i)) / Math.log(a);
							if (Math.abs(x2 - Math.round(x2)) > 0.000000001) {
								fits = false;
								break;
							}
						}
						if (fits) {
							result = "Geometric (With Gaps)";
							break;
						}
					}
*/
