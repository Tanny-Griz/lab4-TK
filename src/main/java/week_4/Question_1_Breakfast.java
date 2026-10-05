package week_4;

import java.util.ArrayList;
import java.util.List;

/**
 *  ArrayList practice.

 *	Remove "Oatmeal" from the ArrayList.
 *	Add the name of your favorite breakfast food to the ArrayList.
 *	Add "Cornflakes" to the ArrayList.
 *	Display all of the items in the ArrayList.
 *	Print a message if the ArrayList contains “Special K”. Print a different message if it does not contain "Special K".
 *
 *	(optional) non-programming question: what does Captain Crunch have to do with computer hacking?
 *
 */

public class Question_1_Breakfast {

    public static void main(String[] args) {
        breakfast();
    }

    public static List<String> breakfast() {

        // Creating a new ArrayList.
        List<String> cereals = new ArrayList<>();

        // Don't modify these three lines
        cereals.add("Special K");
        cereals.add("Captain Crunch");
        cereals.add("Oatmeal");
        
       	// TODO Remove "Oatmeal" from the ArrayList.
        cereals.remove("Oatmeal");
        
        // TODO	Add the name of your favorite breakfast food to the List.
        cereals.add("Tea");
        
        // TODO	Add the String "Cornflakes" to the List.
        cereals.add("Cornflakes");
        
        // TODO	Print all of the items in the ArrayList, one per line. Use a loop.
        for (String cereal : cereals) {
            System.out.println(cereal);
        }
       	
        // TODO Use an if-statement to print the exact message "Special K is in the list" if the list contains "Special K".
        if (cereals.contains("Special K")) {
            System.out.println("Special K is in the list");
        }
       	
        // TODO Print a different message if it does not contain "Special K".
        if (cereals.contains("Special K")) {
            System.out.println("Special K is in the list");
        } else {
            System.out.println("Special K is not in the list");
        }
        
        // TODO Print a message with the number of items in the list
        System.out.println("Number of items: " + cereals.size());
        
        // TODO	(optional) non-programming question: what does Captain Crunch have to do with computer hacking?



        // This line needs to be the last line in this method,
        // so write all of your code before this line.
        // Don't modify this line.
        // The test needs the method to return your ArrayList after the modifications you make.
        return cereals;
    }
}
