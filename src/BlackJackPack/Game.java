package BlackJackPack;

public class Game {
	
	private Player player;
	private Dealer dealer;
	private int bet;
	
	public Game(Player player){
		
		this.player= player;
		this.dealer= new Dealer();
		bet=0;
		
	}
	
	
	//deals cards to 
	public void deal(){
		this.player.getHand().addCard(false);
		this.dealer.getHand().addCard(true);
		this.player.getHand().addCard(false);
		this.dealer.getHand().addCard(false);
	}
	
	//if the hit button is pressed gives player another card (event for HIT button)
	public void hit(){
		this.player.getHand().addCard(false);
	}
	
	
	//returns whether or not to give the dealer a card
	public boolean dealerHit(){
		return(this.dealer.getScore()<=16);
	}
	
	//For when the wager is made, checks limits
	public boolean wager(int amt){
		if(amt<0||amt>player.getMoney()){
			return false;
		}
		else{
			this.bet=amt;
			player.subMoney(amt);
			return true;
		}
	}
	
	//if the player wins normally
	public void regWin(){
		player.addMoney((this.bet*2));
		
	}
	
	//if the player hits blackjack (21)
	public void blackJack(){
		player.addMoney((int) (this.bet*1.5));
	}


	public int getBet() {
		return bet;
	}
	
	public void betReset(){
		this.bet = 0;
	}


	public Player getPlayer() {
		return player;
	}


	public Dealer getDealer() {
		return dealer;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
