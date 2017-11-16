package BlackJackPack;

import java.util.ArrayList;

public class Hand {
	
	ArrayList <Card>cards;
	
	public Hand(){
		cards = new ArrayList<Card>();
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
	public ArrayList<Card> getList(){
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
	
	public void dosomething(){
		System.out.println("Something");
	}

	
	
	
	
	

}
