import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// 'Constant' implements 'Polynomial' and is used by class 'HornerScheme' to represent a polynomial
// with degree 0. Its value is a*x⁰ = a (regardless of the 'x' used for evaluation).
// The iterator of this class iterates over only one value and therefore behaves as follows:
// The 'next' method returns the value of 'this' (specified by 'a'), if it is called for the first
// time. 'hasNext' is 'true' only if 'next' has not been called.
//
public class Constant implements Polynomial {

    private int constant;

    // Initializes this object.
    // Precondition: a != 0.
    public Constant(int a) {
        constant = a;
    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public List<Integer> coefficients() {
        return List.of(constant);
    }

    @Override
    public double eval(double x) {
        return constant;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no coefficient");
                }
                hasNext = false;
                return constant;
            }
        };
    }

    @Override
    public int hashCode() {
        return constant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant integers = (Constant) o;
        return constant == integers.constant;
    }

    @Override
    public String toString() {
        return "" + constant;
    }
}


