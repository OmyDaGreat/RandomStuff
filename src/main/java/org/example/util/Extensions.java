package org.example.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Extensions {
    //Strings
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    private static final Set<String> WORDS_NOT_TO_CAPITALIZE = new HashSet<>(Arrays.asList(
        "a", "an", "the", "and", "but", "or", "for", "nor", "on", "at", "to", "from", "by", "in", "of", "on", "at", "to", "from", "by", "in", "of"
    ));
    public static String toTitleCase(@NonNull String input) {
        if (input.isEmpty()) {
            return input;
        }
        int spaceIndex = input.indexOf(' ');
        if (spaceIndex == -1) {
            if (WORDS_NOT_TO_CAPITALIZE.contains(input.toLowerCase())) {
                return input.toLowerCase();
            } else {
                return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            }
        } else {
            String firstWord = input.substring(0, spaceIndex);
            if (WORDS_NOT_TO_CAPITALIZE.contains(firstWord.toLowerCase())) {
                firstWord = firstWord.toLowerCase();
            } else {
                firstWord = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1).toLowerCase();
            }
            return firstWord + " " + toTitleCase(input.substring(spaceIndex + 1));
        }
    }
    public static boolean isEmail(String str) {
        // Simple regex for email validation
        return str != null && str.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
    public static String capitalizeFirstLetter(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }
    public static String toCamelCase(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        String[] words = string.split("\\s+");
        StringBuilder camelCaseString = new StringBuilder();
        for (String word : words) {
            camelCaseString.append(capitalizeFirstLetter(word.toLowerCase()));
        }
        return camelCaseString.toString();
    }
    //Integers
    public static Integer reverse(Integer i) {
        return Integer.valueOf(new StringBuilder(i).reverse().toString());
    }
    //Files
    public static String readFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }
    public static void writeFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes());
    }
    public static boolean deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directory.delete();
    }
    //DateTime
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
