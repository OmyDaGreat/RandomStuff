package org.example.renamedStuff.test;

import lombok.experimental.ExtensionMethod;
import lombok.extern.log4j.Log4j2;
import org.example.renamedStuff.BoolExtension;

import static org.example.renamedStuff.For.rewindTime;

@Log4j2
@ExtensionMethod(BoolExtension.class)
public class BoolExtensionTest {
	
	public static void main(String[] args) {
		rewindTime(10, x ->
			Boolean.valueOf(x % 2 == 0).ternary(() -> log.info("x is even"), () -> log.info("x is not even"))
		);
	}
}
