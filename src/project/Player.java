package project;
import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Abdul Liban
 * @author Aman Singh
 * @author Elven Dawood
 * @author Connor Murray
 */
public abstract class Player
{

   private String playerID;
   public ArrayList<Card> hand = new ArrayList<Card>();


   public String getPlayerID ()
   {
      return this.playerID;
   }

   public void setPlayerID (String playerID)
   {
      this.playerID = playerID;
   }

   /**
    * A constructor that allows you to set the player's unique ID
    *
    * @param name the unique ID to assign to this player.
    */
   public Player (String name)
   {
      // TODO - implement Player.Player
      this.playerID = name;
   }

   public boolean hasCards ()
   {

      return !hand.isEmpty();
   }

   public Card playfirstCard ()
   {
      Card card = hand.get(0);
      hand.remove(0);
      return card;

   }


   /**
    * The method to be instantiated when you subclass the Player class
    * with your specific type of Player and filled in with logic to play your game.
    */
   public abstract void play ();

}
