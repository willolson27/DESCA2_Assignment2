
public class Card {

	private int rank;
	private String suit;
	
	public Card() {
		
	}
	
	public Card (int s, String r) {
		
	}
	
	public Card (String s, int r) {
		
	}
	
	public Card (String s, String r) {
		
		
		
	}
	
	public Card (int s, int r) {
		
		rank = r;
		
		switch (s) {
        	case 0: 
        		suit = "clubs";
        	case 1:	
        		suit = "diamonds";
        	case 2:	
        		suit = "hearts";
        	case 3:	
        		suit = "spades";

   
		} 
		
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
	
	public int getSuitInt() {
		
		switch(suit) {
		case "clubs":
			return 0;
		case "diamonds":
			return 1;
		case "hearts":
			return 2;
		case "spades":
			return 3;
			
		default : return -1;
		}
		
	}
	
	public String toString() {
		
		return (getRankStr() + " of " + getSuit());
		
	}
	
	public boolean equals(Card otherCard) {
		
		if (this.getRank() == otherCard.getRank() && this.getSuit() == otherCard.getSuit())
			return true;
		else
			return false;
		
	}
	
	
	
}
