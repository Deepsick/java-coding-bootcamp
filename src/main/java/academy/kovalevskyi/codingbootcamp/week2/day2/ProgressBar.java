package academy.kovalevskyi.codingbootcamp.week2.day2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ProgressBar {
  private static final int barSize = 80;

  private static int getRandomDelay(final int[] delays) {
    int index = new Random().nextInt(delays.length);
    return delays[index];
  }

  private static int getElementSize(int elementsCount) {
    return ProgressBar.barSize / elementsCount;
  }

  private static String getTime(int seconds) {
    Date date = new Date((long) (seconds * 1000));
    return new SimpleDateFormat("HH:mm:ss.SSS").format(date);
  }

  private static void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000); 
    } catch (InterruptedException error) {
      System.out.println(error);
      return;
    }
  }

  private static void printIteration(
      int barSize,
      int elementsCount,
      int estimatedTime,
      int processedElementsCount
  ) {
    int percentagesCount = (int) (processedElementsCount / (double) elementsCount * 100.0);
    System.out.print(percentagesCount + "% ");
    System.out.print("["); 
    System.out.print("=".repeat(barSize));
    System.out.print(">");
    System.out.print(" ".repeat(ProgressBar.barSize - barSize));
    System.out.print("]");
    System.out.print(" " + processedElementsCount + "/" + elementsCount);
    System.out.print(", ETA: " + ProgressBar.getTime(estimatedTime));
    System.out.print("\r");
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please, provide two or more arguments");
      return;
    }
    int elementsCount = 0;
    int[] delays = new int[args.length - 1];
    try {
      elementsCount = Integer.parseInt(args[0]);
      for (int i = 0; i < args.length - 1; i++) {
        delays[i] = Integer.parseInt(args[i + 1]);
      }
    }  catch (NumberFormatException error) {
      System.out.println("All arguments should be numbers");
      System.out.println(error);
      return;
    }

    final int delay = ProgressBar.getRandomDelay(delays);
    final int elementSize = ProgressBar.getElementSize(elementsCount);
    int estimatedTime = delay * elementsCount;

    for (int i = 0; i <= elementsCount; i++) {
      final int barSize = i == elementsCount ? ProgressBar.barSize : i * elementSize;
      ProgressBar.printIteration(barSize, elementsCount, estimatedTime, i);

      estimatedTime -= delay;
      ProgressBar.sleep(delay);
    }   
  }
}


