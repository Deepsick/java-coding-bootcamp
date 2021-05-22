package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    if (target == null || comparator == null) {
      throw new NullPointerException("target or comparator can't be null");
    }
    for (int i = 0; i < target.length - 1; i++) {
      for (int j = 0; j < target.length - i - 1; j++) {
        if (comparator.compare(target[j], target[j + 1]) > 0) {
          T temp = target[j + 1];
          target[j + 1] = target[j];
          target[j] = temp;
        }
      }
    }
  }
  
  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    if (comparator == null || target == null) {
      throw new NullPointerException("can't find target or comparator");
    }

    for (int i = 0; i < target.length - 1; i++) {
      if (comparator.compare(target[i], target[i + 1]) < 0) {
        T temp = target[i + 1];
        target[i + 1] = target[i];
        target[i] = temp;
        i = -1;
      }
    }
  }
}
