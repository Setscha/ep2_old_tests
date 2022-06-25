// Do not change this interface definition.
//
// Classes that implement this interface represent operations on a string with a string as result.
// Possible additional parameters can be specified by passing them to the constructor.
//
// See examples in class 'PraxisTest2'.
//
public interface StringOperator extends BasicOperatorIterable {

    // Applies this operator to the given operand.
    String apply(String operand);

    // Returns a composed operator that first applies this operator to its input, and then applies
    // the 'after' operator to the result.
    // Precondition: 'after' must not be 'null'.
    StringOperator andThen(StringOperator after);

    // Returns 'true' if 'this' and 'o' apply the same basic operators in the same order.
    boolean equals(Object o);

    // Returns the hashCode of this object.
    int hashCode();

    // Returns a string representation with all additional parameters of the Operator.
    // If 'this' is a composed operator the representation of the operators are separated by "and then".
    // Examples:
    // "replace 't' with 'T'",
    // "replace 't' with 'T' and then replace 'x' with 'X'" .
    // See further examples in 'PraxisTest2'.
    String toString();

}

