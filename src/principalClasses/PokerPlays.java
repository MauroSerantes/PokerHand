
package principalClasses;


import java.util.ArrayList;


public class PokerPlays{
     
    public static final Integer HIGH_CARD = 0;
    public static final Integer SIMPLE_PAIR = 1;
    public static final Integer DOUBLE_PAIR = 2;
    public static final Integer THREE_OF_A_KIND = 3;
    public static final Integer STRAIGHT = 4;
    public static final Integer FLUSH = 5;
    public static final Integer FULL_HOUSE = 6;
    public static final Integer POKER = 7;
    public static final Integer STRAIGHT_FLUSH = 8;
    
    
    private ArrayList<CounterValue> numberOfCardsWithSameRank(ArrayList<GamblingCard<Integer>> cards){
        ArrayList<CounterValue> rankAndAmount = new ArrayList<>(); 
        GamblingCard<Integer> auxCard = cards.get(0);
        rankAndAmount.add(new CounterValue(auxCard.getRankOfCard()));
        int size = cards.size();
        boolean added = false;
        
        for(int i=1;i<size;i++){
            added = false;
            auxCard = cards.get(i);
            int j=0;
            
            while(j<rankAndAmount.size() && !added){
                CounterValue aux = rankAndAmount.get(j);
                
                if(auxCard.compareRankOfCard(aux.value)==0){
                    aux.amount += 1;
                    added = true;
                }
                
                j++;
            }
            
            if(!added) rankAndAmount.add(new CounterValue(auxCard.getRankOfCard()));
               
        }
        rankAndAmount.sort((c1,c2)->c1.value.compareTo(c2.value));
        return rankAndAmount;
    }
    
    private ArrayList<CounterValue> numberOfCardsWithSameSuit(ArrayList<GamblingCard<Integer>> cards){
        ArrayList<CounterValue> suitAndAmount = new ArrayList<>(); 
        GamblingCard<Integer> auxCard = cards.get(0);
        suitAndAmount.add(new CounterValue(auxCard.getSuitOfCard()));
        int size = cards.size();
        boolean added = false;
        
        for(int i=1;i<size;i++){
            added = false;
            auxCard = cards.get(i);
            int j=0;
            
            while(j<suitAndAmount.size() && !added){
                CounterValue aux = suitAndAmount.get(j);
                
                if(auxCard.compareSuitOfCard(aux.value)==0){
                    aux.amount += 1;
                    added = true;
                }
                
                j++;
            }
            
            if(!added) suitAndAmount.add(new CounterValue(auxCard.getSuitOfCard()));
               
        }
        
        return suitAndAmount;
    }
   
  
    
    private boolean simplePair(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play,ArrayList<CounterValue> remainingHand){
      boolean isSimplePair = false; 
      
      for(CounterValue aux : rankCount){
          
          if(aux.amount == 2){
              isSimplePair = true;
              
              if(play!=null) play.add(aux);
          }
          else if(remainingHand != null) remainingHand.add(aux);
      }
      
      if(!isSimplePair){
         if(play!=null)play.removeAll(play);
         if(remainingHand!=null)remainingHand.removeAll(remainingHand);     
      } 
      
      return isSimplePair;
    }
    
    
    private boolean doublePair(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play,ArrayList<CounterValue> remainingHand){
      int amountOfPairs = 0; 
      
      for(CounterValue aux : rankCount){
          
          if(aux.amount == 2){
              amountOfPairs += 1;
              
              if(play != null) play.add(aux);
          }
          else if(remainingHand != null) remainingHand.add(aux);
      }
      
      if(amountOfPairs != 2){
          if(play!=null)play.removeAll(play);
          if(remainingHand!=null)remainingHand.removeAll(remainingHand);
      } 
    
      return (amountOfPairs == 2);
    }
    
    
    private boolean threeOfAKind(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play,ArrayList<CounterValue> remainingHand){
      boolean isThreeOfKind = false; 
      
      for(CounterValue aux : rankCount){
          
          if(aux.amount == 3){
              isThreeOfKind = true;
              
              if(play!=null) play.add(aux);
          }
          else if(remainingHand!=null) remainingHand.add(aux);
      }
      
      if(!isThreeOfKind){
          if(play!=null)play.removeAll(play);
          if(remainingHand!=null)remainingHand.removeAll(remainingHand);;
      }
      
      return isThreeOfKind;
    }
    
    
    private boolean straight(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play){
       if(rankCount.size() != 5) return false;
        
       int aux = rankCount.get(0).value;
       
       if(play!=null) play.add(rankCount.get(0));
       
       int i=1;
       
       while(i<rankCount.size() && (aux+1)==rankCount.get(i).value){
           aux = rankCount.get(i).value;
           
           if(play!=null) play.add(rankCount.get(i));
           
           i++;
       }
       
       if(i!=rankCount.size() && play!=null) play.removeAll(play);
       
       return (i==rankCount.size());
    }
    
    
    private boolean flush(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> suitCount,ArrayList<CounterValue> play){
       boolean isFlush = false;
       
       if(suitCount.size() == 5){
           
           if(play!=null) rankCount.forEach((c)->play.add( c));
           
           isFlush = true;
       }
       
       return isFlush;
    }    
    
    
    private boolean fullHouse(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play){
       return (threeOfAKind(rankCount,play,null) && simplePair(rankCount, play, null));
    }
    
    
    private boolean poker(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> play,ArrayList<CounterValue> remainingHand){
      boolean isPoker = false; 
      
      for(CounterValue aux : rankCount){
          
          if(aux.amount == 4){
              
              isPoker = true;
              
              if(play!=null) play.add(aux);
          }
          else if(remainingHand != null) remainingHand.add(aux);
      }
      
      if(!isPoker){
          if(play!=null)play.removeAll(play);
          if(remainingHand!=null)remainingHand.removeAll(remainingHand);
      }
    
      return isPoker;
    }
    
    
    private boolean straightFlush(ArrayList<CounterValue> rankCount,ArrayList<CounterValue> suitCount,ArrayList<CounterValue> play){
      return (straight(rankCount,play) && flush(rankCount,suitCount,null));
    }
    
    
    public Integer getPokerPlay(ArrayList<GamblingCard<Integer>> cards){
        return getPokerPlayAndHand(cards, null, null);
    }
    
    
    private Integer getPokerPlayAndHand(ArrayList<GamblingCard<Integer>> cards,ArrayList<CounterValue> play,ArrayList<CounterValue> remainingHand){
        ArrayList<CounterValue> ranksAndAmount = numberOfCardsWithSameRank(cards);
        ArrayList<CounterValue> suitsAndAmount = numberOfCardsWithSameSuit(cards);
        
        if(straightFlush(ranksAndAmount, suitsAndAmount,play)) return STRAIGHT_FLUSH;
        
        if(poker(ranksAndAmount,play,remainingHand)) return POKER;
        
        if(fullHouse(ranksAndAmount,play)) return FULL_HOUSE;
        
        if(flush(ranksAndAmount,suitsAndAmount,play)) return FLUSH;
        
        if(straight(ranksAndAmount,play)) return STRAIGHT;
        
        if(threeOfAKind(ranksAndAmount,play,remainingHand)) return THREE_OF_A_KIND;
        
        if(doublePair(ranksAndAmount,play,remainingHand)) return DOUBLE_PAIR;
        
        if(simplePair(ranksAndAmount,play,remainingHand)) return SIMPLE_PAIR;
        
        if(play!=null) ranksAndAmount.forEach((c)->play.add( c));
        
        return HIGH_CARD;
    }
    
    
    private int compareSimplePair(ArrayList<CounterValue> p1Hand,ArrayList<CounterValue> p1Remining,
            ArrayList<CounterValue> p2Hand,ArrayList<CounterValue> p2Remining){
        
        if(p1Hand.get(0).value.compareTo(p2Hand.get(0).value)!=0){
            return (p1Hand.get(0).value.compareTo(p2Hand.get(0).value)>0)? 1:-1;
        }
               
        return compareHighCard(p1Remining, p2Remining);
    }
    
    
    private int compareDoublePair(ArrayList<CounterValue> p1Hand,ArrayList<CounterValue> p1Remining,
            ArrayList<CounterValue> p2Hand,ArrayList<CounterValue> p2Remining){
        if(p1Hand.get(1).value.compareTo(p2Hand.get(1).value)!=0){
            return (p1Hand.get(1).value.compareTo(p2Hand.get(1).value)>0)? 1:-1;
        }
        
        if(p1Hand.get(0).value.compareTo(p2Hand.get(0).value)!=0){
            return (p1Hand.get(0).value.compareTo(p2Hand.get(0).value)>0)? 1:-1;
        }
        
        return p1Remining.get(0).value.compareTo(p2Remining.get(0).value);
    }
    
    
    private int compareThreeOfAKind(ArrayList<CounterValue> p1Hand,ArrayList<CounterValue> p1Remining,
            ArrayList<CounterValue> p2Hand,ArrayList<CounterValue> p2Remining){
        
        if(p1Hand.get(0).value.compareTo(p2Hand.get(0).value)!=0){
            return (p1Hand.get(0).value.compareTo(p2Hand.get(0).value)>0)? 1:-1;
        }
          
        return compareHighCard(p1Remining, p2Remining);
    }
    
    
    private int compareFullHouse(ArrayList<CounterValue> p1Hand,
            ArrayList<CounterValue> p2Hand){
        if(p1Hand.get(1).value.compareTo(p2Hand.get(1).value)!=0){
            return p1Hand.get(1).value.compareTo(p2Hand.get(1).value);
        }
        
        return p1Hand.get(0).value.compareTo(p2Hand.get(0).value);
    }
    
    
    private int comparePoker(ArrayList<CounterValue> p1Hand,ArrayList<CounterValue> p1Remining,
            ArrayList<CounterValue> p2Hand,ArrayList<CounterValue> p2Remining){
        
        if(p1Hand.get(0).value.compareTo(p2Hand.get(0).value)!=0){
            return (p1Hand.get(0).value.compareTo(p2Hand.get(0).value)>0)? 1:-1;
        }
        
        return p1Remining.get(0).value.compareTo(p2Remining.get(0).value);
    }
    
 
    private int compareHighCard(ArrayList<CounterValue> p1Hand,
            ArrayList<CounterValue> p2Hand){
        int i=p1Hand.size()-1;
        
        while(i>0 && p1Hand.get(i).value.compareTo(p2Hand.get(i).value)==0){
            i--;
        }
        
        return (i==0)? 0 : p1Hand.get(i).value.compareTo(p2Hand.get(i).value);
    }
    
  
    public int comparePlays(ArrayList<GamblingCard<Integer>> firstPlay,ArrayList<GamblingCard<Integer>> secondPlay){  
       ArrayList<CounterValue> firstPlayHand = new ArrayList<>();
       ArrayList<CounterValue> firstPlayRemining = new ArrayList<>();
       
       ArrayList<CounterValue> secondPlayHand = new ArrayList<>();
       ArrayList<CounterValue> secondPlayRemining = new ArrayList<>();
       
       Integer first = getPokerPlayAndHand(firstPlay,firstPlayHand,firstPlayRemining);
       Integer second = getPokerPlayAndHand(secondPlay,secondPlayHand,secondPlayRemining);
       
       if(first.compareTo(second)!= 0)  
           return (first.compareTo(second)>0)? 1:-1;  
      
       if(first.compareTo(STRAIGHT_FLUSH)==0)
           return compareHighCard(firstPlayHand, secondPlayHand);
       
       if(first.compareTo(POKER)==0)
           return comparePoker(firstPlayHand, firstPlayRemining, secondPlayHand, secondPlayRemining);
       
       if(first.compareTo(FULL_HOUSE)==0)
           return compareFullHouse(firstPlayHand, secondPlayHand);
          
       if(first.compareTo(FLUSH)==0) 
           return compareHighCard(firstPlayHand, secondPlayHand);
       
       if(first.compareTo(STRAIGHT)==0) 
           return compareHighCard(firstPlayHand, secondPlayHand);
       
       if(first.compareTo(THREE_OF_A_KIND)==0) 
           return compareThreeOfAKind(firstPlayHand, firstPlayRemining, secondPlayHand, secondPlayRemining);
       
       if(first.compareTo(DOUBLE_PAIR)==0) 
           return compareDoublePair(firstPlayHand, firstPlayRemining, secondPlayHand, secondPlayRemining);
       
       if(first.compareTo(SIMPLE_PAIR)==0) 
           return compareSimplePair(firstPlayHand, firstPlayRemining, secondPlayHand, secondPlayRemining);
       
       return compareHighCard(firstPlayHand, secondPlayHand);
    }
    
    
    
    private class CounterValue{
        public final Integer value;
        public Integer amount;

        public CounterValue(Integer value){
            this.value = value;
            this.amount = 1;
        }
    }
}
