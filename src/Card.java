
public class Card {

	private int rank;
	private String suit;
	private int cardVal;
	
	public Card() {
		
		rank = 1;
		suit = "clubs";
		cardVal = setCardVal(1, "clubs");
	}
	
	public Card (int s, String r) {
		
		
		
	}
	
	public Card (String s, int r) {
		
		rank = r;
		suit = s;
		
	}
	
	public Card (String s, String r) {
		
		
		
	}
	
	public Card (int r, int s) {
		
		rank = r;
		
		switch (s) {
        	case 0: 
        		suit = "clubs";
        		break;
        	case 1:	
        		suit = "diamonds";
        		break;
        	case 2:	
        		suit = "hearts";
        		break;
        	case 3:	
        		suit = "spades";
        		break;

   
		} 
		
		cardVal = setCardVal(rank, suit);
	}
	
	int setCardVal(int r, String s) {
		
		switch(s) {
		case "clubs":
			return ((r-1)*4 + 1);
		case "diamonds":
			return ((r-1)*4 + 2);
		case "hearts":
			return ((r-1)*4 + 3);
		case "spades":
			return ((r-1)*4 + 4);
			
		default : return -1;
		}
		

	}
	
	public int getCardVal() {
		return cardVal;
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
	
	public  String toString() {
		
		return (getRankStr() + " of " + getSuit());
		
	}
	
	public boolean equals(Card otherCard) {
		
		if (this.getRank() == otherCard.getRank() && this.getSuit() == otherCard.getSuit())
			return true;
		else
			return false;
		
	}
	
	
	
	
}
