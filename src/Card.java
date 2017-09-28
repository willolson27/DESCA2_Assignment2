
public class Card {

	private int rank;
	private String suit;
	
	public Card() {
		
	}
	
	public String getSuit() {
		
		return suit;
		
	}
	
	public int getRank() {
		
		return rank;
		
	}
	
	public String getRankStr() {
		
		switch (rank) {
        case 1:		return "Ace";
        case 11:	return "Jack";
        case 12:	return "Queen";
        case 13:	return "King";

        default: return rank + "";
		}
		
	}
	
	
	
	
}
