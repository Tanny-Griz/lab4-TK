package week_4;

import org.junit.After;
import org.junit.Test;
import test_utils.ArrayListUtils;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import static test_utils.ArrayListUtils.newArrayList;

public class Question_2_Dice_RollTest {


    class DeterministicDice extends Random {

        List<Integer> values;

        DeterministicDice(List<Integer> values) {
            this.values = values;
        }

        DeterministicDice() {
            // an dice that should not be rolled
        }

        public int nextInt(int upperLimit) {

            if (values == null) {
                // don't want to generate any random numbers. fail the test.
                fail("Do not generate any random numbers.");
            }

            else if (upperLimit != 6) {
                fail("Make sure you generate the correct range of random numbers. " +
                        "\nHow many random numbers should a dice create?");
            }

            else {
                try {
                    return values.remove(0);
                } catch (Exception e) {
                    // fail test if the list runs out of values
                    // or in other words, nextInt is called more than the expected number of times
                    fail("Generate one random number for each dice. If you have 5 dice, you'll need to \n" +
                            "call nextInt exactly 5 times. Don't generate any other random numbers.");
                }
            }

            throw new RuntimeException("Something weird happened. Please push your code to GitHub and report this error to Clara. Thanks!");
        }
    }

    @After
    public void replaceRnd() {
        // Replace te program's random number generator with a real random number generator
        Question_2_Dice_Roll.rnd = new Random();
    }


    @Test(timeout=3000)
    public void testRoll() {

        List<Integer> diceRolls = ArrayListUtils.newArrayList(3, 4, 2, 5);
        DeterministicDice mockRandom = new DeterministicDice(diceRolls);

        // Replace the program's random number generator with the mock
        Question_2_Dice_Roll.rnd = mockRandom;

        // So now, when your program calls nextInt, it will call the mock version defined here.

        List<Integer> expected = newArrayList(4, 5, 3, 6);

        List<Integer> actual = Question_2_Dice_Roll.roll(4);

        assertTrue("Use the Random rnd variable provided in the program. Don't create a new Random object. " +
                        "\nRoll the given number of dice, store each number in an ArrayList, and return this ArrayList. ",
                ArrayListUtils.arrayListEqual(expected, actual, true));

    }

    @Test(timeout=3000)
    public void testRollZeroDice() {

        DeterministicDice dontRollThis = new DeterministicDice();
        Question_2_Dice_Roll.rnd = dontRollThis;   // fails the test if any random numbers are generated.

        List<Integer> actualEmpty = Question_2_Dice_Roll.roll(0);
        assertEquals("If the user rolls 0 dice, return an empty ArrayList. You should not generate any random numbers",
                0, actualEmpty.size());


    }


    @Test(timeout=3000)
    public void testRollNegativeDice() {

        List<Integer> actualEmpty = Question_2_Dice_Roll.roll(-10);
        assertEquals("If the user rolls -10 dice, return an empty ArrayList. You should not generate any random numbers",
                0, actualEmpty.size());

        actualEmpty = Question_2_Dice_Roll.roll(-1);
        assertEquals("If the user rolls -1 dice, return an empty ArrayList. You should not generate any random numbers",
                0, actualEmpty.size());

        actualEmpty = Question_2_Dice_Roll.roll(-100000000);
        assertEquals("If the user rolls -100000000 dice, return an empty ArrayList. You should not generate any random numbers",
                0, actualEmpty.size());

    }
}