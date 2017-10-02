
public class DeckTest {

	public static void main(String args[]) {
		
	/*	Deck deck = new Deck(true);
		Deck testDeck = new Deck();
		Deck shuffled = new Deck(false);
		System.out.println(deck);
		System.out.println(deck.pick());
		
		System.out.println("\n" + shuffled);
		System.out.println(deck.equals(testDeck));
		*/
		
		Deck deck2 = new Deck(false);
		System.out.println(deck2);
		deck2.selectionSort();
		System.out.println(deck2);
		
		
	}
	
}
