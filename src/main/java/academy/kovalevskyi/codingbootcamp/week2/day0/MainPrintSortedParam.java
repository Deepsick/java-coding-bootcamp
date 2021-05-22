package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week1.day1.Sorting;
import java.util.Comparator;

public class MainPrintSortedParam {
  public static void main(String... args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
      return;
    }

    Comparator<String> comparator = (String left, String right) -> left.compareTo(right);
    Sorting.sort(args, comparator);
    for (String arg : args) {
      System.out.println(arg);
    }
  }
}
