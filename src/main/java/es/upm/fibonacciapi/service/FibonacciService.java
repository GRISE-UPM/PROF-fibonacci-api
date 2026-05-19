package es.upm.fibonacciapi.service;

import es.upm.fibonacciapi.exception.InvalidNumberException;
import org.springframework.stereotype.Service;

@Service

public class FibonacciService {
	public static String TYPE = "Recursive";

    /**
     * Function that calculates Fibonacci's number (recursive).
     *
     * @param n position in the Fibonacci sequence
     * @return Fibonacci's number
     * @throws InvalidNumberException if n is negative or greater than 92
     */
	 
	public long calculate(int n) throws InvalidNumberException {
		
		if ((n > 92) || (n < 0))
			throw new InvalidNumberException();
			
		if (n <= 1)
			return n;
		
		return(calculate(n-1) + calculate(n-2));
	}

	/**
	 * Function that calculates Fibonacci's number (iterative)
	 * @param n
	 * @return		Fibonacci's number
	 * @throws InvalidNumberException */
	
//	public static String TYPE = "Iterative";
//
//   	public static long calculate(int n) throws InvalidNumberException {
//		long fn_minus_2 = 0;
//		long fn_minus_1 = 1;
//		long fn = 2; // Unnecessary
//		
//		if ((n > 92) || (n < 0))
//			throw new InvalidNumberException();
//		
//		if (n <= 1)
//			return n;
//		
//		for (int i=2; i <= n; i++) {
//			fn = fn_minus_1 + fn_minus_2;
//			fn_minus_2 = fn_minus_1;
//			fn_minus_1 = fn;
//		}
//			
//		return fn;
//	}


}
