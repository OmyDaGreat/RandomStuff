package org.example.sortingSearching;

import java.util.*;

public class SSList extends ArrayList<Integer> {

  private final Random r = new Random();

  public SSList() {
    super();
  }

  public SSList(SSList s) {
    super(s);
  }

  // recursive binary search
  public String recBinSearch(Integer t) {
    int index = recBinSearch(t, 0, size() - 1);
    return index == -1
        ? "Couldn't find the number " + t + " in the list."
        : "Found the number " + t + " at index " + index + ".";
  }

  public Integer recBinSearch(Integer t, Integer min, Integer max) {
    if (max >= min) {
      int mid = (max + min) / 2;
      if (Objects.equals(t, get(mid))) {
        return mid;
      } else if (t > get(mid)) {
        return recBinSearch(t, mid + 1, max);
      } else {
        return recBinSearch(t, min, mid - 1);
      }
    } else {
      return -1;
    }
  }

  // recursive linear search
  public String recLineSearch(Integer t) {
    int index = recLineSearch(0, t);
    return index == -1
        ? "Couldn't find the number " + t + " in the list."
        : "Found the number " + t + " at index " + index + ".";
  }

  public Integer recLineSearch(Integer i, Integer t) {
    if (get(i).equals(t)) {
      return i;
    } else if (i == size() - 1) {
      return -1;
    } else {
      return recLineSearch(i + 1, t);
    }
  }

  // recursive selection sort
  public void recSelecSort() {
    if (Boolean.FALSE.equals(sortChecker())) {
      System.out.println("Iteration " + 0 + ": " + this); // print
      recSelecSort(0);
    } else {
      System.out.println("Already sorted.."); // print
    }
  }

  public void recSelecSort(int start) {
    if (Boolean.FALSE.equals(sortChecker())) {
      int mini = start;
      for (int i = start; i < size(); i++) {
        if (get(i) < get(mini)) {
          mini = i;
        }
      }
      Integer temp = get(mini);
      set(mini, get(start));
      set(start, temp);
      System.out.println("Iteration " + (start + 1) + ": " + this); // print
      recSelecSort(start + 1);
    }
  }

  // bogo sort
  public void bogoSort() {
    int i = 1;
    while (Boolean.FALSE.equals(sortChecker())) {
      scramble();
      if (i % 2 == 1) {
        System.out.println("Iteration " + i + ": " + this); // print
      }
      i++;
    }
    System.out.println("Iteration " + (i - 1) + ": " + this); // print
    System.out.println("Sorted in " + (i - 1) + " scrambles!"); // print
  }

  public void scramble() {
    SSList temp = new SSList(this);
    SSList used = new SSList();
    clear();
    while (used.size() < temp.size()) {
      Integer i = r.nextInt(temp.size());
      if (!used.contains(i)) {
        add(temp.get(i));
        used.add(i);
      }
    }
  }

  public void replace(SSList s) {
    clear();
    for (int i = 0; i < s.size(); i++) {
      add(i, s.get(i));
    }
  }

  public Boolean sortChecker() {
    if (get(0) <= get(size() - 1)
        && get(size() / 2) <= get(size() - 1)
        && get(0) <= get(size() / 2)) {
      for (int i = 0; i < size() - 1; i++) {
        if (get(i) > get(i + 1)) {
          return false;
        }
      }
    } else {
      return false;
    }
    return true;
  }
}
