
public class Deck {

	private static Card[] deck = new Card[52];
	private Card topCard = deck[deck.length - 1];
	
	public Deck () {
		
		int a = 0;
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				deck[a] = new Card(j, i);
				a++;
			}
		}
		
	}
	
	public Deck (boolean isShuffled) {
		
	}
	
	public void shuffle() {
		
		
	}
	
	public static String toStrings() {
		
		String toOutput = "";
		for (int i = 0 ; i < 52; i++)
			toOutput+= (deck[i].toString() +"\n");
		return toOutput;
	}
	
	/*public Card pick() {
		
	}*/
	
	
	
}
