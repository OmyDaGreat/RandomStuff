package org.example.pointer;

public class Pointers {

  public static void main(String[] args) {
    IntObj x; // Allocate the pointers x and y
    IntObj y; // (but not the IntObj pointees)

    x = new IntObj(); // Allocate an IntObj pointee
    // and set x to point to it

    x.value = 42; // Dereference x to store 42 in its pointee

    //y.value = 13;   // CRASH -- y does not have a pointee yet

    y = x; // Pointer assignment sets y to point to x's pointee

    y.value = 13; // Deference y to store 13 in its (shared) pointee

    System.out.println("x value is " + x + ", y value is " + y);
    System.out.println("x equals y: " + x.equals(y));
    System.out.println("x == y: " + (x == y));
  }
}
