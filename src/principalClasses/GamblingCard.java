

package principalClasses;


public class GamblingCard<T extends Comparable<T>>{
	private T suit;
	private Integer rank;

	public GamblingCard(T suit,Integer rank){
	    this.suit = suit;
	    this.rank = rank;
	}
	
	public T getSuitOfCard(){
            return suit;
        }
        
        public Integer getRankOfCard(){
            return rank;
        }
        
        public int compareRankOfCard(Integer value){
            return rank.compareTo(value);
        }
        
        public int compareSuitOfCard(T value){
            return suit.compareTo(value);
        }
}
