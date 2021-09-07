import java.math.BigInteger;
//import java.util.BitSet;
import java.util.Scanner;

public class P05HordaksBoss {

	public static void main(String[] args) {
		long N = new Scanner(System.in).nextLong();
		
		// BigInteger Solution -- not 100% guarentee
		System.out.println(N + (BigInteger.valueOf(N).isProbablePrime(109) ? " is PRIME" : " is NOT Prime"));
		
		// BitSet Solution -- too slow.  Must change N to int if using
		/*
		BitSet bits = new BitSet(N+1);
		bits.clear();
		bits.flip(0, N);
		double csqrtn = Math.ceil(Math.sqrt(N));
		for (int i = 2; i < csqrtn; ++i) 
			if (bits.get(i)) 
				for (int j = i * i; j < N; j += i) 
					bits.set(j, false);
		System.out.println(N + (bits.get(N) ? " is PRIME" : " is NOT Prime"));*/
	}

}
