package org.example.sortsearchalgs.binaryCompare;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.val;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Test {
    public static void main(String[] args) {
	    val list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
        val start = System.nanoTime();
        Binary.binarySearch(list, 12);
        var firstLength = System.nanoTime() - start;
        val start2 = System.nanoTime();
        Recursive.recursiveBinarySearch(list, 12, 0, list.size());
        var secLength = System.nanoTime() - start2;
	    log.info("Non-recursive: {} nanoseconds", firstLength);
	    log.info("Recursive: {} nanoseconds", secLength);
    }
}
