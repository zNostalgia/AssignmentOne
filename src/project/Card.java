package project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code
 * should remember to add themselves as a modifier.
 *
 * @author Abdul Liban
 * @author Aman Singh
 * @author Elven Dawood
 * @author Connor Murray
 */
public class Card
{

   /**
    * Students should implement this method for their specific children classes
    *
    * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
    */

   public enum Suit
   {
      HEARTS,
      CLUBS,
      SPADES,
      DIAMONDS
   };
   public enum Value
   {
      ACE(13),
      KING(12),
      QUEEN(11),
      JACK(10),
      TEN(9),
      NINE(8),
      EIGHT(7),
      SEVEN(6),
      SIX(5),
      FIVE(4),
      FOUR(3),
      THREE(2),
      TWO(1);

      private final int power;

      public int getPower ()
      {
         return power;
      }

      private Value (int power)
      {
         this.power = power;
      }

   }

   private final Suit suit;
   private final Value value;

   public Card (Suit s, Value v)
   {
      suit = s;
      value = v;
   }

   public Value getValue ()
   {
      return this.value;
   }

   public Suit getSuit ()
   {
      return this.suit;
   }

   @Override
   public String toString ()
   {
      String output = (this.value + " of " + this.suit);
      return output;
   }


}
