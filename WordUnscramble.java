import java.util.*;
import java.io.*;

public class WordUnscramble{
	//fields
	private Random random;
	private ArrayList<String> wordBank;
	private String currentWord;
	private String scrambledWord;
	private int tries;
	
	//constructor
	public WordUnscramble(){
		setRandom();
		setWordBank();
		setCurrentWord();
		setScrambledWord(currentWord);
		playGame(5);
	}
	
	//setters
	public void setRandom(){
		random = new Random();	
	}
	
	public void setWordBank(){
		wordBank = new ArrayList<String>();	
		wordBank.add("playoffs");
		wordBank.add("crossbar");
		wordBank.add("trapezoid");
		wordBank.add("goaltender");
		wordBank.add("slapshot");
		wordBank.add("wrister");
		wordBank.add("intermission");
		wordBank.add("offside");
		wordBank.add("icing");
		wordBank.add("penalty");
		wordBank.add("powerplay");
		wordBank.add("breakaway");
		wordBank.add("captain");
		wordBank.add("jersey");
	}
	
	public void setCurrentWord(){
		currentWord = wordBank.get(getRandom().nextInt(wordBank.size()));
	}
	
		public void setScrambledWord(String wts){
		StringBuilder wordToScramble = new StringBuilder(wts);
			for(int i=0; i<wordToScramble.length(); i++){
				//randomly select two chars in word
				Integer randomIndex = getRandom().nextInt(wordToScramble.length());
				Character randomChar = wordToScramble.charAt(randomIndex);		
				Integer anotherRandomIndex = getRandom().nextInt(wordToScramble.length());
				Character anotherRandomChar = wordToScramble.charAt(anotherRandomIndex);
				//swap chars
				wordToScramble.deleteCharAt(randomIndex);
				wordToScramble.insert(randomIndex, Character.toString(anotherRandomChar));
				wordToScramble.deleteCharAt(anotherRandomIndex);
				wordToScramble.insert(anotherRandomIndex, Character.toString(randomChar));
			}
		scrambledWord = wordToScramble.toString();
	}
	
	public void setTries(int t){
		tries = t;	
	}
	
	//getters
	public Random getRandom(){
		return random;	
	}
	
	public ArrayList<String> getWordBank(){
		return wordBank;	
	}
	
	public String getCurrentWord(){
		return currentWord;	
	}
	
	public String getScrambledWord(){
		return scrambledWord;	
	}
	
	public int getTries(){
		return tries;	
	}
	
	//method to evaluate user entry and determine if incorrect, if incorrect and out of guesses, or if correct
	public void playGame(int maxTries){
		System.out.println("*******************************\nWelcome to Word Unscramble!\n*******************************\n");
		System.out.println("SCRAMBLED WORD: " + getScrambledWord().toUpperCase() );
		System.out.println("You have at most " + maxTries + " tries to enter the original word.");
		StringBuilder userEntry = new StringBuilder();
		BufferedReader readUserEntry = new BufferedReader(new InputStreamReader(System.in)); 	
		
		do{
			try{
				System.out.print((tries + 1) + ") Unscrambled, the word is: ");
				userEntry.delete(0, userEntry.length());
				userEntry.append(readUserEntry.readLine().trim());	
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + ".");
			}	
			if(userEntry.toString().equalsIgnoreCase(getCurrentWord())==false){
				tries++;
				if((userEntry.toString().equalsIgnoreCase(getCurrentWord()) ^ tries == maxTries) == true){
					System.out.println("You are out of attempts.  The correct answer is " + getCurrentWord().toUpperCase() + ".");   
				}
				else{
					System.out.println("That is not the correct answer.");	
				}
			}
			else{
				String yourTries = "";
				if((tries + 1) == 1){
					yourTries = (tries + 1) + " try.";
				}
				else{
					yourTries = (tries + 1) + " tries.";	
				}
					
				System.out.println("YOU ARE CORRECT!  It only took you " + yourTries );
				setTries(maxTries);
			}
		}
		while(tries < maxTries);
	}
	
	public static void main(String[] args){
		WordUnscramble play = new WordUnscramble();
	}
}