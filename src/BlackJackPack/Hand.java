package BlackJackPack;

import java.util.LinkedList;

public class Hand {
	
	LinkedList <Card>cards;
	
	public Hand(){
		cards = new LinkedList<Card>();
	}
	
	//Gets the length of the ArrayList
	public int getLength(){
		return cards.size();
	}
	
	//Returns the card at specified index
	public Card getCard(int x){
		return  cards.get(x);
	}
	
	//Returns the arrayList for scoring purposes
	public LinkedList<Card> getList(){
		return cards;
		
	}

	public void addCard(boolean faceDown) {
		if(faceDown==true){
			cards.add(new Card(true));
		}
		else{
			cards.add(new Card(false));
		}
		
	}

	public void clearHand() {
		cards.clear();
		
	}
	
	

}
