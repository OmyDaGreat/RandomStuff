package org.example.renamedStuff;

import java.util.function.Supplier;

public class BoolExtension {

	public static Boolean not(Boolean b) {
		return !b;
	}
	
	public static Boolean ternary(Boolean b, Runnable r, Runnable r2) {
		if(b) {
			r.run();
		} else {
			r2.run();
		}
		return b;
	}
}
