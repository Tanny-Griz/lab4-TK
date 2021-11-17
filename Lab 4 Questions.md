# Lab 4

### Question 1 Cereal

ArrayList practice. 

*	Remove "Oatmeal" from the ArrayList.
*	Add the name of your favorite breakfast food to the ArrayList.
*	Add "Cornflakes" to the ArrayList.
*	Print all the items in the ArrayList, one per line.
*	Print a message if the ArrayList contains “Special K”. Print a different message if it does not contain "Special K".
*   Print the number of items in the list, using size()
*	(Optional) non-programming question: what does Captain Crunch have to do with computer hacking?


### Question 2 Dice

Finish this program to roll a set of dice. 

Complete the code in the methods.

**Part 1** Generate a random number between 1 and 6 for
each dice to be rolled, and save the values in an ArrayList.

**Part 2** Display the total of all the dice rolled.

**Part 3** Finish the method that decides if all the dice have the same value.
In other words, you'll need a method that 
tests if all the values in an ArrayList are the same. 
In some games, the order of that the dice were rolled in, is important. So, don't modify the order of numbers in the diceValues list.

Note that these lines of code deliberately make your program crash. 
You will delete these lines and replace them with your own code. 
`throw new RuntimeException("Finish the roll method");   // TODO replace with your code`


### Question 3 Movie Watch List

Finish this program to create and manage a movie watchlist. You will finish the code in the methods.

**Part 1**: Finish the method to add a String movie to the END of the movies List,
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

This method does not need to return anything.


**Part 2**  Get the next movie to watch.

If the movies list is not null, and has as at least one movie in it,
return the first movie in the list.

Don't modify the movies list.

If the movies list is null, or empty, return null.
Hint: check if the list is null or empty first.


**Part 3** Finish the method to remove a movie from the movies list.
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
Hint: check if the list is null or empty first.


**Part 4**  Return the name of a random movie from the movies list.

 If the movies list is null, or empty, return null.
 Hint: check if the list is null or empty first.


**Part 5** Finish this method to print the movie names in alphabetical order, one movie per line.

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

This method will not return anything.


**Part 6** Finish the method to print the movie names in watchlist order, one movie per line.
Include a number to indicate the movie's position in the watch list. The numbers should start from 1.

** Don't modify the original movies list! **

If the movies list contains ['Up', 'Jaws', 'Spiderman'] you will
print

1. Up
2. Jaws
3. Spiderman

If the movies list is empty or null, print the message 'No movies'


