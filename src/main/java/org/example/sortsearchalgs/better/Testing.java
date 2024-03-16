package org.example.sortsearchalgs.better;

import java.util.ArrayList;

public class Testing {
	
	public static void main(String[] args) {
		long totalTimeTaken = 0;
		for (int i = 0; i < 100; i++) {
			ArrayList<Integer> array = new ArrayList<>(LongUnsortedArrayGenerator.generateUnsortedArrayList(10000));
			System.out.println("Original ArrayList: " + array);
			
			long start = System.nanoTime();
			ThreadedMergeSortArrayList.mergeSort(array);
			long duration = System.nanoTime() - start;
			totalTimeTaken += duration;
			System.out.println("\nSorted ArrayList: " + array);
			System.out.println("Time taken: " + duration + " ns");
			System.out.println("Aka: " + duration/1000000000 + " s");
		}
		System.out.println("\nTotal time taken: " + totalTimeTaken + " ns");
		System.out.println("Aka: " + totalTimeTaken/1000000000 + " s");
		System.out.println("\nAverage time taken: " + totalTimeTaken/100 + " ns");
		System.out.println("Aka: " + totalTimeTaken/100/1000000000 + " s");
	}
	
}
