package org.example.renamedStuff;

import java.util.function.Consumer;

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

  public static void main(String[] args) {
    rewindTime(
        5,
        x -> {
          System.out.println("Hello world: " + x);
        });
    rewindTime(5, 11, x -> System.out.println("Hello world: " + x));
  }
}
