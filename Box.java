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
    return !boxObj.isPresent() || !this.isPresent()
        // Avoids `(null).equals` error, when either `content` is null
        ? boxObj.content == this.content
        : boxObj.content.equals(this.content);
  }

  @Override
  public String toString() {
    return !this.isPresent()
        ? "[]"
        : String.format("[%s]", this.content);
  }

  public static <T> Box<T> of(T obj) {
    return obj == null
        ? null
        : new Box<T>(obj);
  }

  public static <T> Box<T> empty() {
    // EMPTY_BOX's content is null, which is a subtype of everything.
    // So it's safe to cast any type to `T` in `Box<T>`.
    @SuppressWarnings("unchecked")
    Box<T> output = (Box<T>) Box.EMPTY_BOX;
    return output;
  }

  public static <T> Box<T> ofNullable(T obj) {
    return obj == null
        ? Box.empty()
        : Box.of(obj);
  }

  public boolean isPresent() {
    return this.content != null;
  }

  public Box<T> filter(BooleanCondition<? super T> predicate) {
    if (!this.isPresent()) {
      return Box.empty();
    }

    return predicate.test(this.content)
        ? this
        : Box.empty();
  }

  public <U> Box<U> map(Transformer<? super T, ? extends U> transformer) {
    if (!this.isPresent()) {
      return Box.empty();
    }

    return this.ofNullable(transformer.transform(this.content));
  }
}
