import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null'. This class implements 'Polynomial' by
// using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme implements Polynomial {

    private int coeff;
    private Polynomial polynomial;

    // Initializes this object.
    // Precondition: p != null.
    public HornerScheme(int a, Polynomial p) {
        coeff = a;
        polynomial = p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        if (coeffs.length == 1) {
            return new Constant(coeffs[0]);
        }
        int[] remainingCoeffs = Arrays.copyOfRange(coeffs, 1, coeffs.length);
        return new HornerScheme(coeffs[0], create(remainingCoeffs));
    }

    @Override
    public int degree() {
        return 1 + polynomial.degree();
    }

    @Override
    public List<Integer> coefficients() {
        List<Integer> coeffs = List.of(coeff);
        coeffs.addAll(polynomial.coefficients());
        return coeffs;
    }

    @Override
    public double eval(double x) {
        return coeff + x * polynomial.eval(x);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private boolean outputThis = false;
            private Iterator<Integer> polynomialIterator = polynomial.iterator();

            @Override
            public boolean hasNext() {
                return !outputThis || polynomialIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no coefficient");
                }
                if (!outputThis) {
                    outputThis = true;
                    return coeff;
                }
                return polynomialIterator.next();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme integers = (HornerScheme) o;
        return coeff == integers.coeff && Objects.equals(polynomial, integers.polynomial);
    }

    @Override
    public int hashCode() {
        return coeff + polynomial.hashCode();
    }

    @Override
    public String toString() {
        if (polynomial.degree() > 0) {
            return String.format("%d + x*(%s)", coeff, polynomial);
        } else {
            return String.format("%d + x*%s", coeff, polynomial);
        }
    }
}



