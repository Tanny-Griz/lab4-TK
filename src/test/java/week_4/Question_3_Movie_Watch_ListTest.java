package week_4;

//import junit.framework.TestCase;
import org.junit.Test;
import test_utils.ArrayListUtils;
import test_utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Question_3_Movie_Watch_ListTest {

    /*
    This method should add the String movie to the END of the movies List,
    but only if the movie is not in the list.

    Don't change the case of the movie string when adding it to the movies list.
    If the movie is 'WALL-E' then add this exact string.
    If the movie is 'Star Wars: Episode IV – A New Hope' add this exact string.

    If the movies list contains ['Up', 'Jaws', 'Spiderman']
    and the movie String is 'Rocky' then it should be added to the end of the list.
            The movies list will become ['Up', 'Jaws', 'Spiderman', 'Rocky']
    Print the message "Movie added!"


    Don't add the movie if it is already in the movies list.
    Your check should be case-insensitive.
            If the movies list contains ['Up', 'Jaws', 'Spiderman']
    and if the movie String is 'Up' then it should NOT be added.
    or, if the movie String is 'up' then it should NOT be added.
    or, if the movie String is 'UP' then it should NOT be added.

    If the movie is already in the list, print the message "This movie is already in your watchlist!"

    This method does not need to return anything. */

    @Test(timeout=3000)
    public void testAddMovieEmptyList() {

        // Add example movie to empty list

        List<String> movies = new ArrayList<>();
        String exampleMovie = "Wonder Woman";
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.addMovie(exampleMovie, movies);
        String printed = PrintUtils.resetStandardOut();

        assertEquals("After adding one movie, the movies list should have one movie in it", 1, movies.size());
        assertEquals("The movie string should be added without modification", "Wonder Woman", movies.get(0));
        assertTrue("Print the message 'Movie added!' when a movie is added", printed.toLowerCase().contains("movie added"));

    }

    @Test(timeout=3000)
    public void testAddMovieMoviesInList() {

        // Test movies added in order
        List<String> movies = new ArrayList<>();
        Question_3_Movie_Watch_List.addMovie("Wonder Woman", movies);
        Question_3_Movie_Watch_List.addMovie("JAWS", movies);
        Question_3_Movie_Watch_List.addMovie("Star Wars IV: A New Hope", movies);
        Question_3_Movie_Watch_List.addMovie("  a   lowercase   movie   with   spaces   ", movies);

        List<String> expectedList = List.of("Wonder Woman", "JAWS", "Star Wars IV: A New Hope", "  a   lowercase   movie   with   spaces   ");

        assertEquals("If 4 movies are added to the movies list, it will have 4 movies in it", expectedList.size(), movies.size());

        assertTrue("Add movie names to the movie list. Don't modify the strings that are added to the list.",
               ArrayListUtils.arrayListEqual(expectedList, movies, true));

    }

    @Test(timeout=3000)
    public void testAddMovieDontAddExactDuplicates() {

        List<String> originalList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.addMovie("Wonder Woman", workingList);  // exact duplicate
        Question_3_Movie_Watch_List.addMovie("JAWS", workingList);  // exact duplicate
        Question_3_Movie_Watch_List.addMovie("Star Wars IV: A New Hope", workingList);  // exact duplicate

        String output = PrintUtils.resetStandardOut();

        // List should not be modified
        assertTrue("Don't add movies that are already in the list.",
                ArrayListUtils.arrayListEqual(workingList, originalList, true));

        assertTrue("If a movie is already in the list, print the message 'This movie is already in your watchlist!'",
                output.toLowerCase().contains("this movie is already in your watchlist"));

    }

    @Test(timeout=3000)
    public void testAddMovieDontAddDuplicatesInAnyCase() {

        List<String> originalList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.addMovie("WONDER WOMAN", workingList);
        Question_3_Movie_Watch_List.addMovie("jaws", workingList);
        Question_3_Movie_Watch_List.addMovie("sTaR WaRs iV: a NEw HoPe", workingList);

        String output = PrintUtils.resetStandardOut();

        // List should not be modified
        assertTrue("Don't add movies that are already in the list, even if the case is different",
                ArrayListUtils.arrayListEqual(workingList, originalList, true));

        assertTrue("If a movie is already in the list, print the message 'This movie is already in your watchlist!'",
                output.toLowerCase().contains("this movie is already in your watchlist"));

    }

    @Test(timeout=3000)
    public void testGetNextMovie() {

        /*
         If the movies list is not null, and has as at least one movie in it,
         return the first movie in the list.

         Don't modify the movies list.

         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.*/

        // Using List.of will raise an exception if the list is modified
        List<String> exampleList = List.of("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");

        // The next movie to watch, the first one added, is "Wonder Woman"

        String nextMovie = Question_3_Movie_Watch_List.getNextMovie(exampleList);
        assertEquals("Return the first movie from the list", "Wonder Woman", nextMovie);
        assertEquals("Don't modify the movies list", 3, exampleList.size());

    }


    @Test(timeout=3000)
    public void testGetNextMovieEmpty() {

        /*
         If the movies list is not null, and has as at least one movie in it,
         return the first movie in the list.

         Don't modify the movies list.

         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.*/

        List<String> exampleList = new ArrayList<>();
        String nextMovie = Question_3_Movie_Watch_List.getNextMovie(exampleList);
        assertNull("If the movie list is empty, return null", nextMovie);
        assertEquals("Don't modify the movies list", 0, exampleList.size());

    }


    @Test(timeout=3000)
    public void testGetNextMovieNull() {

        /*
         If the movies list is not null, and has as at least one movie in it,
         return the first movie in the list.

         Don't modify the movies list.

         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.*/

        List<String> exampleList = null;
        String nextMovie = Question_3_Movie_Watch_List.getNextMovie(exampleList);
        assertNull("If the movie list is null, return null", nextMovie);
        assertNull("Don't modify the movies list", exampleList);

    }


    @Test(timeout=3000)
    public void testRemoveMovieCaseMatch() {

        /*  Remove the movie from the movies list.
         Your check should be case-insensitive.

         If the movie is in the movies list, remove that movie and print the
         message "Movie removed!"

         If the movies list contains ['Up', 'Jaws', 'Spiderman']
         and the movie String is 'Jaws' then the 'Jaws' entry in the list should be removed.
         or if the movie String is 'jaws' then the 'Jaws' entry in the list should be removed.
         or if the movie String is 'JAWS' then the 'Jaws' entry in the list should be removed.

         Print the message "Movie removed!"

         If the movies list contains ['Up', 'Jaws', 'Spiderman']
         and the movie String is 'Rocky' then don't modify the movies list
         Print the message "Movie not found!"

         If the movies list is null, or empty, print the message "Movie not found!"
         Hint: check if the list is null or empty first.*/

        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        List<String> expectedModifiedList = ArrayListUtils.newArrayList("Wonder Woman", "Star Wars IV: A New Hope");
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("JAWS", workingList);
        String output = PrintUtils.resetStandardOut();

        assertTrue("Remove the movie from the movie list", ArrayListUtils.arrayListEqual(expectedModifiedList, workingList));
        assertTrue("Print the message 'Movie removed!' when a movie is removed", output.toLowerCase().contains("movie removed"));

    }


    @Test(timeout=3000)
    public void testRemoveMovieDifferentCase() {
        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        List<String> expectedModifiedList = ArrayListUtils.newArrayList("Wonder Woman", "Star Wars IV: A New Hope");
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("JaWs", workingList);
        String output = PrintUtils.resetStandardOut();

        assertTrue("Remove the movie from the movie list", ArrayListUtils.arrayListEqual(expectedModifiedList, workingList));
        assertTrue("Print the message 'Movie removed!' when a movie is removed", output.toLowerCase().contains("movie removed"));


        List<String> expectedModifiedList2 = ArrayListUtils.newArrayList("Wonder Woman");
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("StAr waRS iV: A nEw hope", workingList);
        output = PrintUtils.resetStandardOut();

        assertTrue("Remove the movie from the movie list", ArrayListUtils.arrayListEqual(expectedModifiedList2, workingList));
        assertTrue("Print the message 'Movie removed!' when a movie is removed", output.toLowerCase().contains("movie removed"));

    }


    @Test(timeout=3000)
    public void testRemoveMovieNotFound() {

        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        List<String> expectedModifiedList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("Up", workingList);

        String output = PrintUtils.resetStandardOut();

        assertTrue("If removeMovie is called with a movie that is not in the list, don't modify the movie list", ArrayListUtils.arrayListEqual(expectedModifiedList, workingList));
        assertTrue("Print the message 'Movie not found!' if a movie is not found", output.toLowerCase().contains("movie not found"));

    }


    @Test(timeout=3000)
    public void testRemoveMovieListEmpty() {

        List<String> empty = new ArrayList<>();
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("Up", empty);
        String output = PrintUtils.resetStandardOut();

        assertEquals("If removeMovie is called and the movie list is empty, don't modify the movie list", 0, empty.size());
        assertTrue("Print the message 'Movie not found!' if the movie list is empty", output.toLowerCase().contains("movie not found"));

    }


    @Test(timeout=3000)
    public void testRemoveMovieListNull() {

        List<String> nullList = null;
        PrintUtils.catchStandardOut();
        Question_3_Movie_Watch_List.removeMovie("Up", null);
        String output = PrintUtils.resetStandardOut();

        assertNull("If removeMovie is called and the movie list is null, don't modify the movie list", nullList);
        assertTrue("Print the message 'Movie not found!' if the movie list is null", output.toLowerCase().contains("movie not found"));

    }


    @Test(timeout=3000)
    public void testGetRandomMovieFromWatchList() {

        /*    Return the name of a random movie from the movies list.

         There's several ways to generate a random movie. So this test gets 100 random
         movies and checks the distribution seems to be random.  */

        List<String> workingList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars");
        List<String> originalList = ArrayListUtils.newArrayList("Wonder Woman", "JAWS", "Star Wars");

        Map<String, Integer> counts = new HashMap<>();

        workingList.forEach(name -> counts.put(name, 1));

        for (int x = 0 ; x < 100 ; x++) {
            String randomMovie = Question_3_Movie_Watch_List.getRandomMovieFromWatchList(workingList);
            counts.put(randomMovie, counts.get(randomMovie) + 1);
        }

        // If names are picked at random, would expect at least some of each name - choosing
        // one of three names at random, at least 15 of each name

        for (int val: counts.values()) {
            assertTrue("If movie names are selected at random, each name should be chosen at " +
                    "least a few times if the getRandomMovieFromWatchList is called many times", val > 15);
        }

        assertTrue("Don't modify the movie list when choosing a random movie", ArrayListUtils.arrayListEqual(originalList, workingList));

    }


    @Test(timeout=3000)
    public void testRandomMovieListNull() {
        String randomMovie = Question_3_Movie_Watch_List.getRandomMovieFromWatchList(null);
        assertNull("If getRandomMovieFromWatchList is called and the movie list is null, return null", randomMovie);
    }


    @Test(timeout=3000)
    public void testRandomMovieListEmpty() {
        List<String> emptyList = new ArrayList<>();
        String randomMovie = Question_3_Movie_Watch_List.getRandomMovieFromWatchList(emptyList);
        assertNull("If getRandomMovieFromWatchList is called and the movie list is null, return null", randomMovie);
    }


    @Test(timeout=3000)
    public void testPrintMoviesInNameOrder() {
        /*   Print the movie names in alphabetical order, one movie per line.

         ** Don't modify the original movies list! **

         If the movies list contains ['Up', 'Jaws', 'Spiderman'] you will
         print

         Jaws
         Spiderman
         Up

         You should sort the movies using Java's default sort order for strings,
         and print the exact text of the movie names from the list.

         If the movies list contains ['Up', 'jaws', 'Spiderman']
         Note 'jaws' has lowercase 'j' and lowercase letters are sorted after
         uppercase letters.

         you will print

         Spiderman
         Up
         jaws


         If the movies list is empty or null, print the message 'No movies'

         This method will not return anything.*/

        List<String> workingList = ArrayListUtils.newArrayList("frozen", "UP", "inside out", "Scream");
        List<String> originalList = ArrayListUtils.newArrayList("frozen", "UP", "inside out", "Scream");

        /* This example should print

        Scream
        UP
        frozen
        inside out

        Due to Java's default string sort order. Lowercase letters sort after uppercase

        */

        String expectedRegexPattern = ".*Scream.*\\n.*UP.*\\n.*frozen.*\\n.*inside out.*";

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInNameOrder(workingList);

        String output = PrintUtils.resetStandardOut();
        output = output.replace("\r", "");  // remove windows newline char
        output = output.trim();

        String message = "If the movie list contains " + workingList + "\n"
                + "then the printMoviesInWatchListOrder should print the following. \n\n"
                + "Scream\n"
                + "Up\n"
                + "frozen\n"
                + "inside out\n\n" +
                "Print one movie on each line, don't modify the movie names, and don't print any numbers or anything else. \n" +
                "  \"If you think your output is correct but the test is failing, please push code to GitHub and email Clara \";\n";

        assertTrue(message, output.matches(expectedRegexPattern));
        assertTrue("Don't modify the movie list", ArrayListUtils.arrayListEqual(workingList, originalList, true));
    }


    @Test(timeout=3000)
    public void testPrintMoviesInNameOrderEmptyList() {

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInNameOrder(null);

        String output = PrintUtils.resetStandardOut();

        assertTrue("If the movies list is empty or null, print the message 'No movies'", output.toLowerCase().contains("no movies"));

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInNameOrder(new ArrayList<>());

        output = PrintUtils.resetStandardOut();

        assertTrue("If the movies list is empty or null, print the message 'No movies'", output.toLowerCase().contains("no movies"));
    }


    @Test(timeout=3000)
    public void testPrintMoviesInWatchListOrder() {
        /*  TODO Print the movie names in watchlist order, one movie per line.
        Include a number to indicate the movie's position in the watch list.

         ** Don't modify the original movies list! **

         If the movies list contains ['Up', 'Jaws', 'Spiderman'] you will
         print

         1. Up
         2. Jaws
         3. Spiderman

         If the movies list is empty or null, print the message 'No movies'

        This method will not return anything.*/

        List<String> workingList = ArrayListUtils.newArrayList("frozen", "UP", "inside out", "Scream");
        List<String> originalList = ArrayListUtils.newArrayList("frozen", "UP", "inside out", "Scream");

        String expectedRegexPattern = ".*1.*frozen.*\\n.*2.*UP.*\\n.*3.*inside out.*\\n.*Scream.*";

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInWatchListOrder(workingList);

        String output = PrintUtils.resetStandardOut();
        output = output.replace("\r", "");  // remove windows newline char
        output = output.trim();

        String message = "If the movie list contains " + workingList + "\n"
                + "then the printMoviesInWatchListOrder should print the following. \n\n"
                + "1. frozen\n"
                + "2. UP\n"
                + "3. inside out\n"
                + "4. Scream\n\n" +
                "Include the numbers, starting at 1. Print one movie on each line, and don't print anything else.\n" +
                "If you think your output is correct but the test is failing, please push code to GitHub and email Clara ";

        assertTrue(message, output.matches(expectedRegexPattern));
        assertTrue("Don't modify the movie list", ArrayListUtils.arrayListEqual(workingList, originalList, true));

    }


    @Test(timeout=3000)
    public void testPrintMoviesInWatchListOrderEmptyList() {

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInWatchListOrder(null);

        String output = PrintUtils.resetStandardOut();

        assertTrue("If the movies list is empty or null, print the message 'No movies'", output.toLowerCase().contains("no movies"));

        PrintUtils.catchStandardOut();

        Question_3_Movie_Watch_List.printMoviesInWatchListOrder(new ArrayList<>());

        output = PrintUtils.resetStandardOut();

        assertTrue("If the movies list is empty or null, print the message 'No movies'", output.toLowerCase().contains("no movies"));
    }
}