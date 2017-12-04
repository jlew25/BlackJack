package BlackJackPack;
import java.util.*;
public class Hand {
	
	Deque<Card> cards = new ArrayDeque<Card>();
	
	public Hand(){
		cards = new ArrayDeque<Card>();
	}
	
	// Gets the length of the ArrayList
	public int getLength(){
		return cards.size();
	}
	
	// Returns the card at specified index
	public Card getCard(){
		return  cards.pop();
	}
	
	// Returns the arrayList for scoring purposes
	public Deque<Card> getHand(){
		return cards;
		
	}

	public void addCard(boolean faceDown) {
		if(faceDown==true){
			cards.push(new Card(true));
		}
		else{
			cards.push(new Card(false));
		}
		
	}

	public void clearHand() {
		cards.clear();
		
	}	

}
