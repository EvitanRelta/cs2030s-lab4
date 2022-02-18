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
    return !boxObj.isPresent() || !isPresent()
        ? boxObj.content == content
        : boxObj.content.equals(content);
  }

  @Override
  public String toString() {
    return !isPresent()
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
    // EMPTY_BOX's content is null, which is a subtype of everything.
    // So it's safe to cast any type to `T` in `Box<T>`.
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

  public Box<T> filter(BooleanCondition<? super T> predicate) {
    if (!isPresent()) {
      return empty();
    }

    return predicate.test(content)
        ? this
        : empty();
  }

  public <U> Box<U> map(Transformer<? super T, U> transformer) {
    if (!isPresent()) {
      return empty();
    }

    return new Box<U>(transformer.transform(content));
  }
}
