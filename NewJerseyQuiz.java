import java.util.*;
import java.io.*;

	public class NewJerseyQuiz{
		private int maxTries;
		private int tries;
		private ArrayList<Jersey> players;
		private Jersey currentPlayer;
		private String userEntry;
		private BufferedReader readUserEntry;
		
		public NewJerseyQuiz(){
			setMaxTries(5);
			setPlayers();
			setCurrentPlayer();
			setReadUserEntry();
			playGame();
		}
		
		//setters
		public void setMaxTries(int m){
			maxTries = m;	
		}
		
		public void setTries(int t){
			tries = t;	
		}
		
		public void setPlayers(){
			players = new ArrayList<Jersey>();
			players.add(new Jersey("Backstrom", 19));
			players.add(new Jersey("Boyd", 72));
			players.add(new Jersey("Burakovsky", 65));
			players.add(new Jersey("Connolly", 10));
			players.add(new Jersey("Dowd", 26));
			players.add(new Jersey("Eller", 20));
			players.add(new Jersey("Gersich", 63));
			players.add(new Jersey("Jaskin", 23));
			players.add(new Jersey("Kuznetsov", 92));
			players.add(new Jersey("Megna", 15));
			players.add(new Jersey("Oshie", 77));
			players.add(new Jersey("Ovechkin", 8));
			players.add(new Jersey("Smith-Pelly", 25));
			players.add(new Jersey("Stephenson", 18));
			players.add(new Jersey("Vrana", 13));
			players.add(new Jersey("Walker", 79));
			players.add(new Jersey("Wilson", 43));
			players.add(new Jersey("Bowey", 22));
			players.add(new Jersey("Carlson", 74));
			players.add(new Jersey("Djoos", 29));
			players.add(new Jersey("Kempny", 6));
			players.add(new Jersey("Niskanen", 2));
			players.add(new Jersey("Orlov", 9));
			players.add(new Jersey("Orpik", 44));
			players.add(new Jersey("Siegenthaler", 34));
			players.add(new Jersey("Copley", 1));
			players.add(new Jersey("Holtby", 70));
		}
		
		public void setCurrentPlayer(){
			Random r = new Random();
			//selects a random player from the roster
			currentPlayer = players.get(r.nextInt(players.size()));
		}
		
		public void setUserEntry(){
			try{
				System.out.print("Enter Player's Last Name: ");
				userEntry = readUserEntry.readLine().trim();	
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + ".");
			}	
		}
		
		public void setReadUserEntry(){
			readUserEntry = new BufferedReader(new InputStreamReader(System.in)); 	
		}
		
		//getters
		public int getMaxTries(){
			return maxTries;	
		}
		
		public int getTries(){
			return tries;	
		}
		
		public ArrayList<Jersey> getPlayers(){
			return players;	
		}
		
		public Jersey getCurrentPlayer(){
			return currentPlayer;	
		}
		
		public String getUserEntry(){
			return userEntry;
		}
		
		public BufferedReader getReadUserEntry(){
			return readUserEntry;	
		}
		
		//method to evaluate user entry and determine if incorrect, if incorrect and out of guesses, or if correct
		public void playGame(){
			System.out.println("*******************************\nWelcome to Jersey Quiz!\n*******************************\n");
			System.out.println("Which Washington Capitals player currently wears number " + currentPlayer.getJerseyNumber() + "?");
			System.out.println("You have " + getMaxTries() + " tries to enter the correctly-spelled last name.");
			do{
				setUserEntry();
				if(userEntry.equalsIgnoreCase(currentPlayer.getLastName())==false){
					tries++;
					if((userEntry.equalsIgnoreCase(currentPlayer.getLastName()) ^ tries == 5) == true){
						System.out.println("You are out of attempts.  The correct answer is " + currentPlayer.getLastName() + ".");   
					}
					else{
						System.out.println("That is not the correct answer.");	
					}
				}
				else{
					System.out.println("YOU ARE CORRECT!  It only took you " + (tries + 1) + " tries.");
					setTries(maxTries);
				}
			}
			while(tries < maxTries);
		}
		
		//main method
		public static void main(String[] args){
			NewJerseyQuiz takeQuiz = new NewJerseyQuiz();
		}
	}

	class Jersey{
		//fields
		private String lastName;
		private int jerseyNumber;
		
		//constructor
		public Jersey(String ln, int jn){
			lastName = 	ln;
			jerseyNumber = jn;
		}
		
		//setters
		public void setJerseyNumber(int jn){
			jerseyNumber = jn;	
		}
		
		public void setLastName(String ln){
			lastName = ln;	
		}
		
		//getters
		public Integer getJerseyNumber(){
			return jerseyNumber;	
		}
		
		public String getLastName(){
			return lastName;	
		}
	}