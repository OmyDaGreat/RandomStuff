package org.example.rishi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkupFileGenerator {

    private static final String BASE_DIR = "markupFiles";

    public static void main(String[] args) {
        generateMarkupFiles();
    }

    private static void generateMarkupFiles() {
        File baseDir = new File(BASE_DIR);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }

        int sum = 0;
        List<Integer> numbers = new ArrayList<>();
        int fileCount = 0;

        while (sum <= 30000) {
            File file = new File(baseDir, "file" + (fileCount + 1) + ".txt");
            if (!file.exists()) {
                try (FileWriter writer = new FileWriter(file)) {
                    for (int number : numbers) {
                        writer.write(number + " ");
                    }
                    writer.write("\n");
                    System.out.println("Created file: " + file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            sum += numbers.size();
            if (sum <= 30000) {
                numbers.add(1);
                fileCount++;
            }
        }
    }
}
