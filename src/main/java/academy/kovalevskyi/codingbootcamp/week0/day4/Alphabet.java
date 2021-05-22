package academy.kovalevskyi.codingbootcamp.week0.day4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Alphabet {
  public static char[] generateAlphabet1() {
    char[] alphabet = new char[26];
    int index = 0;

    for (char letter = 'a'; letter <= 'z'; letter++) {
      alphabet[index] = letter;
      index++;
    }

    return alphabet;
  }

  public static char[] generateReversedAlphabet() {
    char firstLetter = 'a';
    char lastLetter = 'z';
    int alphabetSize = lastLetter - firstLetter + 1;
    char[] alphabet = new char[alphabetSize];

    for (int i = 0; i < alphabetSize; i++) {
      alphabet[i] = (char) (lastLetter - i);
    }

    return alphabet;
  }


  public static char[] generateAlphabet() {
    return IntStream
      .rangeClosed('a', 'z')
      .mapToObj(letter -> "" +  (char) letter)
      .collect(Collectors.joining())
      .toCharArray();
  }
}
