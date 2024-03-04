package org.example.renamedStuff;

import java.util.function.Consumer;

public class For {
    public static void rewindTime(int i, int e, Consumer<Integer> forF) {
        for(int x = i; x<e; x++) {
            forF.accept(x);
        }
    }
}
