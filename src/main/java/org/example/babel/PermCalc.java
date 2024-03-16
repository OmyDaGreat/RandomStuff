package org.example.babel;

import java.math.BigInteger;

public class PermCalc {
  public static void main(String[] args) {
    int x = 20;
    int y = 2;
    BigInteger result = BigInteger.ZERO;
    BigInteger factorial30000 = factorial(BigInteger.valueOf(30000));
    
    while (x >= 1) {
      BigInteger factorialXLess = factorial(BigInteger.valueOf(30000 - (long) x));
      BigInteger permutation = factorial30000.divide(factorialXLess);
      result = result.add(permutation.divide(BigInteger.valueOf(y)));
      x--;
      y++;
    }
    
    System.out.println(result);
    
    if (result.isProbablePrime(100)) {
      System.out.println("The number is probably prime.");
    } else {
      System.out.println("The number is not prime.");
    }
  }
  
  public static BigInteger factorial(BigInteger n) {
    BigInteger result = BigInteger.ONE;
    for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
      result = result.multiply(i);
    }
    return result;
  }
}
