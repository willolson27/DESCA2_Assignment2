import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	/**
	 * 
	 * @user:willolson27
	 * @date: October 16, 2017
	 * @method:CardComparator
	 * 		-creates a new CardComparator
	 */
	public CardComparator () {
		
		super();
	}
	/**
	 * 
	 * @user willolson2
	 * @method compare
	 * 		-compares values of two cards
	 * @param c1
	 * @param c2
	 * @return int for difference between c1 and c2
	 */
	@Override
	public int compare(Card c1, Card c2) {
		if (c1.getSuitInt() > c2.getSuitInt())
			return 1;
		if (c1.getSuitInt() == c2.getSuitInt()) {
			if (c1.getRank() > c2.getRank())
				return 1;
			else if (c1.getRank() == c2.getRank())
				return 0;
			else
				return -1;
		}	 
		return -1;
	}
	/**
	 * 
	 * @user willolson2
	 * @method equals
	 * 		-checks if two cards are equal
	 * @param c1
	 * @param c2
	 * @return boolean for if c1 equals c2
	 */
	public boolean equals(Card c1, Card c2) {
		if (c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit())
			return true;			
		return false;
	}

	
	
	
}
