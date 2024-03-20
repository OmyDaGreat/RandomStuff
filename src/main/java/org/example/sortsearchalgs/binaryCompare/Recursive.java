package org.example.sortsearchalgs.binaryCompare;

import java.util.ArrayList;

public class Recursive {
    public static int recursiveBinarySearch(ArrayList<Integer> list, int target, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid; // Element found
            }

            if (list.get(mid) > target) {
                return recursiveBinarySearch(list, target, left, mid - 1); // Search in the left half
            }

            return recursiveBinarySearch(list, target, mid + 1, right); // Search in the right half
        }

        return -1; // Element not found
    }
}
