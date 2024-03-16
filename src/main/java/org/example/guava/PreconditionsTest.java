package org.example.guava;

import com.google.common.base.Preconditions;

public class PreconditionsTest {

  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      Preconditions.checkArgument(i < 5, "Index is greater than or equal to 5, it is %s.", i);
    }
  }
}
