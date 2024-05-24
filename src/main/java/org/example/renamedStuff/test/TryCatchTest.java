package org.example.renamedStuff.test;

import lombok.extern.log4j.Log4j2;

import static org.example.renamedStuff.TryCatch.screwAroundAndFindOut;

@Log4j2
public class TryCatchTest {
	
	public static void main(String[] args) {
		screwAroundAndFindOut(
				() -> {
					// This will cause an exception
					throw new RuntimeException("bc i said so");
				},
				e -> {
					// Handle the exception
					log.error("You found out: ");
					e.printStackTrace();
				});
	}
}
