package org.example.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
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
}
