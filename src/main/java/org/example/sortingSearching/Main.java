package org.example.sortingSearching;

import java.util.*;

public class Main {

  // Om Gupta, Colin Thai, Dahlia Akins, Bryce Sato, the fly in Dahlia's ear,
  // Crystal Nguyen, & Yi-Ju Tseng
  public static void main(String[] args) {
    SSList s = new SSList();
    s.addAll(Arrays.asList(1, 3, 5, 6, 7, 8, 2, 4)); //initialization
    s.bogoSort();
    s.scramble(); //unsort
    System.out.println(s.recLineSearch(2)); //unsorted list searching
    s.recSelecSort();
    System.out.println(s.recBinSearch(2)); //sorted list searching
  }
}
