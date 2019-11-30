package tsw.t04;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import tsw.excecoes.ParametroInvalidoException;

public class Fibonacci {
	
	/**
	 * A Rainbow table Map to store the Fibonacci Numbers already computed.
	 */
	private Map<Integer, BigInteger> aFibonacciNumbersMap;
	
	/**
	 * Using a rainbow table to avoid the necessity to recompute the same Fibonacci number multiple
	 * times.
	 * 
	 * Once a specific Fibonacci Number is computed, it is stored in a Map. 
	 * When it is needed, it is get from there.
	 * 
	 * It a Fibonacci Number is needed, but not computed yet, it is computed, ant its value is
	 * stored in the Map.
	 * 
	 * 
	 * @param pNumber
	 * @return
	 * @throws ParametroInvalidoException
	 */
	public BigInteger getFibbonaciNumber( int pNumber ) throws ParametroInvalidoException {
		BigInteger result = BigInteger.ZERO;
		
		if ( pNumber < 0 ) {
			throw new ParametroInvalidoException();
		}
		
		if ( pNumber == 0 || pNumber == 1 ) {
			// Special cases of Fibonacci Numbers, when the result is the number itself
			result = BigInteger.valueOf(pNumber);
		} else {
			if (	isFibonacciNumberAlreadyComputedAndStored(pNumber)		) {
				// Fibonacci Number was already computed and stored in the Map
				result = this.aFibonacciNumbersMap.get(pNumber);
			} else {
				// When the Fibonacci Number needs to be computed and stored in the Map
				
				// Compute the Fibonacci Number
				result = 
					getFibbonaciNumber(pNumber - 1)		.add(
					getFibbonaciNumber(pNumber - 2)
				);
				
				initiateMapIfNeeded();
				
				// Store the new Fibonacci Number computed in the Map
				this.aFibonacciNumbersMap.put(pNumber, result);
			}
		}
		
		return result;
	}
	
	/**
	 * This method will result True if all this conditions is true:
	 *  - The Map that stores the Fibonacci Numbers were already initiated;
	 *  - The Map is not empty;
	 *  - The Map contains the Fibonacci Number that is been looked for.
	 * 
	 * @param pNumber		Fibonacci Number that is been lloked for
	 * 
	 * @return
	 */
	private boolean isFibonacciNumberAlreadyComputedAndStored(int pNumber) {
		return 
			 this.aFibonacciNumbersMap != null					&&
			!this.aFibonacciNumbersMap.isEmpty()				&&
			 this.aFibonacciNumbersMap.containsKey(pNumber);
	}
	
	/**
	 * If the Map that stores the Fibonacci Numbers is null, it will be initiated.
	 */
	private void initiateMapIfNeeded() {
		if ( this.aFibonacciNumbersMap == null ) {
			this.aFibonacciNumbersMap = new HashMap<Integer, BigInteger>();
		}
	}
	
}