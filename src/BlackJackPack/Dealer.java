package BlackJackPack;

public class Dealer {

	private  Hand hand;
	
	public Dealer(){
		this.hand = new Hand();
	}

	public Hand getHand() {
		
		return this.hand;
	}
	
	public int getScore(){
		int score = 0;
		int aces =0;
		for(int x=0; x<hand.getLength(); x++){
			score+= hand.getCard(x).getValue();
			if(hand.getCard(x).getValue() ==11){
				aces++;
			}
		}
		if(score>21 && aces>=1){
			return score-(10);
		}
		return score;
	}
	
}
