
public class Card {

	private int rank;
	private String suit;
	private int cardVal;
	
	private final String ACE = "Ace";
	private final String JACK = "Jack";
	private final String QUEEN = "Queen";
	private final String KING = "King";
	private final String CLUBS = "clubs";
	private final String DIAMONDS = "diamonds";
	private final String HEARTS = "hearts";
	private final String SPADES = "spades";
	
	public Card() {
		
		rank = 1;
		suit = CLUBS;
		cardVal = setCardVal(1, CLUBS);
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
        		suit = CLUBS;
        		break;
        	case 1:	
        		suit = DIAMONDS;
        		break;
        	case 2:	
        		suit = HEARTS;
        		break;
        	case 3:	
        		suit = SPADES;
        		break;

   
		} 
		
		cardVal = setCardVal(rank, suit);
	}
	
	int setCardVal(int r, String s) {
		
		switch(s) {
		case CLUBS:
			return ((r-1)*4 + 1);
		case DIAMONDS:
			return ((r-1)*4 + 2);
		case HEARTS:
			return ((r-1)*4 + 3);
		case SPADES:
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
        case 1:		return ACE;
        case 2:		return "Two";
        case 3:		return "Three";
        case 4:		return "Four";
        case 5:		return "Five";
        case 6:		return "Six";
        case 7:		return "Seven";
        case 8:		return "Eight";
        case 9:		return "Nine";
        case 10:	return "Ten";
        case 11:	return JACK;
        case 12:	return QUEEN;
        case 13:	return KING;

        default: return null;
		} 
	}
	
	
	public int getSuitInt() {
		
		switch(suit) {
		case CLUBS:
			return 0;
		case DIAMONDS:
			return 1;
		case HEARTS:
			return 2;
		case SPADES:
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
