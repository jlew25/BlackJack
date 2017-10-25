package BlackJackPack;

public class Player {
	private String name;
	private int money;
	private Hand hand;
	private int handCount;
	
	public Player(String name){
		this.name = name;
		this.money = 500;
		hand = new Hand();
		handCount=0;
	}
	 
	
	public int getCount(){
		return this.handCount;
	}
	
	public void incrementCount(){
		this.handCount++;
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getMoney() {
		return this.money;
	}
	
	public String getMoneyAsString(){
		return ""+this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//Returns the hand for dealing purposes
	public Hand getHand()
	{
		return this.hand;
		
	}
	
	//Will decrement the amount of money in players bank
	public void subMoney(int amt){
		this.money-=amt;
	}
	
	//Will add money to players bank
	public void addMoney(int amt){
		this.money+=amt;
	}
	
	//Will get the score of the hand
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


	@Override
	public String toString() {
		return "Player: [name=" + name + ", money=" + money + ", handCount=" + handCount + "]";
	}
	
	
	

}
