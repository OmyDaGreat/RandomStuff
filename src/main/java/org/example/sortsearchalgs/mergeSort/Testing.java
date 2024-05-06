package org.example.sortsearchalgs.mergeSort;

import java.util.ArrayList;

public class Testing {
	
	public static void main(String[] args) {
		long totalTimeTaken = 0;
		for (int i = 0; i < 100; i++) {
			ArrayList<Integer> array = new ArrayList<>(LongUnsortedArrayGenerator.generateUnsortedArrayList(1000));
			System.out.println("Original ArrayList: " + array);
			
			long start = System.nanoTime();
			ThreadedMergeSortArrayList.mergeSort(array);
			long duration = System.nanoTime() - start;
			totalTimeTaken += duration;
			System.out.println("\nSorted ArrayList: " + array);
			System.out.println("Time taken: " + duration + " ns");
			System.out.println("Aka: " + duration/1000000000 + " s");
		}
		long totalTimeTaken2 = 0;
		for (int i = 0; i < 100; i++) {
			ArrayList<Integer> array = new ArrayList<>(LongUnsortedArrayGenerator.generateUnsortedArrayList(1000));
			System.out.println("Original ArrayList: " + array);
			
			long start = System.nanoTime();
			MergeSortArrayList.mergeSort(array);
			long duration = System.nanoTime() - start;
			totalTimeTaken2 += duration;
			System.out.println("\nSorted ArrayList: " + array);
			System.out.println("Time taken: " + duration + " ns");
			System.out.println("Aka: " + duration/1000000000 + " s");
		}
		System.out.println("\nTotal time taken: " + totalTimeTaken + " ns");
		System.out.println("Aka: " + totalTimeTaken/1000000000 + " s");
		System.out.println("\nAverage time taken: " + totalTimeTaken/100 + " ns");
		System.out.println("Aka: " + totalTimeTaken/100/1000000000 + " s");
		
		System.out.println("\n2nd Total time taken: " + totalTimeTaken2 + " ns");
		System.out.println("Aka: " + totalTimeTaken2/1000000000 + " s");
		System.out.println("\n2nd Average time taken: " + totalTimeTaken2/100 + " ns");
		System.out.println("Aka: " + totalTimeTaken2/100/1000000000 + " s");
	}
	
}
