import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card c1, Card c2) {
		if (c1.getRank() > c2.getRank())
			return 1;
		else if (c1.getRank() > c2.getRank())
			return -1;			
		return 0;
	}
	
	public boolean equals(Card c1, Card c2) {
		if (c1.getRank() == c2.getRank())
			return true;			
		return false;
	}

	
	
	
}
