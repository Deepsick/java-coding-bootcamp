package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {
  private int coordX;
  private int coordY;
        
  public Point(final int coordindateX, final int coordinateY) {
    this.coordX = coordindateX;
    this.coordY = coordinateY;
  }

  public int getX() {
    return this.coordX;
  }

  public int getY() {
    return this.coordY;
  }

  public Point sum(final Point that) {
    return new Point(this.getX() + that.getX(), this.getY() + that.getY());
  }

  public Point updateX(int newX) {
    return new Point(newX, this.getY());
  }

  public Point updateY(int newY) {
    return new Point(this.getX(), newY);
  }

  public int distanceTo(Point that) {
    int diffX = this.getX() - that.getX();
    int diffY = this.getY() - that.getY();
    return (int) (NumberUtils.power(diffX, 2) + NumberUtils.power(diffY, 2));
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Point that = (Point) o;
    if (this.getX() != that.getX() || this.getY() != that.getY()) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return this.getX() + this.getY();
  }

  @Override
  public String toString() {
    return "Point{X: " + this.getX() + ", Y: " + this.getY() + "}";  
  }

  @Override
  public int compareTo(Point that) {
    int thisSum = this.getX() + this.getY();
    int thatSum = that.getX() + that.getY();

    if (thisSum == thatSum) {
      return 0;
    }

    return thisSum - thatSum;
  }

}
