package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {
  T value;
  ListNode<T> prev;
  ListNode<T> next;

  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }

  public void setPrev(ListNode<T> prev) {
    this.prev = prev;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  public ListNode<T> getNext() {
    return this.next;
  }

  public ListNode<T> getPrev() {
    return this.prev;
  }

  public T getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    String prevValue = this.prev != null ? this.prev.value.toString() : "null";
    String nextValue = this.next != null ? this.next.value.toString() : "null";
    return "Node{prevValue=" + prevValue
            + ", nextValue=" + nextValue
            + ", thisValue=" + this.value + "}";
  }
}
