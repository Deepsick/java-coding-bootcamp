package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;
import java.util.function.Function;

public class PointWithValue<T> extends Point {
  final T value;
        
  public PointWithValue(final int coordinateX, final int coordinateY, final T value) {
    super(coordinateX, coordinateY);
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
    return new PointWithValue<R>(this.getX(), this.getY(), mapFunction.apply(this.getValue()));
  }
  
  @Override
  public String toString() {
    return "PointWithValue{ X: " 
            + this.getX() + ", Y: " 
            + this.getY() + ", value: " 
            + this.getValue() + "}";
  }
}
