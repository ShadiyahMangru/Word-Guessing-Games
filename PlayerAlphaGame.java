import java.util.*;
import java.io.*;

public class PlayerAlphaGame{
	//fields
	private ArrayList<String> players;
	private char randomAlpha;
	private ArrayList<String> alphaPlayers;
	private BufferedReader readInput;
	private Integer userFreqGuess;
	
	//constructor
	PlayerAlphaGame(){
		setPlayers();
		setRandomAlpha();
		setAlphaPlayers();
		setReadInput();
	}
	
	//setters (overloaded)
	public void setPlayers(){
		players = new ArrayList<String>();
		setPlayers("Carlson");
		setPlayers("Backstrom");
		setPlayers("Orpik");
		setPlayers("Ovechkin");
		setPlayers("Kuznetsov");
		setPlayers("Oshie");
		setPlayers("Kempny");
		setPlayers("Connolly");
		setPlayers("Jaskin");
		setPlayers("Holtby");
		setPlayers("Copley");
		setPlayers("Niskanen");
		setPlayers("Eller");
		setPlayers("Dowd");
		setPlayers("Vrana");
		setPlayers("Orlov");
		setPlayers("Smith-Pelly");
		setPlayers("Stephenson");
		setPlayers("Djoos");
		setPlayers("Walker");
		setPlayers("Burakovsky");
		setPlayers("Bowey");
		Collections.sort(players);
	}
	
	public void setPlayers(String p){
		players.add(p);	
	}
	
	public void setRandomAlpha(){
		randomAlpha = (char) (int)((Math.random() * ((90 - 65) + 1)) + 65);
	}
	
	public void setAlphaPlayers(){
		alphaPlayers = new ArrayList<String>();
		String randomAlpha = Character.toString(getRandomAlpha()).toUpperCase();
		for(String player : players){
			player = player.toUpperCase();
			if(player.startsWith(randomAlpha) == true){
				alphaPlayers.add(player);
			}
		}
	}
	
	public void setReadInput(){
		readInput = new BufferedReader(new InputStreamReader(System.in)); 
	}
	
	public void setUserFreqGuess(){
		try{
			System.out.print("Enter number of players whose last name begins with " + getRandomAlpha() + ": ");
			userFreqGuess = Integer.parseInt(readInput.readLine());	
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + ".\nTry again!");
			setUserFreqGuess();
		}	
	}
	
	//getter
	public ArrayList<String> getPlayers(){
		return players;	
	}
	
	public char getRandomAlpha(){
		return randomAlpha;	
	}
	
	public ArrayList<String> getAlphaPlayers(){
		return alphaPlayers;	
	}
	
	public BufferedReader getReadInput(){
		return readInput;	
	}
	
	public Integer getUserFreqGuess(){
		return userFreqGuess;	
	}
	
	//method to play alphabet last name game
	public void playGame(){
		System.out.println("***********Welcome to Washington Capitals' Last Name Alphabet Game!***********\n");
		System.out.println("How many players from the 2018-2019 regular season roster have a last name that begins with the letter " + getRandomAlpha() + "?");
		setUserFreqGuess();
		if(getUserFreqGuess().equals((Integer)getAlphaPlayers().size()) == true){
			System.out.println("You are CORRECT!  " + getAlphaPlayers().toString() + " has a/have last name(s) that begin(s) with the letter " + getRandomAlpha() + "!");
		}
		else{
			System.out.println("Nope!  "  + getAlphaPlayers().toString() + " has a/have last name(s) that begin(s) with the letter " + getRandomAlpha() + ".");	
		}
		
		System.out.println();
		System.out.println("The 2018-2019 regular season roster is: ");
		System.out.println(getPlayers().toString());
	}
	
	//main method
	public static void main(String... args){
		PlayerAlphaGame alphaGame = new PlayerAlphaGame();		
		alphaGame.playGame();
	}
}