package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;
import java.lang.StringBuilder;

public class StringUtils {
  public static boolean isAscii(final char ch) {
    return ch >= 0 && ch <= 127;
  }

  public static boolean isAsciiUppercase(final char ch) {
    if (!isAscii(ch)) {
      throw new IllegalArgumentException();
    }
          
    if (ch >= 65 && ch <= 90) {
      return true;
    }

    return false;
  }

  public static boolean isAsciiLowercase(final char ch) {
    if (!isAscii(ch)) {
      throw new IllegalArgumentException("only ascii symbols are allowed");
    }

    if (ch >= 97 && ch <= 122) {
      return true;
    }

    return false;
  }

  public static boolean isAsciiNumeric(final char ch) {
    if (!isAscii(ch)) {
      throw new IllegalArgumentException("only ASCII symbols are allowed");
    }

    if (ch >= 48 && ch <= 57) {
      return true;
    }

    return false;
  }

  public static boolean isAsciiAlphabetic(final char ch) {
    return isAsciiUppercase(ch) || isAsciiLowercase(ch);
  }

  public static StringBuilder makeUppercase(final char[] input) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      final char current = input[i];
      if (!isAscii(current)) {
        throw new IllegalArgumentException();
      }
      if (isAsciiLowercase(current)) {
        builder.append((char) (current - 32));
        continue;
      }
      builder.append(current);
    }

    return builder;
  }

  public static char toAsciiUppercase(final char ch) {
    if (!isAscii(ch)) {
      throw new IllegalArgumentException();
    }
    
    if (isAsciiLowercase(ch)) {
      return (char) (ch - 32);
    }

    return ch;
  }

  public static char toAsciiLowercase(final char ch) {
    if (!isAscii(ch)) {
      throw new IllegalArgumentException();
    }

    if (isAsciiUppercase(ch)) {
      return (char) (ch + 32);
    }

    return ch;
  }

  public static StringBuilder makeLowercase(final char[] input) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      char current = input[i];
      if (!isAscii(current)) {
        throw new IllegalArgumentException();
      }

      if (isAsciiUppercase(current)) {
        builder.append((char) (current + 32));
        continue;
      }
      builder.append(current);
    }

    return builder;
  }

  public static StringBuilder makeCamel(final char[] input) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      char current = input[i];
      if (!isAscii(current)) {
        throw new IllegalArgumentException();
      }
      if (i % 2 != 0) {
        if (isAsciiLowercase(current)) {
          builder.append((char) (current - 32));
          continue;
        }

        builder.append(current);
        continue;
      }
      
      if (isAsciiUppercase(current)) {
        builder.append((char) (current + 32));
      } else {
        builder.append(current);
      }
    }

    return builder; 
  }

  public static boolean isAsciiSpace(final char ch) {
    return ch == 32;
  }

  public static boolean isStringAlphaNumerical(final char[] input) {
    for (int i = 0; i < input.length; i++) {
      char current = input[i];
      if (!isAscii(current)) {
        throw new IllegalArgumentException();
      }

      if (!isAsciiNumeric(current) && !isAsciiAlphabetic(current) && !isAsciiSpace(current)) {
        return false;
      }
    }

    return true;
  }  

  public static char[] concatStrings(final char[][] input) {
    int length = 0;
    for (int i = 0; i < input.length; i++) {
      length += input[i] != null ? input[i].length : 0;
    }
    final char[] chars = new char[length];
    int index = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] == null) {
        throw new NullPointerException();
      }
      if (input[i].length == 0) {
        continue;
      }
      for (int j = 0; j < input[i].length; j++) {
        char current = input[i][j];
        if (!isAscii(current)) {
          throw new IllegalArgumentException();
        }
        chars[index] = current;
        index++;
      }
    }

    return chars;
  }

  public static int toInt(final char[] input) {
    if (input.length == 0) {
      throw new IllegalArgumentException("Input array can't be empty");
    }

    boolean isNegative = false;
    int result = 0;
    for (int i = 0; i < input.length; i++) {
      char current = input[i];
      if (!isAscii(current)) {
        throw new IllegalArgumentException();
      }

      if (isAsciiAlphabetic(current)) {
        throw new NumberFormatException("chars should be numeric");
      }
      
      if (current == '-') {
        if (i != 0) {
          throw new NumberFormatException("Minus can be used only for the first symbol");
        }
        isNegative = true;
        continue;
      }

      final int digit = current - '0';
      result *= 10;
      result += digit;
    }

    return isNegative ? -result : result;
  }
}
