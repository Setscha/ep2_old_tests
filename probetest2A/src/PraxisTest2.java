import java.util.Iterator;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {


        System.out.println("Test 1:");
        Polynomial poly1 = new HornerScheme(8,new HornerScheme(-4, new Constant(10)));
        System.out.println(poly1); // (8 + x*(-4 + x*10))

        System.out.println("\nTest 2:");
        Polynomial poly2 = HornerScheme.create(new int[]{3,-2,0,7,5});

        System.out.println(poly2); // (3 + x*(-2 + x*(0 + x*(7 + x*5))))
        System.out.println(poly2.eval(3.1)); // 667.0975

        System.out.println("\nTest 3:");
        Polynomial poly3 = new HornerScheme(8,new HornerScheme(-4, new Constant(10)));
        System.out.println(poly1.equals(poly3)); // true
        System.out.println(poly2.equals(HornerScheme.create(new int[]{3,-2,0,7,5}))); // true
        System.out.println(poly2.equals(HornerScheme.create(new int[]{3,-2,0,7}))); // false

        System.out.println("\nTest 4:");
        for(Integer i: poly2) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 3 -2 0 7 5

        System.out.println("\nTest 5:");
        poly2 = HornerScheme.create(new int[]{10});
        System.out.println(poly2); // 10

        Iterator<Integer> iter = poly2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        // 10

        try {
            System.out.println(iter.next());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        // no coefficient!

        System.out.println("\nTest 6:");
        Polynomial poly4 = HornerScheme.create(new int[] {2, 5, 6, 9, 1});
        System.out.println(poly4);
        System.out.println(poly4.eval(21.23));
        System.out.println(poly4.degree());

        /*

        Test 1:
        (8 + x*(-4 + x*10))

        Test 2:
        (3 + x*(-2 + x*(0 + x*(7 + x*5))))
        667.0975

        Test 3:
        true
        true
        false

        Test 4:
        3 -2 0 7 5

        Test 5:
        10
        10
        no coefficient!

         */

    }
}

