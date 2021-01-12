package week_4;

import junit.framework.TestCase;
import test_utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Question_3_Movie_Watch_ListTest extends TestCase {



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

    public void testAddMovieMoviesInList() {

        // Test movies added in order
        List<String> movies = new ArrayList<>();
        Question_3_Movie_Watch_List.addMovie("Wonder Woman", movies);
        Question_3_Movie_Watch_List.addMovie("JAWS", movies);
        Question_3_Movie_Watch_List.addMovie("Star Wars IV: A New Hope", movies);
        Question_3_Movie_Watch_List.addMovie("  a   lowercase   movie   with   spaces   ", movies);

        List<String> expectedList = List.of("Wonder Woman", "JAWS", "Star Wars IV: A New Hope", "  a   lowercase   movie   with   spaces   ");

        assertEquals("If 4 movies are added to the movies list, it will have 4 movies in it", expectedList.size(), movies.size());

        for (int x = 0 ; x < expectedList.size() ; x++) {
            assertEquals("Add movie names to the movie list. Don't modify the strings that are added to the list.", expectedList.get(x), movies.get(x));
        }
    }

    public void testGetNextMovie() {

        /*
         If the movies list is not null, and has as at least one movie in it,
         return the first movie in the list.

         Don't modify the movies list.

         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.*/

        List<String> exampleList = List.of("Wonder Woman", "JAWS", "Star Wars IV: A New Hope");

        // The next movie to watch, the first one added, is "Wonder Woman"

        String nextMovie = Question_3_Movie_Watch_List.getNextMovie(exampleList);
        assertEquals("Return the first movie from the list", "Wonder Woman", nextMovie);
        assertEquals("Don't modify the movies list", 3, exampleList.size());
    }

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

    }

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

    }

    public void testRemoveMovie() {

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
    }

    public void testGetRandomMovieFromWatchList() {

        /*    Return the name of a random movie from the movies list.

         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.*/
    }

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
    }

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
    }
}