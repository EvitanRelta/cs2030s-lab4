/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */

public class Box<T> {
  private final T content;

  private Box(T content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Box<?>)) {
      return false;
    }

    Box<?> boxObj = (Box<?>) obj;
    return boxObj.content.equals(content);
  }

  @Override
  public String toString() {
    return String.format("[%s]", content);
  }

  public static <T> Box<T> of(T obj) {
    if (obj == null) {
      return null;
    }
    return new Box<T>(obj);
  }
}
