/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */

public class Box<T> {
  private final T content;
  private static final Box<?> EMPTY_BOX = new Box<>(null);

  private Box(T content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Box<?>)) {
      return false;
    }

    Box<?> boxObj = (Box<?>) obj;
    return boxObj.content == null || content == null
        ? boxObj.content == content
        : boxObj.content.equals(content);
  }

  @Override
  public String toString() {
    return content == null
        ? "[]"
        : String.format("[%s]", content);
  }

  public static <T> Box<T> of(T obj) {
    if (obj == null) {
      return null;
    }
    return new Box<T>(obj);
  }

  public static <T> Box<T> empty() {
    @SuppressWarnings("unchecked")
    Box<T> output = (Box<T>) EMPTY_BOX;
    return output;
  }

  public static <T> Box<T> ofNullable(T obj) {
    if (obj == null) {
      return empty();
    }
    return of(obj);
  }

  public boolean isPresent() {
    return content != null;
  }
}
