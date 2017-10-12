
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	private final int deckSize = 52;
	private final int numRanks = 13;
	private final int numSuits = 4;
	private  Card[] deck = new Card[deckSize];
	private int topCard = deck.length - 1;
	
	private Card[] temp = new Card[deckSize];
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: Deck (default Constructor)
	 * 		-used to create a default deck
	 * @param args: none
	 * @return: new default Deck
	 */
	
	public Deck () {
		
		int a = 0;
		for (int i = 1; i < (numRanks + 1); i++) {
			for (int j = 0; j < numSuits; j++) {
				deck[a] = new Card(j, i);
				a++;
			}
		}
		
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: Deck (extra Constructor)
	 * 		-used to create sorted or shuffled deck
	 * @param args: boolean isSorted - tells if user wants deck to be sorted ro not
	 * @return: new sorted/shuffled Deck
	 */
	public Deck (boolean isSorted) {
		
		int a = 0;
		for (int i = 1; i < (numSuits + 1); i++) {
			for (int j = 0; j < numRanks; j++) {
				deck[a] = new Card(j, i);
				a++;
			}
		}
		
		if (isSorted == false) {
			this.shuffle();
		}

		
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: Deck (extra Constructor)
	 * 		-used to create hand of cards
	 * @param args: Card[] hands -array of cards
	 * @return: new small Deck, part of bigger deck
	 */
	public Deck (Card[] hands) {
		
		deck = hands;
		
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: shuffle
	 * 		-used shuffle a deck
	 * @param args: Card[] Deck - a Deck of Cards
	 * @return: none
	 */
	public void shuffle() {
		
		Random rand = new Random();
		
		for (int i = 0 ; i< deck.length; i++) {
		    int randPos = rand.nextInt(deck.length);
		    Card temp = deck[i];
		    deck[i] = deck[randPos];
		    deck[randPos] = temp;
		}
		
	//	this.deck = deck;
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: toString
	 * 		-used to print out a deck
	 * @param args: none
	 * @return: list of all cards in the deck
	 */
	public  String toString() {
		
		String toOutput = "";
		for (int i = 0 ; i < deck.length; i++) {
			if (deck.length == deckSize){
				if (deck[i].getSuit() == "diamonds" && (deck[i].getRank() != 6 && deck[i].getRank() != 10 &&  deck[i].getRank() !=1 &&  deck[i].getRank() !=2)) {
					toOutput+= (deck[i].toString() +"\t");
					if ((i + 1) % 4 == 0)
						toOutput += "\n";
				}
				else {
				toOutput+= (deck[i].toString() +"\t\t");
					if ((i + 1) % 4 == 0)
						toOutput += "\n";
				}
			}
			else
				toOutput += (deck[i].toString() +"\n");
		}
		return toOutput;
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: pick
	 * 		-picks a random card from the deck
	 * @param args: none
	 * @return: random card
	 */
	public Card pick() {
		
		Random rand = new Random();
		int randPos = rand.nextInt(deck.length);
		Card randCard = deck[randPos];
		return randCard;
		
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: getDeck
	 * 		-returns the deck field
	 * @param args: none
	 * @return: a deck of cards
	 */
	public Card[] getDeck() {
		
		return deck;
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: equals
	 * 		-checks if this deck is equal to another
	 * @param args: Deck otherD- other Deck
	 * @return: boolean - true if equal, false if not
	 */
	public boolean equals (Deck otherD) {
		
		Card[] deck = otherD.getDeck();
		if (this.deck.length != deck.length)
			return false;
		for (int i = 0; i < deck.length; i++) {
			if (this.deck[i].equals(deck[i]) == false)
				return false;
		}
		return true;
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: deal
	 * 		-used to return an array of hands
	 * @param args: int numHands - number of hands, int numCards - cards per hand
	 * @return: array of hands (small subdecks)
	 */
	public Deck[] deal (int numHands, int numCards) {
		
		
		Deck[] hands = new Deck[numHands];
		this.shuffle();
		if (deckSize - (numHands * numCards) >= 0) {
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
		else
			return null;
		
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: selectionSort
	 * 		-used to sort this deck to the default
	 * @param args: none
	 * @return: none
	 */
	public void selectionSort() {
		
		CardComparator comp = new CardComparator();
		
		for (int i = deck.length; i > 1; i--) {
			int iMax = 0;
			for (int j = 1; j < i; j++) {
				if (comp.compare(deck[j], deck[iMax]) == 1)
					iMax = j;
			}
			
			Card temp = deck[iMax];
			deck[iMax] = deck[i - 1];
			deck[i - 1] = temp;
			
		}
	}
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: mergeSort
	 * 		-used to sort a deck to the default
	 * @param args: Card[] deck - deck to be sorted
	 * @return: none
	 */
	public void mergeSort () {
		
		int n = deck.length;
		temp = new Card[n];
		recurse(deck , 0, n - 1);
	
	}
	
	/*
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
	
	/*
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: merge
	 * 		-merging helper method for mergeSort
	 * @param args: Card[]deck - deck to be sorted, int from - starting point, int middle - middle point, int to - end point
	 * @return: none
	 */
	private void merge (Card[] deck, int from, int middle, int to) {
		int i = from;
		int j = middle + 1;
		int k = from;
		
		CardComparator comp = new CardComparator();
		
		while (i <= middle && j <=to) {
			if (comp.compare(deck[i], deck[j]) == -1) {
				temp[k] = deck[i];
				i++;
			}
			else {
				temp[k] = deck[j];
				j++;
			}
			k++;		
		}
		while (i <= middle && k != deckSize) {
			temp[k] = deck[i];
			i++;
			k++;
		}
		while (j <= to && k != deckSize) {
			temp[k] = deck[j];
			j++;
			k++;
		}
		
		for (k = from; k <= to; k++)
			deck[k] = temp[k];
		
		this.deck = deck;
		
	}
	
	public static PrintWriter makeWriter(String f) {
		
		File file = new File(f);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Cant open file " + f);
			return null;
		}
		
		return out;
	}
	
	public static void writeJava(Scanner input, PrintWriter output) {
		
		while (input.hasNextLine()) {
			String word = input.nextLine();
			
			if (word.length() >= 1 && word.length() <=16) {
			output.println("\t\"" + word + "\",");
			}
		}
	}
	
		

}
