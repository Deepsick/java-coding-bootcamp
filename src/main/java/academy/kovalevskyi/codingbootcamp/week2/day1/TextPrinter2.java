package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week2.day1.TextPrinter;

public class TextPrinter2 {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Please provide 2 input argument, current amount: " + args.length);
      return;
    }

    String symbol = args[0];
    String text = args[1];
    int width = text.length() + 4;
    System.out.println(TextPrinter.buildBoxSide(symbol, symbol, symbol, width));
    System.out.println(symbol + " " + text + " " + symbol);
    System.out.println(TextPrinter.buildBoxSide(symbol, symbol, symbol, width));
  }
}
