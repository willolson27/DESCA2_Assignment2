import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CardTest {
	
	
	
	
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
	 * 		-used to test methods in Card class
	 * @param args: String args[]
	 * @return: void
	 */
	public static void main(String args[]) {
		
		//note - order is suit, rank for all constructors
		
		//local variables
		String[] toOutput = new String[6];
		String pb = "**************************";
		
		PrintWriter out = makeWriter("output.txt");
		
		//test default constructor
		Card card = new Card(0,1);
		toOutput[0] = ("\n\t" + pb + "Default Constructor" + pb + "\n" + card);	
		
		//Test string, string constructor
		Card card1 = new Card("spades", "ten");
		toOutput[1] = ("\n\t" + pb + "String, String Constructor" + pb + "\n" + card1);	
		
		//Test int, int constructor
		Card card2 = new Card(3, 10);
		toOutput[2] = ("\n\t" + pb + "Int, Int Constructor" + pb + "\n" + card2);	
		
		//test string, int constructor
		Card card3 = new Card("spades" , 12);
		toOutput[3] = ("\n\t" + pb + "String, int Constructor" + pb + "\n" + card3);	
		
		//test int, string constructor
		Card card4 = new Card(2, "ten");
		toOutput[4] = ("\n\t" + pb + "Int, String Constructor" + pb + "\n" + card4);	
		
		//test equals and compare
		toOutput[5] = (("\n\t" + pb + "Test equals and compare" + pb + "\n"));
		boolean oneTwo = card1.equals(card2);
		boolean oneThree = card1.equals(card3);
		int compareOneZilch = card1.compareTo(card);
		int compareOneTwo = card1.compareTo(card2);
		int compareOneThree = card1.compareTo(card3);
		toOutput[5] += ((oneTwo + "\n" + oneThree + "\n" + compareOneZilch + "\n" + compareOneTwo + "\n" + compareOneThree));	
		
		
		//write to file
		writeJava(toOutput, out);
	}
	
}
