package org.example.yeet;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class LongestPrefix { //14 - Longest Common Prefix
    public static void main(String[] args) {
        String[] strs = {"a"};
        log.info(new LongestPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        String c = "";
        for (int i = 1; i < Arrays.stream(strs)
                .mapToInt(String::length)
                .min().orElse(0)+1; i++) {
            c = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].substring(0, i).equals(c)) {
                    return c.substring(0, c.length() - 1);
                }
            }
        }
        return c;
    }
}
