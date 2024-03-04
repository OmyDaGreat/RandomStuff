package org.example.renamedStuff;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class TryCatch {

  public static void main(String[] args) {
    screwAroundAndFindOut(
      () -> {
        // This will cause an exception
        throw new RuntimeException("bc i said so");
      },
      e -> {
        // Handle the exception
        System.out.println("You found out: ");
        e.printStackTrace();
      }
    );
  }

  public static void screwAroundAndFindOut(
    Callable<Void> tryF,
    Consumer<Exception> catchF
  ) {
    try {
      tryF.call();
    } catch (Exception e) {
      catchF.accept(e);
    }
  }
}
