package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.lang.IndexOutOfBoundsException;
import java.lang.String;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {
  private final char[] chars;

  public StdString1(final char[] base) {
    this.chars = new char[base.length];

    for (int i = 0; i < base.length; i++) {
      this.chars[i] = base[i];
    }    
  }

  public StdString1() {
    this.chars = new char[0];
  }

  public StdString1(final StdString1 stdString1) {
    int length = stdString1.length();
    this.chars = new char[length];

    for (int i = 0; i < length; i++) {
      this.chars[i] = stdString1.toCharArray()[i];
    }
  }

  public int length() {
    return this.chars.length;
  }

  public StdString1 append(StdString1 that) {
    if (that == null) {
      throw new NullPointerException("Argument can't be null");
    }
    
    final int newLength = that.length() + this.length();
    final char[] newString = new char[newLength];
    for (int i = 0; i < this.length(); i++) {
      newString[i] = this.toCharArray()[i];
    }

    for (int j = 0; j < that.length(); j++) {
      newString[j + this.length()] = that.toCharArray()[j];
    }

    return new StdString1(newString);
  }

  public char[] toCharArray() {
    return this.chars;
  }

  public char charAt(int index) {
    if (index >= this.length() || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    return this.toCharArray()[index];
  }

  public int indexOf(char target) {
    for (int i = 0; i < this.length(); i++) {
      if (this.toCharArray()[i] == target) {
        return i;
      }
    }

    return -1;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
          
    if (o == null) {
      return false;
    }

    if (o.getClass() != this.getClass()) {
      return false;
    }

    final StdString1 that = (StdString1) o;
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
  
  @Override
  public int hashCode() {
    if (this.length() == 0) {
      return 0;
    }
    
    int sum = 0;
    for (char letter : this.toCharArray()) {
      sum += (int) letter;
    }

    return sum;
  }
  
  @Override
  public String toString() {
    return new String(this.toCharArray());
  }
  
  @Override
  public Iterator<Character> iterator() {
    return new Iterator<Character>() {
        private int index = 0;
            
        @Override
        public boolean hasNext() {
          return index < length();
        }

        @Override
        public Character next() {
          return Character.valueOf(toCharArray()[index++]);
        }

        @Override
        public void remove() {
          throw new UnsupportedOperationException();
        }
    };
  }

  @Override
  public void forEach(final Consumer<? super Character> action) {
    for (Character letter : this) {
      action.accept(letter);
    }
  }
}
