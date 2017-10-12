
public class DeckTest {
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: main
	 * 		-used to test all methods in Deck class
	 * @param args: String args[]
	 * @return: void
	 */
	
	public static void main(String args[]) {
		

		Deck shuffled = new Deck(false);
		Deck deck = new Deck();
		Deck testDeck = new Deck();
		
		System.out.println("Default \n" + deck);
		System.out.println(deck.pick() + "\n");
		System.out.println("Shuffled \n" + shuffled);
		
		System.out.println(deck.equals(testDeck) + "\n");
		System.out.println(deck.equals(shuffled) + "\n");
		
		Deck[] hands = deck.deal(4,13);
		
		for (int i = 0; i < hands.length; i++)
			System.out.println("Hand " + (i + 1) + "\n" + hands[i]);

	/*	Deck[] hands2 = deck.deal(5,13);
		for (int i = 0; i < hands2.length; i++)
			System.out.println("Hand " + i + "\n" + hands2[i] + "\n"); */
		
		deck.shuffle();
		System.out.println("Shuffled \n" + deck + "\n");
		deck.selectionSort();
		System.out.println("SelectionSort \n" + deck + "\n");
		deck.shuffle();
		System.out.println("Shuffled \n" + deck + "\n");
		deck.mergeSort();
		System.out.println("MergeSort \n" + deck + "\n");
		

		
		
	}
	
}
