package org.example;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TonsOfThreads {
    public static void main(String args[]) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    System.out.println("Hello World: " + i);
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
    }
}
