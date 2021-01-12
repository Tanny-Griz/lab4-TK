package week_4;

import org.junit.Test;
import test_utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Question_1_BreakfastTest {
    
    @Test(timeout=3000)
    public void testCereals()  {

        PrintUtils.catchStandardOut();

        List<String> cereals = Question_1_Breakfast.breakfast();

        String out = PrintUtils.resetStandardOut();
        
        // Test that 'Cornflakes" was added
        assertTrue("Add the String 'Cornflakes' to the list", cereals.contains("Cornflakes"));
        
        // Test that "Oatmeal" was removed
        assertFalse("Remove the String 'Oatmeal' from the list", cereals.contains("Oatmeal"));
        
        // And when the favorite breakfast is added, there should be 4 items in the list
        assertEquals("Add your favorite breakfast food to the list", 4, cereals.size());
        
        // Check that all elements of ArrayList are printed. Don't care what order.
        for (String c : cereals) {
            assertTrue("Print all of the items in the list", out.contains(c));
        }
        
        // Is a message confirming "Special K is in the ArrayList" is printed
        assertTrue("Test if Special K is in the ArrayList and print the exact message requested if so", out.toLowerCase().contains("special k is in the list"));

        // Is the size of the list printed? Should be 4 items.
        assertTrue("Print a message with the number of items in the list. Use size()", out.contains("4"));
        
    }
}