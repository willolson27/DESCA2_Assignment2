import java.util.Random;

public class Deck {

	private  Card[] deck = new Card[52];
	private Card topCard = deck[deck.length - 1];
	private int deckSize = 52;
	
	public Deck () {
		
		int a = 0;
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				deck[a] = new Card(i, j);
				a++;
			}
		}
		
	}
	
	public Deck (boolean isSorted) {
		
		int a = 0;
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				deck[a] = new Card(i, j);
				a++;
			}
		}
		
		if (isSorted == false) {
			this.shuffle(deck);
		}

		
	}
	
	public Deck (Card[] hands) {
		
		deck = hands;
		
	}
	
	public void shuffle(Card[] deck) {
		
		Random rand = new Random();
		
		for (int i = 0 ; i< deck.length; i++) {
		    int randPos = rand.nextInt(deck.length);
		    Card temp = deck[i];
		    deck[i] = deck[randPos];
		    deck[randPos] = temp;
		}
		
		this.deck = deck;
	}
	
	public  String toString() {
		
		String toOutput = "";
		for (int i = 0 ; i < deck.length; i++) {
			if (deck.length == deckSize){
				toOutput+= (deck[i].toString() +"\t\t");
					if ((i + 1) % 4 == 0)
						toOutput += "\n";
			}
			else
				toOutput += (deck[i].toString() +"\n");
		}
		return toOutput;
	}
	
	public Card pick() {
		
		Random rand = new Random();
		int randPos = rand.nextInt(deck.length);
		Card randCard = deck[randPos];
		return randCard;
		
	}
	
	public Card[] getDeck() {
		
		return deck;
	}
	
	public boolean equals (Deck otherD) {
		
		Card[] deck = otherD.getDeck();
		for (int i = 0; i < deck.length; i++) {
			if (this.deck[i].getRank() != deck[i].getRank() || this.deck[i].getSuit() != deck[i].getSuit())
				return false;
		}
		return true;
	}
	
	public Deck[] deal (int numHands, int numCards) {
		
		
		Deck[] hands = new Deck[numHands];
		this.shuffle(deck);
		
		int a = 0;
		for (int i = 0; i < numHands; i++) {
			Card[] tempDeck = new Card[numCards];
			for (int j = 0; j < numCards; j++) {
				tempDeck[j] = this.deck[a];
				a++;
			}
			hands[i] = new Deck(tempDeck);
	
		}
		
		return hands;
		
	}
	
	public void selectionSort() {
		
		for (int i = deck.length; i > 1; i--) {
			int iMax = 0;
			for (int j = 1; j < i; j++) {
				if (deck[j].getCardVal() > deck[iMax].getCardVal())
					iMax = j;
			}
			
			Card temp = deck[iMax];
			deck[iMax] = deck[i - 1];
			deck[i - 1] = temp;
			
		}
	}
	
	public void mergeSort
	
		

}
