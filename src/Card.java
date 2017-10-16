
public class Card implements Comparable {

	private int rank;
	private String suit;

	
	private final String ACE = "Ace";
	private final String JACK = "Jack";
	private final String QUEEN = "Queen";
	private final String KING = "King";
	private final String CLUBS = "Clubs";
	private final String DIAMONDS = "Diamonds";
	private final String HEARTS = "Hearts";
	private final String SPADES = "Spades";
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Card (extra constructor)
	 * 		-creates default instance of card (ace of clubs)
	 * @param args: none
	 * @return: Card object
	 */
	public Card() {
		
		rank = 1;
		suit = CLUBS;

	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Card (extra constructor)
	 * 		-creates instance of card 
	 * @param args: string r (rank as string) , int s (suit as int)
	 * @return: Card object
	 */
	public Card (int s, String r) {
		
		suit = suitConv(s);
		rank = rankConv(r);

		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Card (extra constructor)
	 * 		-creates instance of card 
	 * @param args: int r (rank as int) , string s (suit as string)
	 * @return: Card object
	 */
	public Card (String s, int r) {
		
		rank = r;
		suit = s;

	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Card (extra constructor)
	 * 		-creates instance of card 
	 * @param args: string r (rank as string) , string s (suit as string)
	 * @return: Card object
	 */
	public Card (String s, String r) {
		
		suit = s;
		rank = rankConv(r);

		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Card (extra constructor)
	 * 		-creates instance of card 
	 * @param args: int r (rank as int) , int s (suit as int)
	 * @return: Card object
	 */
	public Card (int s, int r) {
		
		rank = r;
		
		suit = suitConv(s);
		

	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: suitConv
	 * 		-converts suit from int to string
	 * @param args: int s (suit)
	 * @return: string  of suit
	 */
	String suitConv (int s) {
		
		switch (s) {
    	case 0: 
    		return CLUBS;
    	case 1:	
    		return DIAMONDS;
    	case 2:	
    		return HEARTS;
    	case 3:	
    		return SPADES;
    	default: return null;

		}
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: rankConv
	 * 		-converts rank from string to int
	 * @param args: String r (rank)
	 * @return: integer of rank
	 */
	int rankConv (String r) {
		
		switch (r.toLowerCase()) {
		case ACE: 		return 1;
		case "two": 	return 2;
		case "three": 	return 3;
		case "four":	return 4;
		case "five":	return 5;
		case "six":		return 6;
		case "seven":	return 7;
		case "eight":	return 8;
		case "nine":	return 9;
		case "ten":		return 10;
		case JACK:		return 11;
		case QUEEN:		return 12;
		case KING:		return 13;
			
		default: return -1;
		}
		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: getSuit
	 * 		-returns suit
	 * @param args: none
	 * @return: card's suit
	 */
	public String getSuit() {
		
		return suit;
		
	}
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: getRank
	 * 		-returns rank
	 * @param args: none
	 * @return: rank of card
	 */
	public int getRank() {
		
		return rank;
		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: getRankString
	 * 		-returns rank as string
	 * @param args: none
	 * @return: string corresponding to the object's rank
	 */
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
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: getSuitInt
	 * 		-returns suit as int
	 * @param args: none
	 * @return: integer corresponding to the object's suit
	 */
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
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: toString
	 * 		-returns the card's rank and suit values
	 * @param args: none
	 * @return: String containing the Card's rank and suit
	 */
	
	public  String toString() {
		
		return (getRankStr() + " of " + getSuit());
		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: equals
	 * 		-checks if this card is equal to another
	 * @param args: Card otherCard
	 * @return: int - 1 if this is greater to o1, -1 of this is less than o1, 0 if equal
	 */
	public boolean equals(Card otherCard) {
		
		if (this.getRank() == otherCard.getRank() && this.getSuit().equals(otherCard.getSuit()))
			return true;
		else
			return false;
		
	}

	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: compareTo (no @override)
	 * 		-compares this card to another
	 * @param args: Card c1
	 * @return: int - 1 if this is greater to o1, -1 of this is less than o1, 0 if equal
	 */
	public int compareTo(Card c1) {
		if (this.getSuitInt() > c1.getSuitInt())
			return 1;
		if (this.getSuitInt() == c1.getSuitInt()) {
			if (this.getRank() > c1.getRank())
				return 1;
			else if (this.getRank() == c1.getRank())
				return 0;
			else
				return -1;
		}	 
		return -1;
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: compareTo (@override)
	 * 		-compares this card to another
	 * @param args: Object o1
	 * @return: int - 1 if this is greater to o1, -1 of this is less than o1, 0 if equal
	 */
	@Override
	public int compareTo(Object o1) {
		if (o1 instanceof Card != true)
			return -1;
		Card c1 = ((Card)o1);
		if (this.getSuitInt() > c1.getSuitInt())
			return 1;
		if (this.getSuitInt() == c1.getSuitInt()) {
			if (this.getRank() > c1.getRank())
				return 1;
			else if (this.getRank() == c1.getRank())
				return 0;
			else
				return -1;
		}	 
		return -1;
	}
	
	
	
	
}
