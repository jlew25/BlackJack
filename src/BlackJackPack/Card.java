package BlackJackPack;

import java.util.Random;

import javafx.scene.image.Image;

public class Card {

	
	private int value;
	private int imgVal;
	private String suit;
	private boolean faceDown;
	Image cardFace,cardBack;
	private static final Random GEN = new Random();
	private static final String[] SUIT={"h","c","s","d"};
	
	
	public Card(boolean faceDown) {
		this.faceDown=faceDown;
		this.suit= SUIT[GEN.nextInt(4)];
		this.imgVal= GEN.nextInt(13)+1;
		
		if(imgVal >10){
			this.value= 10;
		}
		else if(imgVal ==1){
			this.value=11;
		}
		else
		{
			this.value=imgVal;
		}
		
		cardFace = new Image("/cards/"+this.suit+this.imgVal+".gif");
		cardBack = new Image("/cards/b1fv.gif");	
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public boolean isFaceDown() {
		return faceDown;
	}


	public Image getCardFace() {
		return cardFace;
	}


	public void setCardFace(Image cardFace) {
		this.cardFace = cardFace;
	}


	public Image getCardBack() {
		return cardBack;
	}

	
	


	
	
}
