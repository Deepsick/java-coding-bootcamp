package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;
import academy.kovalevskyi.codingbootcamp.week1.day1.PointWithValue;

public class PointWithLabel extends PointWithValue<String> {
  public PointWithLabel(final int coordX, final int coordY, final String label) {
    super(coordX, coordY, label);
  }

  public String getLabel() {
    return this.value;
  }

  public int compareTo(final Point point) {
    if (this.getClass() != point.getClass()) {
      return super.compareTo(point);
    }
    PointWithLabel that = (PointWithLabel) point;
    return this.getLabel().compareTo(that.getLabel()); 
  }
}
