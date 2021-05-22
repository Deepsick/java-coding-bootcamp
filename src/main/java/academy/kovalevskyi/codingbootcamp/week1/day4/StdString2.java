package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {
  public StdString2(char[] base) {
    super(base);
  }

  public StdString2() {
    super();
  }

  public StdString2(StdString2 that) {
    super(that);
  }

  public StdString2 toAsciiLowerCase() {
    final char[] newChars = new char[this.length()];
    for (int i = 0; i < this.length(); i++) {
      final char letter = this.toCharArray()[i];
      if (!StringUtils.isAscii(letter)) {
        throw new IllegalArgumentException();
      }

      newChars[i] = StringUtils.toAsciiLowercase(letter);
    }

    return new StdString2(newChars);
  }

  public StdString2 toAsciiUpperCase() {
    final char[] newChars = new char[this.length()];
    for (int i = 0; i < this.length(); i++) {
      final char letter = this.toCharArray()[i];
      if (!StringUtils.isAscii(letter)) {
        throw new IllegalArgumentException();
      }

      newChars[i] = StringUtils.toAsciiUppercase(letter);
    }

    return new StdString2(newChars);
  }

  public StdString2 subString(int from, int to) {
    if (from >= to) {
      throw new IllegalArgumentException();
    }
    if (to > this.length() || from < 0) {
      throw new IndexOutOfBoundsException();
    }
    char[] subSequence = new char[to - from];
    for (int i = 0; i < subSequence.length; i++) {
      subSequence[i] = this.toCharArray()[i + from];
    }

    return new StdString2(subSequence);
  }
  
  public StdString2 concat(StdString2... that) {
    if (that == null) {
      throw new NullPointerException();
    }
    if (that.length == 0) {
      return this;
    }

    char[][] chars = new char[that.length + 1][];
    chars[0] = this.toCharArray();
    for (int i = 0; i < that.length; i++) {
      chars[i + 1] = that[i].toCharArray();
    }

    return new StdString2(StringUtils.concatStrings(chars));
  }

  public StdString2 trim() {
    int length = this.length();
    if (length == 0) {
      return this;
    }

    int startIndex = 0;
    while (this.toCharArray()[startIndex] == ' ') {
      length -= 1;
      startIndex++;
    }
    int endIndex = this.length() - 1;
    while (this.toCharArray()[endIndex] == ' ') {
      length -= 1;
      endIndex--;
    }

    char[] trimmed = new char[length];
    for (int i = 0; i < trimmed.length; i++) {
      trimmed[i] = this.toCharArray()[i + startIndex];
    }

    return new StdString2(trimmed);
  }

  public StdString2[] split(char separator) {
    int last = this.length() - 1;
    while (this.toCharArray()[last] == separator) {
      last--;
    }

    int count = 1;
    for (int j = 0; j <= last; j++) {
      if (this.toCharArray()[j] == separator) {
        count++;
      }
    }

    int start = 0;
    StdString2[] result = new StdString2[count];
    int index = 0;
    for (int i = 0; i <= last; i++) {
      if (this.toCharArray()[i] == separator) {
        StdString2 subString = i == start ? new StdString2() : this.subString(start, i);
        result[index] = subString;
        index++;
        start = i + 1;
      }
      if (i == last) {
        StdString2 subString = this.subString(start, i + 1);
        result[index] = subString;
      }
    }

    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o == null) {
      return false;
    }

    if (o.getClass() != this.getClass()) {
      return false;
    }
    
    StdString2 that = (StdString2) o;
    if (that.length() != this.length()) {
      return false;
    }

    for (int i = 0; i < this.length(); i++) {
      if (this.toCharArray()[i] != that.toCharArray()[i]) {
        return false;
      }
    }

    return true;
  }

  public StdString2 removeCharacter(char toRemove) {
    int count = 0;
    for (int i = 0; i < this.length(); i++) {
      if (this.toCharArray()[i] == toRemove) {
        count++;
      }
    }

    char[] newChars = new char[this.length() - count];
    int index = 0;
    for (int j = 0; j < this.length(); j++) {
      if (this.toCharArray()[j] == toRemove) {
        continue;
      }

      newChars[index] = this.toCharArray()[j];
      index++;
    } 

    return new StdString2(newChars);

  }
}
