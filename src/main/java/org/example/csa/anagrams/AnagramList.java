package org.example.csa.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AnagramList
{
  private ArrayList<String> anagrams;

  public AnagramList(String word) {
    anagrams = new ArrayList<>();
    completeAnagrams("", word);
    anagrams = new ArrayList<>(new HashSet<>(anagrams));
    sortAnagrams();
  }

  private void completeAnagrams(String start, String end) {
    if(end.isEmpty()) {
      anagrams.add(start);
    } else {
      for(int i=0;i<end.length();i++) {
        String nS = start + end.charAt(i);
        String nE = end.substring(0,i) + end.substring(i+1);
        completeAnagrams(nS, nE);
      }
    }
  }

  private void sortAnagrams() {
    ThreadedMergeSortArrayListString.mergeSort(anagrams);
  }

  public int searchAnagrams(String target) {
    return anagrams.indexOf(target);
  }

  public ArrayList<String> getAnagrams() {
    return anagrams;
  }
  
  public static class ThreadedMergeSortArrayListString {
    
    public static void main(String[] args) {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "orange", "kiwi", "grape"));
      System.out.println("Original Array: " + array);
      
      mergeSort(array);
      System.out.println("Sorted Array: " + array);
    }
    
    public static void mergeSort(ArrayList<String> array) {
      if (array.size() <= 1) {
        return;
      }
      
      int mid = array.size() / 2;
      ArrayList<String> left = new ArrayList<>(array.subList(0, mid));
      ArrayList<String> right = new ArrayList<>(array.subList(mid, array.size()));
      
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
    
    private static void merge(ArrayList<String> array, ArrayList<String> left, ArrayList<String> right) {
      int i = 0;
      int j = 0;
      int k = 0;
      
      while (i < left.size() && j < right.size()) {
        if (left.get(i).compareTo(right.get(j)) <= 0) {
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
}
