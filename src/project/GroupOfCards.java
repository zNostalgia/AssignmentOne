package project;

import java.util.*;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author Abdul Liban
 * @author Aman Singh
 * @author Elven Dawood
 * @author Connor Murray
 */
public class GroupOfCards
{

   /*
    * The group of cards, stored in an ArrayList
    */
   public static ArrayList<Card> cards = new ArrayList<>();
   private static GroupOfCards onlyObject = null;



   /*
    * the size of the grouping
    *
    * @param givenSize
    */
   private GroupOfCards ()
   {
      // TODO - implement GroupOfCards.GroupOfCards
      for (Card.Suit s : Card.Suit.values()) {
         for (Card.Value v : Card.Value.values()) {
            cards.add(new Card(s, v));
         }
      }
      shuffle();

   }

   public static GroupOfCards getInstance ()
   {
      if (onlyObject == null) {
         onlyObject = new GroupOfCards();
      }
      return onlyObject;
   }

   public void generateHand ()
   {

   }



   public void shuffle ()
   {
      // TODO - implement GroupOfCards.shuffle
      Collections.shuffle(cards);
   }

}
