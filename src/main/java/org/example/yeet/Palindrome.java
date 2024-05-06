package org.example.yeet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Palindrome { //9 - Palindrome Number
    public static void main(String[] args) {
        log.info(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        StringBuilder z = new StringBuilder(Integer.toString(x));
        log.info(z);
        z.reverse();
        log.info(z);
        log.info(z.toString());
        return z.toString().equals(Integer.toString(x));
    }
}