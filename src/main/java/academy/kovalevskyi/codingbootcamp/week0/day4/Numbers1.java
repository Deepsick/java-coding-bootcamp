package academy.kovalevskyi.codingbootcamp.week0.day4;

import java.util.stream.IntStream;

public class Numbers1 {
  public static int[] generateNumbers() {
    return IntStream.rangeClosed(0, 99).toArray();
  }

  public static int[] generateNumbers1() {
    int numbersCount = 100; 
    int[] numbers = new int[numbersCount];
    for (int i = 0; i < numbersCount; i++) {
      numbers[i] = i;
    }

    return numbers;
  }

  public static int findBiggest(int left, int right) {
    if (left == right) {
      return left;
    }

    return left > right ? left : right;
  }

  public static int findBiggest(int left, int mid, int right) {
    int max = Numbers1.findBiggest(left, right);

    return Numbers1.findBiggest(max, mid);
  }

  public static int findBiggest(int[] numbers) {
    int max = numbers[0];
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }

    return max;
  }

  public static int findIndexOfBiggestNumber(int[] numbers) {
    int maxNumberIndex = 0;
    int max = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > max) {
        maxNumberIndex = i;
        max = numbers[i]; 
      }
    }

    return maxNumberIndex;
  }

  public static boolean isNegative(int number) {
    return number < 0;
  }

  public static char[] convertToCharArray(int number) {
    return ("" + number).toCharArray();
  }

}
