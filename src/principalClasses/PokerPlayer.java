
package principalClasses;

import java.util.ArrayList;
import java.util.function.Consumer;


public class PokerPlayer{
    private Integer maxCardsInHand;
    private final ArrayList<GamblingCard<Integer>> handCards;
    private Integer money;

    public PokerPlayer(Integer initialMoney,Integer maxCardsInHand){
        this.money = initialMoney;
        this.maxCardsInHand = maxCardsInHand;
        this.handCards = new ArrayList<>(maxCardsInHand);
    }
    
    public void fillHand(EnglishDeck deck){
        while(handCards.size()<maxCardsInHand) {
            handCards.add(deck.removeTopCard());
        }
    } 
    
    public Integer amountOfCardsInHand(){
        return handCards.size();
    }
    
    public Integer remainingMoney(){
        return money;
    }
    
    public void betting(Integer amountOfBetMoney){
        if(amountOfBetMoney<=money) money -= amountOfBetMoney;
    }
    
    public GamblingCard<Integer> removeCardOfHand(Integer numberOfCard){
        return handCards.remove(numberOfCard-1);
    }
    
    public void traverseHand(Consumer<GamblingCard<Integer>> doSomething){
        for(int i=0;i<handCards.size();i++){
            GamblingCard<Integer> aux = handCards.get(i);
            doSomething.accept(aux);
        }
    }
}
