package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumberUtils {
  public static int getFactorial(final int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Can't be negative");
    }
          
    if (number <= 1) {
      return 1;
    }
          
    int factorial = 1;
    int factor = number;

    while (factor > 0) {
      factorial *= factor;
      factor--;
    }

    return factorial;
  }

  public static int factorialRecursive(int number) { 
    if (number < 0) {
      throw new IllegalArgumentException("number can't be blank");
    }
          
    if (number <= 1) {
      return 1;
    }

    return factorialRecursive(number - 1) * number;
  }

  public static long power(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("power can't be negative");
    }
    
    long result = 1;
    for (int i = 0; i < power; i++) {
      result *= base;
    }

    return result;
  }

  public static int powerRecursive(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("power can't be negative");
    }

    if (power == 0) {
      return 1;
    }

    return powerRecursive(base, power - 1) * base;
  }

  public static int fibRecursive(int index) {
    if (index < 0) {
      throw new IllegalArgumentException("index can't be negative");
    }

    if (index == 0) {
      return 0;
    }
    if (index == 1) {
      return 1;
    }
    
    return fibRecursive(index - 2) + fibRecursive(index - 1);  
  }

  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException("length can't be blank");
    }

    int[] sequence = new int[length];
    if (length >= 1) {
      sequence[0] = 1;
    }
    if (length >=  2) {
      sequence[1] =  1;
    }
    
    for (int i = 2; i <= length - 1; i++) {
      sequence[i] = sequence[i - 2] + sequence[i - 1];
    }

    return sequence;
  }

  public static int sqrt(int target) {
    if (target < 0) {
      throw new IllegalArgumentException("target can't be negative");
    }

    
    for (int i = 1; i <= (int) (target / 2); i++) {
      if (i * i == target) {
        return i;
      }
    }

    return -1;
  }

  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException("target can't be negative");
    }
          
    if (target <= 1) {
      return false;
    }

    for (int i = 2; i <= target / 2; i++) {
      if (target % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static int findNextPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException("target can't be blank");
    }

    if (target <= 1) {
      return 2;
    }

    if (isPrime(target)) {
      return target;
    }

    return findNextPrime(target + 1); 
  }
  
  public static void sort(int[] target) {
    if (target == null) {
      return;
    }

    for (int i = 0; i < target.length - 1; i++) {
      for (int j = 0; j < target.length - i - 1; j++) {   
        if (target[j] > target[j + 1]) {
          int temp = target[j + 1];
          target[j + 1] = target[j];
          target[j] = temp;
        }
      }      
    }
  }    
}
