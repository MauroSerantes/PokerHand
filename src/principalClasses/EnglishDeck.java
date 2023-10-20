
package principalClasses;


import java.util.ArrayList;

import java.util.Collections;


public class EnglishDeck{
    public static final Integer CLUBS = 1;
    public static final Integer SPADES = 2;
    public static final Integer HEARTS = 3;
    public static final Integer DIAMONDS = 4;
    
    private final ArrayList<GamblingCard<Integer>> deck;
    private final ArrayList<GamblingCard<Integer>> removedCards;
    
    public EnglishDeck(){
    	deck = new ArrayList<>();
        removedCards = new ArrayList<>();
    	final Integer AMOUNT_OF_HOUSES = 4;
        final Integer AMOUNT_OF_CARDS_PER_HOUSE = 13;
		
        for(int i=1;i<=AMOUNT_OF_HOUSES;i++){
			
            for(int j=1;j<=AMOUNT_OF_CARDS_PER_HOUSE;j++){
		deck.add(new GamblingCard<>(i,j));
	    }
        }
	
        deck.add(new GamblingCard<>(0, 0));
	deck.add(new GamblingCard<>(0, 0));
    }
    
    
    public GamblingCard<Integer> removeTopCard(){
    	GamblingCard<Integer> removed = null;
    	
    	if(!deck.isEmpty()){
    	   removedCards.add(deck.get(deck.size()-1));
    	   removed = deck.remove(deck.size()-1);
    	}
    	
    	return removed;
    }
    
    
    public ArrayList<GamblingCard<Integer>> removeCardsOfDeck(Integer amount){
    	ArrayList<GamblingCard<Integer>> cards = null;
    	
    	if(amount > 0 && amount<=getCurrentAmountOfCards()) {
    	    cards = new ArrayList<>();
    		
    	    for(int i=0;i<amount;i++) {
                cards.add(removeTopCard());	
    	    }
    	}
    	
    	return cards;
    }
    
    public Integer getCurrentAmountOfCards(){
    	return deck.size();
    }
    
    public void shuffle(){
    	Collections.shuffle(deck);
    }
    
    public void restoreDeck(){
        while(!removedCards.isEmpty()){
            deck.add(removedCards.remove(0));
        }
    }
    
    public void restoreRemovedCardsWithTheExceptionOf(Integer conditionForSuits,Integer conditionForRanks){    	
    	for(int i=0;i<removedCards.size();i++) {	
	        GamblingCard<Integer> aux = removedCards.get(i);
        	
            if((conditionForSuits != null &&  aux.compareSuitOfCard(conditionForSuits)!=0)
                || (conditionForRanks != null  && aux.compareRankOfCard(conditionForRanks)!=0)){
        	deck.add(removedCards.remove(i));
        	i--;
            }
    	}
    	
    }
 
    public void removeCertainTypeOfCard(Integer conditionForSuits,Integer conditionForRanks){
        for(int i=0;i<deck.size();i++){
            GamblingCard<Integer> aux = deck.get(i);
        	
            if((conditionForSuits != null &&  aux.compareSuitOfCard(conditionForSuits)==0)
                || (conditionForRanks != null  && aux.compareRankOfCard(conditionForRanks)==0)){
        	removedCards.add(deck.remove(i));
        	i--;
            }
        	
        }
    }  

}
