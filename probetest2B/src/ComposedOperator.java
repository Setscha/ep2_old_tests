import java.util.*;

// This class implements 'StringOperator' and represents a composition of two 'StringOperator'
// objects that are applied in succession (both can be 'ComposedOperator' objects themselves).
// Calling this object's 'apply' method returns the result of applying the second 'StringOperator'
// on the result of applying the first one on the specified string.
// 'ComposedOperator' objects can be build using the 'andThen' method specified in the
// interface 'StringOperator'.
//
public class ComposedOperator implements StringOperator
{

    private StringOperator current;
    private StringOperator next;

    public ComposedOperator(StringOperator current, StringOperator next) {
        this.current = current;
        this.next = next;
    }

    // Returns an iterator over all basic operators which
    // this operator is composed of.
    // See examples in 'PraxisTest2.java'.
    public BasicOperatorIterator iterator() {
        return new BasicOperatorIterator() {
            private BasicOperatorIterator currentIter = current.iterator(), nextIter = next.iterator();

            @Override
            public BasicOperator next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("NO EL");
                }
                if (currentIter.hasNext()) {
                    return currentIter.next();
                }
                return nextIter.next();
            }

            @Override
            public boolean hasNext() {
                return currentIter.hasNext() || nextIter.hasNext();
            }
        };
    }

    @Override
    public String apply(String operand) {
        return next.apply(current.apply(operand));
    }

    @Override
    public StringOperator andThen(StringOperator after) {
        return new ComposedOperator(this, after);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposedOperator that = (ComposedOperator) o;
        List<BasicOperator> thisOps = new LinkedList<>();
        for (BasicOperator bo : this) {
            thisOps.add(bo);
        }
        Iterator<BasicOperator> thisOpsIter = thisOps.iterator();
        for (BasicOperator bo : that) {
            if (!thisOpsIter.hasNext() || !thisOpsIter.next().equals(bo)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, next);
    }

    @Override
    public String toString() {
        return current + " and then " + next;
    }
}
