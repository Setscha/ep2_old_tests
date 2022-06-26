import java.util.NoSuchElementException;
import java.util.Objects;

public class BalancedSystem implements Cluster {

    private Cluster left, right;

    //the constructor should throw a BalancedSystemIllegalArgumentException (to be implemented), if one of the arguments is null
    BalancedSystem(Cluster left, Cluster right) throws BalancedSystemIllegalArgumentException {
        if (left == null || right == null) {
            throw new BalancedSystemIllegalArgumentException("Right and left cluster must each not be null");
        }
        this.left = left;
        this.right = right;
    }

    @Override
    //adds a Body b to the BalancedSystem. If the mass of the left cluster is less than the mass of the right cluster,
    //the body is added to the left cluster, otherwise to the right cluster.
    //Returns this after the operation
    public Cluster add(Body b) throws BalancedSystemIllegalArgumentException {
        if (left.getMass() < right.getMass()) {
            left = left.add(b);
        } else {
            right = right.add(b);
        }
        return this;
    }

    private boolean remove(Body b) {
        // if body is direct child of this
        if (Objects.equals(left, b)) {
            left = null;
            return true;
        }
        if (Objects.equals(right, b)) {
            right = null;
            return true;
        }
        boolean removed = false;
        if (left instanceof BalancedSystem) {
            removed = ((BalancedSystem) left).remove(b);
        }
        if (!removed && right instanceof BalancedSystem) {
            removed = ((BalancedSystem) right).remove(b);
        }
        return removed;
    }

    @Override
    //returns overall number of bodies in the cluster (and its sub-clusters)
    public int numberOfBodies() {
        int numLeft = left == null ? 0 : left.numberOfBodies();
        int numRight = right == null ? 0 : right.numberOfBodies();
        return numLeft + numRight;
    }

    @Override
    //returns the summed mass of all the bodies in the cluster (ans its sub-clusters)
    public double getMass() {
        double weightLeft = left == null ? 0 : left.getMass();
        double weightRight = right == null ? 0 : right.getMass();
        return weightLeft + weightRight;
    }

    @Override
    //returns an iterator over all bodies
    public BodyIterator iterator() {
        return new BodyIterator() {

            BodyIterator leftIter = left.iterator();
            BodyIterator rightIter = right.iterator();

            Body last = null;

            @Override
            public boolean hasNext() {
                return leftIter.hasNext() || rightIter.hasNext();
            }

            @Override
            public Body next() throws NoSuchElementException {
                Body current;
                if (leftIter.hasNext()) {
                    current = leftIter.next();
                } else if (rightIter.hasNext()) {
                    current = rightIter.next();
                } else {
                    throw new NoSuchElementException("No Bodies found");
                }
                last = current;
                return current;
            }

            @Override
            public void remove() throws IllegalStateException {
                if (last == null) {
                    throw new IllegalStateException("No recently output Body");
                }
                BalancedSystem.this.remove(last);
                last = null;
            }
        };
    }

    @Override
    //returns a String indicating the masses of the left and right subsystem
    //E.g., "Left mass: 10.0, right mass: 12.0
    public String toString() {
        return String.format("Left mass: %f, right mass: %f", left.getMass(), right.getMass());
    }
}
