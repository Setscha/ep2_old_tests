// A single basic operation, that can not be decomposed into components.
//
public interface BasicOperator extends StringOperator {

    // The iterator of this class iterates over only one element and therefore behaves as follows:
    // The 'next' method returns 'this', if it is called for the first time.
    // 'hasNext' is 'true' only if 'next' has not been called.
    // See examples in 'PraxisTest2.java'.
    BasicOperatorIterator iterator();

}
