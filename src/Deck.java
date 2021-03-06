
import java.util.Random;

public class Deck {

	//create constants
	private final int DECKSIZE = 52;
	private final int NUMRANKS = 13;
	private final int NUMSUITS = 4;
	
	//create fields
	private  Card[] deck = new Card[DECKSIZE];
	//deck used for sorts
	private Card[] temp = new Card[DECKSIZE];
	
	//index of top card in deck
	private int topCard;
	private boolean sorted;
	
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: Deck (default Constructor)
	 * 		-used to create a default deck
	 * @param args: none
	 * @return: new default Deck
	 */
	
	public Deck () {
		
		newDeck();
		
		topCard = deck.length - 1;
		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Deck (extra Constructor)
	 * 		-used to create sorted or shuffled deck
	 * @param args: boolean isSorted - tells if user wants deck to be sorted ro not
	 * @return: new sorted/shuffled Deck
	 */
	public Deck (boolean isSorted) {
		
		newDeck();
		topCard = deck.length - 1;
		
		if (isSorted == false) {
			this.shuffle();
		}

		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: Deck (extra Constructor)
	 * 		-used to create hand of cards
	 * @param args: Card[] hands -array of cards
	 * @return: new small Deck, part of bigger deck
	 */
	public Deck (Card[] hands) {
		
		deck = hands;
		topCard = hands.length - 1;
		sorted = false;
	}
	
	/**
	 * 
	 * @user willolson27
	 * @date October 16, 2017
	 * @method newDeck
	 * 		-creates a new default Deck, called from the constructors so that code is not repeated
	 * @return void
	 * 
	 */
	private void newDeck() {
		
		int a = 0;
		for (int j = 0; j < NUMSUITS; j++) {
			for (int i = 1; i < (NUMRANKS + 1); i++) {
				deck[a] = new Card(j, i);
				a++;
			}
		}
		sorted = true;
		
	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: shuffle
	 * 		-used shuffle a deck
	 * @param args: Card[] Deck - a Deck of Cards
	 * @return: none
	 */
	public void shuffle() {
		
		Random rand = new Random();
		
		for (int i = 0; i < topCard + 1; i++) {
			for (int j = 0 ; j < topCard + 1; j++) {
				int randPos = rand.nextInt(topCard + 1);
				Card temp = deck[j];
				deck[j] = deck[randPos];
				deck[randPos] = temp;
			}
		}
		sorted = false;
	
	}
	
	/**
	 * @user willolson27
	 * @date October 16, 2017
	 * @method downShift
	 * 		-moves all the values in  the Deck down a slot, starting at param  pos
	 * @param pos
	 */
	public void downShift (int pos) {
		
		for (int i = pos; i < deck.length; i++) {
			if (i < topCard)
				deck[i] = deck[i + 1];
			else{
				deck[i] = null;
				topCard = i - 1;
				break;
				}
			}

		
	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: toString
	 * 		-used to print out a deck
	 * @param args: none
	 * @return: list of all cards in the deck
	 */
	public  String toString() {
		
		String toOutput = "";
		if (topCard == -1) 
			return "*No Cards left in deck*";
		for (int i = 0 ; i < topCard + 1; i++) {
			if (topCard + 1 == DECKSIZE && sorted == true){
				for (int j = 0; j < NUMRANKS; j++) {
					int l = deck[j].getRank();
					for (int k = 0; k < NUMSUITS; k++) {
						
						toOutput += ( deck[NUMRANKS * k + (l-1)] + "\t");
					}
					
						toOutput += "\n";
				}
				break;
			}
			else if (topCard + 1 == DECKSIZE) {
				toOutput += (deck[i].toString() + "\t");
				//create a new row
				if ((i + 1) % 4 == 0)
					toOutput += "\n";
			}
			else	
				toOutput += (deck[i].toString() +"\n");
		}
		return toOutput;
	}
	/*
	//fix an indentation error
	if (deck[i].getSuit() == "diamonds" && (deck[i].getRank() != 6 && deck[i].getRank() != 10 &&  deck[i].getRank() !=1 &&  deck[i].getRank() !=2)) {
		toOutput+= (deck[i].toString() +"\t");
		//create a new row
		if ((i + 1) % 4 == 0)
			toOutput += "\n";
	}
	else {
	toOutput+= (deck[i].toString() +"\t\t");
	//create a new row
		if ((i + 1) % 4 == 0)
			toOutput += "\n";
	}
	*/
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: pick
	 * 		-picks a random card from the deck
	 * @param args: none
	 * @return: random card
	 */
	public Card pick() {
		
		Random rand = new Random();
		int randPos = rand.nextInt(topCard + 1);
		Card randCard = deck[randPos];
		downShift(randPos);
		
		
		return randCard;
		
	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: getDeck
	 * 		-returns the deck field
	 * @param args: none
	 * @return: a deck of cards
	 */    
	public Card[] getDeck() {
		
		return deck;
	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: equals
	 * 		-checks if this deck is equal to another
	 * @param args: Deck otherD- other Deck
	 * @return: boolean - true if equal, false if not
	 */
	public boolean equals (Deck otherD) {
		
		Deck temp = new Deck(this.deck);
		Deck tempB = new Deck(otherD.deck);
		temp.selectionSort();
		tempB.selectionSort();
		if (temp.topCard != tempB.topCard)
			return false;
		for (int i = 0; i <= temp.topCard; i++) {
			if (temp.getDeck()[i].equals(tempB.getDeck()[i]) == false)
				return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: deal
	 * 		-used to return an array of hands
	 * @param args: int numHands - number of hands, int numCards - cards per hand
	 * @return: array of hands (small subdecks)
	 */
	public Deck[] deal (int numHands, int numCards) {
		
		Deck[]hands = new Deck[numHands];
		Card[][] tempDecks = new Card[numHands][numCards];
		
		Deck temp = this;
		temp.shuffle();
		int a = topCard;
		if (DECKSIZE - (numHands * numCards) >= 0) {
			for (int i = 0; i < numCards; i++) {
				for (int j = 0; j < numHands; j++) {
					if (a >= 0) {
						tempDecks[j][i] = temp.deck[a];
						topCard--;
					}
					a--;
				}
			}
		}
		else
			return null;
		
		for (int k = 0; k < numHands; k++) {
			hands[k] = new Deck (tempDecks[k]);
		}
		
		return hands;

	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: selectionSort
	 * 		-used to sort this deck to the default
	 * @param args: none
	 * @return: none
	 */
	public void selectionSort() {
		
		
		
		for (int i = topCard + 1; i > 1; i--) {
			int iMax = 0;
			for (int j = 1; j < i; j++) {
				if (deck[j] != null) {
					if (deck[j].compareTo(deck[iMax]) == 1)
						iMax = j;
				}
	
			}
			
			Card temp = deck[iMax];
			deck[iMax] = deck[i - 1];
			deck[i - 1] = temp;
			
		}
		
		sorted = true;
		
	}
	
	/**
	 * 
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: mergeSort
	 * 		-used to sort a deck to the default
	 * @param args: Card[] deck - deck to be sorted
	 * @return: none
	 */
	public void mergeSort () {
		
		int n = topCard + 1;
		temp = new Card[n];
		recurse(deck , 0, n - 1);
		sorted = true;
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: recurse
	 * 		-recursive helper method for mergeSort
	 * @param args: Card[] deck, int from - starting point, int to - ending point
	 * @return: none
	 */
	private void recurse (Card[] deck, int from, int to) {
	
		CardComparator comp = new CardComparator();
			
		if (to - from < 2) {
			if (to > from && (comp.compare(deck[to], deck[from]) == -1)) {
				Card cardTemp = deck[to];
				deck[to] = deck[from];
				deck[from] = cardTemp;
			}		
		}
		else {
			int middle = (from + to) / 2;
			recurse(deck, from, middle);
			recurse(deck, middle + 1, to);
			merge(deck, from, middle, to);
		}
		
		
	}
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @method: merge
	 * 		-merging helper method for mergeSort
	 * @param args: Card[]deck - deck to be sorted, int from - starting point, int middle - middle point, int to - end point
	 * @return: none
	 */
	private void merge (Card[] deck, int from, int middle, int to) {
		int i = from;
		int j = middle + 1;
		int k = from;
		
		
		//set first part of temp array
		while (i <= middle && j <=to) {
			if (deck[i].compareTo(deck[j]) == -1) {
				temp[k] = deck[i];
				i++;
			}
			else {
				temp[k] = deck[j];
				j++;
			}
			k++;		
		}
		//set second part of temp array
		while (i <= middle && k != DECKSIZE) {
			temp[k] = deck[i];
			i++;
			k++;
		}
		
		//set third part of temp array
		while (j <= to && k != DECKSIZE) {
			temp[k] = deck[j];
			j++;
			k++;
		}
		
		//merge back into deck
		for (k = from; k <= to; k++)
			deck[k] = temp[k];
		
		this.deck = deck;
		
	}
	
		

}
