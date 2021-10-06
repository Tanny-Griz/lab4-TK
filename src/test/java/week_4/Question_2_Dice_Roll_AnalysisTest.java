package week_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static test_utils.ArrayListUtils.newArrayList;

public class Question_2_Dice_Roll_AnalysisTest {

    @Test(timeout=3000)
    public void testDiceTotal() {

        // Add up 5 values
        List<Integer> example = newArrayList(4, 5, 3, 1, 4);
        int total = Question_2_Dice_Roll.diceTotal(example);
        assertEquals("If there are 5 dice values in the ArrayList, for example [4, 5, 3, 1, 4], the total should be 17.", 17, total);

        // Add up 2 values
        example = newArrayList(4, 3);
        total = Question_2_Dice_Roll.diceTotal(example);
        assertEquals("If the dice have values 4 and 3, the total should be 7", 7, total);
    }

    
    @Test(timeout=3000)
    public void testDiceTotalNullList() {
        assertEquals("If the ArrayList is null, return 0 for the dice total", 0, Question_2_Dice_Roll.diceTotal(null));
    }


    @Test(timeout=3000)
    public void testDiceTotalEmptyList()  {
        assertEquals("If the ArrayList is empty, return 0 for the dice total", 0, Question_2_Dice_Roll.diceTotal(new ArrayList<>()));
    }

    
    @Test(timeout=3000)
    public void testAllSameValueSameValue() {

        List<Integer> example = newArrayList(4, 4, 4);
        assertTrue("allSameValue called with an ArrayList of 4, 4, 4 should return true", Question_2_Dice_Roll.allSameValue(example));

        example = newArrayList(1, 1, 1);
        assertTrue("allSameValue called with an ArrayList of 1, 1, 1 should return true", Question_2_Dice_Roll.allSameValue(example));

        example = newArrayList(4);
        assertTrue("allSameValue called with an ArrayList of 4 should return true", Question_2_Dice_Roll.allSameValue(example));

    }


    @Test(timeout=3000)
    public void testAllSameValueNotSameValue() {

        List<Integer> example = newArrayList(4, 5, 3);
        assertFalse("allSameValue called with an ArrayList of 4, 5, 3 should return false", Question_2_Dice_Roll.allSameValue(example));

        example = newArrayList(4, 4, 4, 4, 3);
        assertFalse("allSameValue called with an ArrayList of 4, 4, 4, 4, 3 should return false", Question_2_Dice_Roll.allSameValue(example));

        example = newArrayList(3, 1, 1, 1);
        assertFalse("allSameValue called with an ArrayList of 3, 1, 1, 1 should return false", Question_2_Dice_Roll.allSameValue(example));
    
    }

    
    @Test(timeout=3000)
    public void testAllSameValueEmptyList() {
    
        // Empty list, returns false
        List<Integer> example = new ArrayList<>();
        assertFalse("allSameValue called with an empty ArrayList should return false", Question_2_Dice_Roll.allSameValue(example));
    }


    @Test(timeout=3000)
    public void testAllSameValueNullList()  {
        
        // null list, returns false
        assertFalse("allSameValue called with a null ArrayList should return false", Question_2_Dice_Roll.allSameValue(null));

    }
}