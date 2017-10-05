import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	
	public CardComparator () {
		
		super();
	}
	
	@Override
	public int compare(Card c1, Card c2) {
		if (c1.getCardVal() > c2.getCardVal())
			return 1;
		else if (c1.getCardVal() < c2.getCardVal())
			return -1;			
		return 0;
	}
	
	public boolean equals(Card c1, Card c2) {
		if (c1.getCardVal() == c2.getCardVal())
			return true;			
		return false;
	}

	
	
	
}
