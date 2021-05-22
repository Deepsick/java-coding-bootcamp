package academy.kovalevskyi.codingbootcamp.week2.day1;

import java.util.IllegalFormatException;

public class BoxGenerator {

  private static String buildSide(String corner, String side, int width) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < width; i++) {
      if (i == 0 || i == width - 1) {
        builder.append(corner);
        continue;
      }
      builder.append(side);
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("Please provide 4 input arguments, current amount: " + args.length);
      return;
    }
    try {
      int width = Integer.parseInt(args[0]);
      int length = Integer.parseInt(args[1]);
      if (width < 0 || length < 0) {
        throw new IllegalArgumentException();
      }
      if (width == 0) {
        System.out.print("");
        return;
      }
      String side = args[2];
      String corner = args[3];
      if (side.length() > 1 || corner.length() > 1) {
        throw new IllegalArgumentException();
      } 
      String fullSide = BoxGenerator.buildSide(corner, side, width);
      for (int i = 0; i < length; i++) {
        if (i == 0 || i == length - 1) {
          System.out.println(fullSide);
          continue;
        }
        System.out.println(BoxGenerator.buildSide(side, " ", width));
      }
    } catch (IllegalFormatException error) {
      throw new IllegalArgumentException();
    }
    
  }
}
