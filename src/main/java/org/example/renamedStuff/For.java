package org.example.renamedStuff;

import java.util.function.Consumer;
import java.util.function.Function;

public class For {

  public static void rewindTime(int i, int e, Consumer<Integer> forF) {
    for (int x = i; x < e; x++) {
      forF.accept(x);
    }
  }

  public static void rewindTime(int e, Consumer<Integer> forF) {
    for (int x = 0; x < e; x++) {
      forF.accept(x);
    }
  }
  
  public static void rewindTime(int i, int e, Function<Integer, Integer> changeX, Consumer<Integer> forF) {
    for (int x = i; x < e; x = changeX.apply(x)) {
      forF.accept(x);
    }
  }
  
  public static void rewindTime(int e, Function<Integer, Integer> changeX, Consumer<Integer> forF) {
    for (int x = 0; x < e; x = changeX.apply(x)) {
      forF.accept(x);
    }
  }
}
