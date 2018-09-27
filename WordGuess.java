import java.util.*;
import java.io.*;

public class WordGuess{
	
	//fields
	private ArrayList<String> words;
	private String wordToGuess;
	private String lettersInWord;
	private int letterGuessTries;
	private int wordGuessTries;
	
	//constructor
	public WordGuess(){
		words = new ArrayList<String>();
		lettersInWord = "";
		setWords();	
		setWordToGuess();
		setLetterGuessTries(5);
		setWordGuessTries(3);
	}
	
	//getters
	public ArrayList<String> getWords(){
		return words;	
	}
	
	public String getWordToGuess(){
		return wordToGuess;	
	}
	
	public String getLettersInWord(){
		return lettersInWord;	
	}
	
	public int getLetterGuessTries(){
		return letterGuessTries;	
	}
	
	public int getWordGuessTries(){
		return wordGuessTries;	
	}
	
	//setters
	public void setWords(){
		words.add("breakaway");
		words.add("slapshot");	
		words.add("netminder");
		words.add("forecheck");
		words.add("intermission");
		words.add("crossbar");
		words.add("zamboni");
		words.add("offside");
		words.add("wraparound");
	}
	
	public void setWordToGuess(){
		//sets the mystery word as a randomly-picked word from the words ArrayList
		wordToGuess = words.get((int)Math.floor(Math.random() * words.size()));	
	}
	
	public void setLettersInWord(String letter){
		lettersInWord += letter;	
	}
	
	public void setLetterGuessTries(int letterTries){
		letterGuessTries = letterTries;
	}
	
	public void setWordGuessTries(int wordTries){
		wordGuessTries = wordTries;	
	}
	
	//method to get letter guesses from user
	public void userLetterGuess(){
	String alreadyGuessLetter = "";
		while(getLetterGuessTries() > 0){
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("\nYou have " + getLetterGuessTries() + " letter guesses remaining.");
				System.out.print("Enter a letter: ");
				String userLetterInput = reader.readLine().trim();	
				if(userLetterInput.length() > 1){
					System.out.println("Enter only 1 letter.");
					userLetterGuess();	
				}
				else{
					if(alreadyGuessLetter.length() > 0 && alreadyGuessLetter.contains(userLetterInput) == true){
						System.out.println("You have already guessed this letter.");
						userLetterGuess();
					}
					else if(wordToGuess.contains(userLetterInput) == true){
						lettersInWord += (userLetterInput + ", ");
						System.out.println("Yes, the word contains " + userLetterInput);	
					}
					else{
						System.out.println(userLetterInput + " is NOT in the word.");	
					}
					alreadyGuessLetter += userLetterInput;
					letterGuessTries--;
					setLetterGuessTries(letterGuessTries);
				}
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
				userLetterGuess();
			}
		}
	}
	
	//method to get word guesses from user
	public void userWordGuess(){
		while(getWordGuessTries() > 0){
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("\nYou have " + getWordGuessTries() + " word guesses remaining.");
				System.out.print("Guess a " + getWordToGuess().length() + "-letter word with the letters " + lettersInWord + ": ");
				String userWordGuess = reader.readLine().trim();	
				if(userWordGuess.length() != wordToGuess.length()){
					System.out.println("Remember, the mystery word has " + wordToGuess.length() + " letters.  Try again!");
					userWordGuess();
				}
				else{
				
					wordGuessTries--;
					
					if(userWordGuess.equalsIgnoreCase(wordToGuess) == true){
						System.out.println("Yes, that is correct!  The mystery word was " + wordToGuess + ".");
						setWordGuessTries(0);
					}
					else{
						System.out.println("That is not correct.");	
						if(getWordGuessTries() == 0){
							System.out.println("You are out of guesses.  The mystery word was " + wordToGuess + ".  Better luck next time!");	
						}
					}
				}
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
				userLetterGuess();
			}		
		}
	}
	
	//main method
	public static void main(String[] args){
		WordGuess newInst = new WordGuess();
		System.out.println("WELCOME TO WORD GUESS!");
		System.out.println("You are given the number of letters in a mystery word." + 
			"\nDuring phase 1, you have " + newInst.getLetterGuessTries() + " tries to guess a letter in the mystery word." + 
			"\nDuring phase 2, you have " + newInst.getWordGuessTries() + " tries to guess the word that contains these letters. \nGood luck!\n");
		System.out.println("The mystery word has " + newInst.getWordToGuess().length() + " letters");
		newInst.userLetterGuess();
		newInst.userWordGuess();
	}
}