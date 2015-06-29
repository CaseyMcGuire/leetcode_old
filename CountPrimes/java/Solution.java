import java.util.stream.IntStream;
import java.util.*;
class Solution {

    static TreeSet<Integer> primes = new TreeSet<>();
    static {
	primes.add(2);
	primes.add(3);
    }

    /*
      Returns the number of prime numbers less than the non-negative number, n.
     */
    public static int countPrimes(int n) {
	if(n < 0) throw new IllegalArgumentException("n must not be negative");
	else if( n == 1 || n == 0 || n == 2 ) return 0;

	final int largestKnownPrime = primes.last();
	final int numPrimesKnown = primes.headSet(n, false).size();

	if(largestKnownPrime >= n) {
	    return numPrimesKnown;
	}

	int counter = numPrimesKnown;
	for(int i = largestKnownPrime + 2; i < n; i += 2) {
	    if(isPrime(i)) counter++;
	}
	
	return counter;
    }

    public static boolean isPrime(int n) {
	if( n == 1 ) return false;
	if( n == 2 ) return true;
	if( n % 2 == 0) return false;
	if(primes.contains(n)) return true;
	for(int i = 3; i < Math.sqrt(n) + 1; i += 2) {
	    if(n % i == 0) return false;
	}
	primes.add(n);
	return true;
    }

    public static void main(String[] args) {
	IntStream.rangeClosed(1,20)
	    .forEach(x -> {
		    int num = countPrimes(x);
		    System.out.println("There are " + num + " primes less than " + x);
		});
    }

}
