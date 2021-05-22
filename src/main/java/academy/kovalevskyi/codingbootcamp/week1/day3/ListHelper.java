package academy.kovalevskyi.codingbootcamp.week1.day3;

import academy.kovalevskyi.codingbootcamp.week1.day3.ListNode;
import java.lang.NullPointerException;
import java.util.function.Function;

public class ListHelper {
  public static <T> int length(ListNode<T> node) {
    if (node == null) {
      throw new NullPointerException();
    }
    
    int length = 1;
    ListNode<T> currentNext = node.next;
    while (currentNext != null) {
      length += 1;
      currentNext = currentNext.next;
    }

    ListNode<T> prevCurrent = node.prev;
    while (prevCurrent != null) {
      length += 1;
      prevCurrent = prevCurrent.prev;
    }

    return length;
  }

  public static <T> ListNode<T> createOne(T value) {
    return new ListNode<T>(null, null, value);
  }

  public static <T> ListNode<T> addToEnd(ListNode<T> node, T newValue) {
    if (node.next == null) {
      node.next = new ListNode<T>(node, null, newValue);
      return node.next;
    }

    return addToEnd(node.next, newValue);
  }

  public static <T> ListNode<T> addToStart(ListNode<T> node, T newValue) {
    if (node.prev == null) {
      node.prev = new ListNode<T>(null, node, newValue);
      return node.prev;
    }

    return addToStart(node.prev, newValue);
  }

  public static <T> boolean contains(ListNode<T> node, T value) {
    if (node == null) {
      throw new NullPointerException();
    }
    if (node.value.equals(value)) {
      return true;
    }
    
    ListNode<T> currentNext = node.next;
    while (currentNext != null) {
      if (currentNext.value.equals(value)) {
        return true;
      }
      currentNext = currentNext.next;
    }
    ListNode<T> currentPrev = node.prev;
    while (currentPrev != null) {
      if (currentPrev.value.equals(value)) {
        return true;
      }
      currentPrev = currentPrev.prev;
    }

    return false;
  }

  public static <T, R> ListNode<R> map(ListNode<T> node, Function<T, R> mapFunction) {
    if (node == null) {
      throw new NullPointerException();
    }

    ListNode<T> last = node;
    while (last.next != null) {
      last = last.next;
    }
    
    ListNode<T> current = last;
    ListNode<R> next = null;
    int index = 0;
    while (current != null) {
      index++;
      ListNode<R> newNode = new ListNode<R>(null, next, mapFunction.apply(current.value));
      if (next != null) {
        next.prev = newNode;
      }
      next = newNode;
      current = current.prev;
    }
    return next;
  }

  public static <T> void connect(ListNode<T> node, ListNode<T> to) {
    node.next = to;
    to.prev = node;
  }

  public static <T> ListNode<T> insertAfter(ListNode<T> node, T newValue) {
    ListNode<T> newNode = new ListNode<T>(node, node.next, newValue);
    if (node.next != null) {
      node.next.prev = newNode;
    }
    node.next = newNode;
    return newNode;
  }

  public static <T> void insertAfter(ListNode<T> node, T[] newValues) {
    ListNode<T> current = node;
    for (T value : newValues) {
      current = insertAfter(current, value); 
    }
  }

  public static <T> Object delete(ListNode<T> current) {
    if (current.prev == null && current.next == null) {
      return "single node";
    }
    if (current.prev != null) {
      current.prev.next = current.next;
      current.prev = null;
    } 
    if (current.next != null) {
      current.next.prev = current.prev;
      current.next = null;
    }

    return (Integer) current.value;
  }
}
