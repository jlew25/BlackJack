package BlackJackPack;
import java.util.*;

import javax.smartcardio.Card;
public class Hand {
	
	Deque<Card> cards = new ArrayDeque<Card>();
	
	public Hand(){
		cards = new ArrayDeque<Card>();
		tmpStack = new ArrayDequeCard>();
	}
	
	// Gets the length of the ArrayList
	public int getLength(){
		return cards.size();
	}
	
	// Returns the card at specified index
	// https://stackoverflow.com/questions/19647713/removing-a-specific-element-in-a-stack
	public Card getCard(int x){
		
		if (isEmpty())
			return null;
		else
		{
			for (int i = 0; i < x; i++)
			  tmpStack.push(this.pop());

			E removedElement = tmpStack.pop();

			while (!tmpStack.isEmpty())
			  this.push(tmpStack.pop());

			return removedElement;
		}
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
