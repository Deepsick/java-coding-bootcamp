package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;

public class Numbers2 extends Numbers1 {
  public static char[][] generateTriplets() {
    int count = NumberUtils.factorialRecursive(10) 
            / (NumberUtils.factorialRecursive(10 - 3) * NumberUtils.factorialRecursive(3));
    char[][] triplets = new char[count][3];
    int index = 0;

    for (char i = '0'; i <= '7'; i++) {
      for (char j = (char) (i + 1); j <= '8'; j++) {
        for (char k = (char) (j + 1); k <= '9'; k++) {
          if (j != k && j != i && k != i) {
            triplets[index] = new char[]{i, j, k};
            index++;
          }
        }
      }
    }

    return triplets;
  }

  public static char[][] generateTuples() {
    char [][] tuples = new char[10 * 10 * 10 * 10][5];
    int index = 0;
    for (char i = '0'; i <= '9'; i++) {
      for (char j = '0'; j <= '9'; j++) {
        for (char k = '0'; k <= '9'; k++) {
          for (char l  = '0'; l <= '9'; l++) {
            tuples[index] = new char[]{i, j, ' ', k, l};
            index++;
          }
        }
      }
    }

    return tuples;
  }

  public static char[][] generateTuples(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    if (amount == 0) {
      return new char[0][0];
    }
  
    int count = (int) NumberUtils.power(10, amount);
    char [][] tuples = new char[count][amount];
    int index = 0;
    int counter = 0;
    int iterationsCount = count / 10;
    while (counter < amount) {
      char symbol = '0';
      for (int i = 0; i < count; i++) {
        if (tuples[i] == null) {
          tuples[i] = new char[amount];
        }
        if (i % iterationsCount == 0) {
          symbol = symbol == '9' ? '0' : (char) (symbol + 1);
        }
        tuples[i][counter] = symbol;
      }
      counter++;
      iterationsCount /= 10;
    }
    
    return tuples;
  }
}
