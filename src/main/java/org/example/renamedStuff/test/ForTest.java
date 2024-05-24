package org.example.renamedStuff.test;

import static org.example.renamedStuff.For.rewindTime;

public class ForTest {
	public static void main(String[] args) {
		rewindTime(5, x -> System.out.println("Hello world: " + x));
		rewindTime(5, 11, x -> System.out.println("Hello world: " + x));
		rewindTime(10, x -> x+1, x -> System.out.println("x is " + x));
	}
}
