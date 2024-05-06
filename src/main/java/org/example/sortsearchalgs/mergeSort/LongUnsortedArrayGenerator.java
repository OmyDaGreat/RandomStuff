package org.example.sortsearchalgs.mergeSort;

import java.util.*;

public class LongUnsortedArrayGenerator {
    
    private LongUnsortedArrayGenerator() {}
    
    public static ArrayList<Integer> generateUnsortedArrayList(int size) {
        ArrayList<Integer> unsortedArrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            unsortedArrayList.add(random.nextInt());
        }
        return unsortedArrayList;
    }

}