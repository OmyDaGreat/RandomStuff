package org.example.sortsearchalgs.mergeSort;

import java.util.ArrayList;

public class MergeSortArrayList {
    
    private MergeSortArrayList() {}
	
	public static void mergeSort(ArrayList<Integer> numList) {
        if (numList.size() > 1) {
            int mid = numList.size() / 2;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            // Split the list into left and right halves
            for (int i = 0; i < mid; i++)
                left.add(numList.get(i));
            for (int j = mid; j < numList.size(); j++)
                right.add(numList.get(j));

            // Recursively sort the left and right halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves
            merge(numList, left, right);
        }
    }

    private static void merge(ArrayList<Integer> numList, ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int numbersIndex = 0;

        // Merge the left and right halves
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                numList.set(numbersIndex++, left.get(leftIndex++));
            } else {
                numList.set(numbersIndex++, right.get(rightIndex++));
            }
        }

        // Copy remaining elements from both halves
        while (leftIndex < left.size()) {
            numList.set(numbersIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            numList.set(numbersIndex++, right.get(rightIndex++));
        }
    }
}
