package org.example.rishi;

import java.math.BigInteger;
import java.util.ArrayList;

public class DecimalToBase64Converter {

  private static final String BASE64_CHARS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,+/=.;:_-<>?!@#$%^&*()";

  public static String decimalToBase64(int decimal) {
    StringBuilder base64 = new StringBuilder();
    do {
      base64.insert(0, BASE64_CHARS.charAt(decimal % BASE64_CHARS.length()));
      decimal /= BASE64_CHARS.length();
    } while (decimal > 0);

    // Add padding if necessary
    while (base64.length() < 3) {
      base64.insert(0, 'A'); // Assuming 'A' is the padding character
    }

    return base64.toString();
  }

  public static BigInteger base64ToDecimal(String base64) {
    return getBigInteger(base64, BASE64_CHARS);
  }

  public static BigInteger getBigInteger(String base64, String base64Chars) {
    BigInteger decimal = BigInteger.ZERO;
    BigInteger base = BigInteger.valueOf(base64Chars.length());

    for (int i = 0; i < base64.length(); i++) {
      char c = base64.charAt(i);
      int index = base64Chars.indexOf(c);
      decimal = decimal.multiply(base).add(BigInteger.valueOf(index));
    }

    return decimal;
  }

  // Convert ArrayList<Integer> to Base64 String
  public static String arrayListToBase64(ArrayList<Integer> list) {
    StringBuilder base64 = new StringBuilder();
    for (int num : list) {
      String decimalBase64 = decimalToBase64(num);
      base64.append(decimalBase64);
    }
    return base64.toString();
  }

  // Convert Base64 String to ArrayList<Integer>
  public static ArrayList<Integer> base64ToArrayList(String base64) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < base64.length(); i += 3) {
      String chunk = base64.substring(i, Math.min(i + 3, base64.length()));
      BigInteger decimal = base64ToDecimal(chunk);
      list.add(decimal.intValue());
    }
    return list;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(30000);
    list.add(1);
    String base64 = arrayListToBase64(list);
    System.out.println("Base64: " + base64);
    ArrayList<Integer> decodedList = base64ToArrayList(base64);
    System.out.println("Decoded ArrayList: " + decodedList);
  }
}
