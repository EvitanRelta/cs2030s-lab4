/**
 * Takes an item and return the item in a box.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */

public class BoxIt<T> implements Transformer<T, Box<T>> {
  @Override
  public Box<T> transform(T input) {
    return Box.of(input);
  }
}
