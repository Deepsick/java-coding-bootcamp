package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter {
  public static String buildBoxSide(String left, String right, String side, int width) {
    StringBuilder builder = new StringBuilder();
    builder.append(left);
    for (int i = 0; i < width - 2; i++) {
      builder.append(side);
    }
    builder.append(right);

    return builder.toString();  
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Please provide only one input argument, current amount: " + args.length);
      return;
    }
    String text = args[0];
    int width = text.length() + 4;
    String topSide = TextPrinter.buildBoxSide("/", "\\", "#", width);
    System.out.println(topSide);
    System.out.println("# " + text + " #");
    String bottomSide = TextPrinter.buildBoxSide("\\", "/", "#", width);
    System.out.println(bottomSide);
  }
}
