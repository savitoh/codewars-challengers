package com.github.savitoh;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimeTest {
    
    @Test
	public void testBasic() {
		assertFalse(Prime.isPrime(0));
		assertFalse(Prime.isPrime(1));
		assertTrue (Prime.isPrime(2));
		assertTrue (Prime.isPrime(73));
		assertFalse(Prime.isPrime(75));
		assertFalse(Prime.isPrime(-1));
	}
	
	@Test
	public void testPrime() {
		assertTrue(Prime.isPrime(3));
		assertTrue(Prime.isPrime(5));
		assertTrue(Prime.isPrime(7));
		assertTrue(Prime.isPrime(41));
		assertTrue(Prime.isPrime(5099));
	}
	
	@Test
	public void testNotPrime() {
		assertFalse(Prime.isPrime(4));
		assertFalse(Prime.isPrime(6));
		assertFalse(Prime.isPrime(8));
		assertFalse(Prime.isPrime(9));
		assertFalse(Prime.isPrime(45));
		assertFalse(Prime.isPrime(-5));
		assertFalse(Prime.isPrime(-8));
		assertFalse(Prime.isPrime(-41));
	}
}