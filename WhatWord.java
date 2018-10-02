import java.util.*;
import java.io.*;

public class WhatWord{
	//fields
	private ArrayList<String> words;
	private String currentWord;
	private StringBuilder userGuess;
	private char userLetter;
	private int triesLeft;
	
	//constructor
	public WhatWord(){
		words = new ArrayList<String>();
		setWords();
		setCurrentWord();
		userGuess = new StringBuilder();
		setUserGuess();
		System.out.println("The mystery word has " + userGuess.length() + " letters.");
		System.out.println("Mystery Word Format: " + userGuess.toString());
		setTriesLeft(7);
		playGame();
	}
	
	//setters
	public void setWords(){
		words.add("breakaway");
		words.add("crossbar");
		words.add("goaltender");
		words.add("offside");
		words.add("penalty");
		words.add("zamboni");
		words.add("powerplay");
		words.add("slapshot");
		words.add("trapezoid");
		words.add("playoffs");
	}
	
	public void setCurrentWord(){
		//sets the current word as a randomly-picked word from the words ArrayList
		currentWord= words.get((int)Math.floor(Math.random() * words.size()));			
	}
	
	public void setUserGuess(){
		for(int i=0; i<getCurrentWord().length(); i++){
			userGuess.append('*');	
		}
	}
	
	public void setUserLetter(){
		try{
			BufferedReader getInput = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.print("\nEnter a letter guess: ");
			userLetter = getInput.readLine().trim().charAt(0);	
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		}		
	}
	
	public void setTriesLeft(int t){
		triesLeft = t;	
	}
	
	//getters
	public ArrayList<String> getWords(){
		return words;	
	}
	
	public String getCurrentWord(){
		return currentWord;	
	}
	
	public StringBuilder getUserGuess(){
		return userGuess;	
	}
	
	public char getUserLetter(){
		return userLetter;
	}
	
	public int getTriesLeft(){
		return triesLeft;	
	}
	
	//method to determine if letter guessed in mystery word and provide feedback to user while tries remain
	public void playGame(){
		while(triesLeft > 0){
			setUserLetter();		
			if(currentWord.indexOf(userLetter) != -1){
				System.out.println("Yes, " + userLetter + " is in the word.");	
				for(int i = 0; i<userGuess.length(); i++){
					if(currentWord.charAt(i) == userLetter){
						userGuess.deleteCharAt(i);
						userGuess.insert(i, Character.toString(userLetter));
					}
				}
				if(userGuess.indexOf(Character.toString('*')) == -1){
					if(userGuess.toString().equals(currentWord)){
						System.out.println("YOU WON!  The mystery word is " + currentWord + ". ");
						setTriesLeft(0);
					}
				}
			}
			else{
				System.out.println(userLetter + " is NOT in the word.");	
				triesLeft--;
				System.out.println("You have " + triesLeft + " guesses left.");
				if(userGuess.indexOf(Character.toString('*')) != -1 && triesLeft == 0){
					System.out.println("You are out of guesses.  The mystery word was " + currentWord + ".  Better luck next time!");	
				}
				
			}
			if(triesLeft>0){
				System.out.println("Mystery Word Format: " + userGuess);
			}
		}
	}
	
	//main method
	public static void main(String[] args){
		WhatWord newInst = new WhatWord();
	}
}