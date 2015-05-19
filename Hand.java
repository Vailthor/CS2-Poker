import java.util.*;
import java.util.HashMap;

public class Hand implements Comparable {
   private ArrayList<Card> hand;
   private String handSuit;
   private int t;

   public Hand(){
      hand = new ArrayList<Card>();
      handSuit = "";
      t = 0;
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }

   /*
   BEST
   Royal Flush
   Straight Flush
   Four of a Kind
   Full House
   Flush
   Straight
   Three of a Kind
   Two Pair
   One Pair
   High Card
   WORST
   */


   public String handValue() {
     //return "TODO: String of Best Hand; may need helper methods";
     return valueHelper();
   }
   public String valueHelper()
   {
     HashMap<Integer, Integer> numinHand = new HashMap<Integer, Integer>();
     for(Card x : hand)
     {
       if(t == 0)
         handSuit = x.toString().substring(1);
       else
         if(handSuit == x.toString().substring(1)){}
         else
            handSuit = "different";
       if(numinHand.containsKey(x.value))
       {
         int temp = numinHand.get(x.value);
         numinHand.put(x.value, temp++);
       }
       else
       {
         numinHand.put(x.value, 0);
       }
     }
     if(handSuit.equals("differnt"))
     {
         //Four of a Kind
         if(numinHand.containsValue(4))
            return "FK";
         //Full House
         if(numinHand.containsValue(3) && numinHand.containsValue(2))
            return "FH";
         //Straight
         for(int x: numinHand.keySet())
            if(numinHand.containsKey(x+5))
               return "S";
         //Three of a Kind
         if(numinHand.containsValue(3))
            return "TK";
         //Two Pair and One Pair
         String temp = "P";
         String temp2 = "TP";
         if(numinHand.containsValue(2))
         {
            for(int x: numinHand.keySet())
            {
               
               if(numinHand.get(x) == 2 && temp.length() > 1)
                  temp2 = temp2 + x;
               if(numinHand.get(x) == 2 && temp.length() == 1)
               {
                  temp = temp + x;
                  temp2 = temp2 + x;  
               }
            }
            if(temp.length() == temp2.length())
               return temp;
            else
               return temp2;
         }
      }
      else
      {
         //Royal Flush
         if(numinHand.containsKey(14) && numinHand.containsKey(13) && numinHand.containsKey(12) && numinHand.containsKey(11) && numinHand.containsKey(10))
         {
           return "RF";
         }
         //Straight Flush
         else if(numinHand.containsKey(10) && numinHand.containsKey(9) && numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) || numinHand.containsKey(9) && numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) || numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) || numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) || numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) && numinHand.containsKey(2) || numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) && numinHand.containsKey(2) && numinHand.containsKey(1))
         {
           return "SF";
         }
         //Flush
         else
            return "F";
      }
      int highest = 0;
      for(int x: numinHand.keySet())
      {
         if(highest < x)
            highest = x;
      }
      return "HC" + highest;
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //player #1 wins print 1 player #2 -1
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      return -1;
   }
}
