import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {


        System.out.println("Test 1:");
        StringOperator singleRep = new ReplaceOperator('t','T');
        System.out.println(singleRep);
        System.out.println(singleRep.apply("This is just a test!"));

        System.out.println("\nTest 2:");
        StringOperator rep1 = new ReplaceOperator('a', 'A');
        for (int i = 1; i < 3; i++) {
            rep1 = rep1.andThen(new ReplaceOperator((char) ('a'+i), (char)('A'+i)));
        }
        System.out.println(rep1);
        System.out.println(rep1.apply("This is epic!"));

        System.out.println("\nTest 3:");
        StringOperator rep2 = new ReplaceOperator((char) ('a'+3), (char)('A'+3));
        for (int i = 4; i < 26; i++) {
            rep2 = rep2.andThen(new ReplaceOperator((char) ('a'+i), (char)('A'+i)));
        }

        System.out.println(rep1.andThen(rep2).apply("Yet another test!"));

        System.out.println("\nTest 4:");
        rep2 = new ReplaceOperator('a','A')
                    .andThen(new ReplaceOperator('b','B'))
                    .andThen(new ReplaceOperator('B','.'))
                    .andThen(new ReplaceOperator('.','*'));
        StringOperator rep2clone = new ReplaceOperator('a','A')
                .andThen(new ReplaceOperator('b','B')
                .andThen(new ReplaceOperator('B','.')))
                .andThen(new ReplaceOperator('.','*'));
        System.out.println(rep2.apply("a better test!"));
        System.out.println(rep2clone.apply("a better test!"));
        System.out.println(rep2.equals(rep2clone));
        System.out.println(rep2.equals(rep2clone.andThen(new ReplaceOperator('t','T'))));

        System.out.println("\nTest 5:");
        BasicOperatorIterator iter = singleRep.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 6:");
        for(StringOperator op: rep1) {
            System.out.println(op);
        }


        /*
        Test 1:
        replace 't' with 'T'
        This is jusT a TesT!

        Test 2:
        replace 'a' with 'A' and then replace 'b' with 'B' and then replace 'c' with 'C'
        This is epiC!

        Test 3:
        YET ANOTHER TEST!

        Test 4:
        A *etter test!
        A *etter test!
        true
        false

        Test 5:
        replace 't' with 'T'
        no operator!

        Test 6:
        replace 'a' with 'A'
        replace 'b' with 'B'
        replace 'c' with 'C'
        */

    }
}

