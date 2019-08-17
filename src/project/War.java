package project;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Abdul Liban
 * @author Aman Singh
 * @author Elven Dawood
 * @author Connor Murray
 */
public class War extends Game
{
   private User user = new User("");
   private ArrayList<Card> cardPile = new ArrayList<Card>();
   private GroupOfCards deck = GroupOfCards.getInstance();
   private Computer comp = new Computer("Computer");
   private Card c1;
   private Card c2;


   public War (String givenName)
   {
      super(givenName);
   }




   @Override
   public void play ()
   {

      Scanner scan = new Scanner(System.in);
      System.out.println("please Enter your Name");
      String p1 = scan.nextLine();

      user.setPlayerID(p1);
      splitDeck();


      while (user.hasCards() && comp.hasCards()) {

         System.out.println(user.getPlayerID() + " have " + user.hand.size() + " in your hand");
         System.out.println("-------------------------------");
         System.out.println("Computer has " + comp.hand.size() + " in hand");
         System.out.println(user.getPlayerID() + " Press enter to play round");
         scan.nextLine();

         Card c1 = user.playfirstCard();
         System.out.println("Your card is " + c1);
         Card c2 = comp.playfirstCard();
         System.out.println("Computer has " + c2);
         addPile(c1, c2);
         int compared = compare(c1, c2);

         if (compared == 1) {
            roundWinner(user);

         }
         else if (compared == 2) {
            roundWinner(comp);
         }
         else {
            System.out.println("Its a TIE!!!");

            while (compared == 0 && user.hasCards() && comp.hasCards()) {
               System.out.println(user.getPlayerID() + "have " + user.hand.size() + " in your hand");
               System.out.println("-------------------------------");
               System.out.println("Computer has " + comp.hand.size() + " in hand");
               System.out.println("");
               System.out.println(user.getPlayerID() + " Press enter to play round");
               scan.nextLine();

               Card tieC1 = user.playfirstCard();
               System.out.println("Your card is " + tieC1);
               Card tieC2 = comp.playfirstCard();
               System.out.println("Computer has " + tieC2);
               addPile(tieC1, tieC2);

               int tieCompared = compare(tieC1, tieC2);
               compared += tieCompared;
            }
         }


      }

      declareWinner();
   }



   public void roundWinner (Player p)
   {
      System.out.println(p.getPlayerID() + " wins the round!");
      pileWon(p);


      clearPile();
   }


   public void splitDeck ()
   {
      for (int i = 0; i <= 51; i++) {

         if (i <= 25) {
            user.hand.add(deck.cards.get(i));
         }
         else {
            comp.hand.add(deck.cards.get(i));
         }
      }

   }

   public int compare (Card c1, Card c2)
   {
      int compared;
      if (c1.getValue().getPower() > c2.getValue().getPower()) {
         return compared = 1;
      }
      else if (c1.getValue().getPower() < c2.getValue().getPower()) {
         return compared = 2;
      }
      else {
         return compared = 0;
      }

   }

   @Override
   public void declareWinner ()
   {
      if (!user.hasCards()) {
         System.out.println(comp.getPlayerID() + "Computer won!");
      }
      else {
         System.out.println(user.getPlayerID() + "WON!!!!!!");
      }

   }

   public void addPile (Card a, Card b)
   {
      cardPile.add(b);
      cardPile.add(a);

   }

   public void clearPile ()
   {
      cardPile.clear();
   }

   public void pileWon (Player p)
   {
      for (int i = 0; i < cardPile.size(); i++) {
         p.hand.add(cardPile.get(i));
      }
   }





}
