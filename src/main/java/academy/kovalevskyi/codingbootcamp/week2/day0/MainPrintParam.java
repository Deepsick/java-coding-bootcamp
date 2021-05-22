package academy.kovalevskyi.codingbootcamp.week2.day0;

public class MainPrintParam {
  public static void main(String... args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
      return;
    }

    for (String arg : args) {
      System.out.println(arg); 
    }
  }
}
