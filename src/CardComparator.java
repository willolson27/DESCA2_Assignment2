import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	
	public CardComparator () {
		
		super();
	}
	
	@Override
	public int compare(Card c1, Card c2) {
		if (c1.getRank() > c2.getRank())
			return 1;
		if (c1.getRank() == c2.getRank()) {
			if (c1.getSuitInt() > c2.getSuitInt())
				return 1;
			else if (c1.getSuitInt() == c2.getSuitInt())
				return 0;
			else
				return -1;
		}	 
		return -1;
	}
	
	public boolean equals(Card c1, Card c2) {
		if (c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit())
			return true;			
		return false;
	}

	
	
	
}
