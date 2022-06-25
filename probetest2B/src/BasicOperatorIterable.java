// Iterable objects with 'BasicOperator' elements.
//
public interface BasicOperatorIterable extends Iterable<BasicOperator> {

    @Override
    // Returns an iterator over elements of 'BasicOperator'.
    BasicOperatorIterator iterator();

}
