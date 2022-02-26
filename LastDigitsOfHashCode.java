/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */

public class LastDigitsOfHashCode implements Transformer<Object, 
       Integer> {
  private final int k;

  public LastDigitsOfHashCode(int kLastDigits) {
    this.k = kLastDigits;
  }

  @Override
  public Integer transform(Object input) {
    int hashCode = input.hashCode();
    int abs = Math.abs(hashCode);
    return abs % (int) Math.pow(10, this.k);
  }
}
