import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays; //ONLY USED TO DOUBLE CHECK WITH SELECTION AND MERGE SortS

public class DeckTest {
	
	/**
	 * 
	 * @user:willolson27
	 * @date: October 11, 2017
	 * @method
	 * 	-creates a PrintWriter to be written to the output file
	 * @param String f
	 * @return PrintWriter (used to print to output file)
	 */
	public static PrintWriter makeWriter(String f) {
		
		File file = new File(f);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Can't open file " + f);
			return null;
		}
		
		return out;
	}
	
	/**
	 *
	 * @user: willolson27
	 * @date: October 16, 2017
	 * @ method: writeJava
	 * 		-used to write to output.txt file
	 * @param toOutput
	 * @param output
	 */
	public static void writeJava(String [] toOutput, PrintWriter output) {
		
		for (int i = 0; i < toOutput.length; i++) {
			if (toOutput[i] != null)
				output.println(toOutput[i]);
			
		}
		
		output.close();
		 
	}
	
	
	/**
	 * 
	 * @user: willolson27
	 * @date: October 4, 2017
	 * @ method: main
	 * 		-used to test all methods in Deck class
	 * @param args: String args[]
	 * @return: void
	 */
	
	public static void main(String args[]) {
		
		//local variables 
		String pb = "**************************";
		String[] toOutput = new String[21];
		PrintWriter output = makeWriter("output.txt");
		
		//decks for testing
		Deck deckA = new Deck();
		Deck deckC = new Deck(false);
		Deck deckB = new Deck();
		
		//DECK A - print default, the shuffled, then print each sort
		toOutput[0] = ("\n" + pb + "Deck A" + pb + "\n" + deckA + "\n");
		deckA.shuffle();
		toOutput[1] = ("\n" + pb + "Deck A, shuffled" + pb + "\n" + deckA + "\n");
		deckA.selectionSort();
		toOutput[2] = ("\n" + pb + "Deck A, selectionSorted" + pb + "\n" + deckA + "\n");
		deckA.shuffle();
		toOutput[3] = ("\n" + pb + "Deck A, reshuffled" + pb + "\n" + deckA + "\n");
		Arrays.sort(deckA.getDeck());
		toOutput[4] = ("\n" + pb + "Deck A, Arrays.sort sorted" + pb + "\n" + deckA + "\n");
		deckA.shuffle();
		toOutput[5] = ("\n" + pb + "Deck A, reshuffled" + pb + "\n" + deckA + "\n");
		deckA.mergeSort();
		toOutput[6] = ("\n" + pb + "Deck A, merge sorted" + pb + "\n" + deckA + "\n");
		
		
		//DECK B - remove cards and shuffle and sort
		toOutput[7] = ("\n" + pb + "Deck B" + pb + "\n" + deckB + "\n");
		Card picked = deckB.pick();
		
		toOutput[8] = ("\n" + pb + "Deck B with removed card" + pb + "\n" + deckB + "\n\n" + picked + "\n");
		deckB.shuffle();
		toOutput[9] = ("\n" + pb + "Deck B with removed card, shuffled" + pb + "\n" + deckB + "\n\n" + picked + "\n");
		deckB.mergeSort();
		toOutput[10] = ("\n" + pb + "Deck B with removed card, merge sorted" + pb + "\n" + deckB + "\n\n" + picked + "\n");
		String pck = "";
		for (int i = 0 ; i < 51; i++)
			pck += (deckB.pick()).toString() + "\n";
		deckB.shuffle();
		toOutput[11] = ("\n" + pb + "Deck B with many removed cards, shuffled" + pb + "\n" + deckB + "\n\n" + picked + "\n" + pck + "\n");
		deckB.mergeSort();
		toOutput[12] = ("\n" + pb + "Deck B with many removed cards, merge sorted" + pb + "\n" + deckB + "\n\n" + picked + "\n" + pck + "\n");

		//DECK C - start as shuffled, merge sort
		toOutput[13] = ("\n" + pb + "Deck C" + pb + "\n" + deckC + "\n");
		deckC.mergeSort();
		toOutput[14] = ("\n" + pb + "Deck C, merge sorted" + pb + "\n" + deckC + "\n");
		
		//EQUALS TEST
		String a = ("\n" + pb + "Equals Test" + pb);
		toOutput[15] = (a + "\n" + "Does deck C equal deck A?\t" + deckC.equals(deckA) + "\n");
		toOutput[16] = ("\n" + "Does deck C equal deck B?\t" + deckC.equals(deckB) + "\n");

		//Deal hands - print of dealt hands
		Deck[] hands = deckA.deal(4, 13);
		String b = "";
		for (int i = 0; i < hands.length; i++) {
			b += ("\nHand " + (i+1) + "\n\n"  + hands[i]);
		}
		toOutput[17] = ("\n" + pb + "Dealt Hands" + pb + b);
		
		
		hands[0].selectionSort();
		toOutput[18] = ("\nHand 1, sorted" + "\n\n"  + hands[0]);
		hands[0].shuffle();
		toOutput[19] = ("\nHand 1, reshuffled" + "\n\n"  + hands[0]);
		toOutput[20] = "\n" + pb + "Deck A after dealt" + pb + "\n" + deckA;
		
		writeJava(toOutput, output);


		
		
	}
	
}
