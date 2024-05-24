package org.example.renamedStuff;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class TryCatch {

  public static void screwAroundAndFindOut(Callable<Void> tryF, Consumer<Exception> catchF) {
    try {
      tryF.call();
    } catch (Exception e) {
      catchF.accept(e);
    }
  }
}
