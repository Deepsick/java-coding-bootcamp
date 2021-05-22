package academy.kovalevskyi.codingbootcamp.week2.day0;

public class Calculator {
  private static long[] parseNumbers(String a, String b) {
    final long[] numbers = new long[2];
    try {
      numbers[0] = Long.parseLong(a);
      numbers[1] = Long.parseLong(b);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }

    return numbers;
  }

  public static void main(String[] args) {
    if (args.length != 3) {          
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
      return;
    }
    String number1 = args[0];
    String number2 = args[2];
    long[] numbers = Calculator.parseNumbers(number1, number2);
    String operator = args[1];
      
    long result = 0;
    long a = numbers[0];
    long b = numbers[1];
    switch (operator) {
      case "+":
        result = a + b;
        break;
      case "-":
        result = a - b;
        break;
      case "*":
        result = a * b;
        break;
      case "/":
        if (b == 0) {
          System.out.println("Division by zero is impossible!");
          return;
        }
        result = a / b;
        break;
      case "%":
        if (b == 0) {
          System.out.println("Division by zero is impossible!");
          return;
        }
        result = a % b;
        break;
      default:
        throw new IllegalArgumentException("Incorrect operator");
    }
      
    System.out.println("result: " + result);
  }
}
