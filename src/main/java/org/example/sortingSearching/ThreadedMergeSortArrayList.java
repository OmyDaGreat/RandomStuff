package org.example.sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadedMergeSortArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 6, 2, 7, 4));
        System.out.println("Original Array: " + array);

        mergeSort(array);
        System.out.println("Sorted Array: " + array);
    }

    public static void mergeSort(ArrayList<Integer> array) {
        if (array.size() <= 1) {
            return;
        }

        int mid = array.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(array.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(array.subList(mid, array.size()));

        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(() -> mergeSort(left));
            executor.submit(() -> mergeSort(right));
            executor.shutdown();
            
            
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("Timeout occurred before all tasks completed.");
            }
            
            merge(array, left, right);
        } catch (InterruptedException i) {
            System.err.println("Thread was interrupted while waiting for tasks to complete.");
            Thread.currentThread().interrupt(); // Preserve the interrupt status
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void merge(ArrayList<Integer> array, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                array.set(k++, left.get(i++));
            } else {
                array.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            array.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            array.set(k++, right.get(j++));
        }
    }
}
