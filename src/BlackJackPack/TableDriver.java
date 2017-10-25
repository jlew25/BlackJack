package BlackJackPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TableDriver {
	
	static Player p;
	static Game game;
	static Label banklb;
	static Label betlb;
	 static TextField wagertf;
	 static Button wagerB;
	 static Button hitB;
	 static Button stayB;
	 static ImageView dealerCards;
	 static ImageView playerCards;
	 static Scene tableScene;
	 static Stage window;

	public static void display(String playerName){
		//Setting up the window
		 window = new Stage();
		
		
		//Keeping the user from being able to interact with the star-up window
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("BLACKJACK");
		
		
		//Setting up the OOP components
		p = new Player(playerName);
		game = new Game(p);
		
		
		
		 //layout for tablescene
		 BorderPane tablePane = new BorderPane();
	     tablePane.setId("pane");
	    tablePane.getStylesheets().add("BlackJackStyle.css");
	    tablePane.getStylesheets().addAll(TableDriver.class.getResource("BlackJackStyle.css").toExternalForm());
	     
	     //Setting up the Bank and Bet visual
	     HBox infoSect = new HBox(20);
	     int addon = p.getMoney();
	     banklb = new Label("Bank: $"+addon);  //ADD THE BANK AMT
	     banklb.setFont(new Font("Arial",25));
	     betlb= new Label("Bet: $"+game.getBet());  //ADD THE WAGER AMT
	     betlb.setFont(new Font("Arial",25));
	     infoSect.getChildren().addAll(banklb,betlb);
	     
	     //Setting up the buttons on the bottom
	     HBox HSsect = new HBox(40);
	     
	     wagertf = new TextField();
	     wagertf.setPromptText("Wager");
	     
	     
	     wagerB = new Button("Wager");
	     
	     //Setting up the area for the cards to sit in
	     HBox dealerC = new HBox(5);
	     dealerC.setAlignment(Pos.CENTER);
	     HBox playerC = new HBox(5);
	     playerC.setAlignment(Pos.CENTER);
	    
	     //Wager button event handler
	     wagerB.setOnAction(e->{
	    	 if(game.wager(Integer.parseInt(wagertf.getText()))== true){
	    		 
	    		 
	    		 //Disabling the button until round is over and clearing the textfield
	    		 wagerB.setDisable(true);
	    		 wagertf.clear();
	    		 
	    		 //Enabling the hit and stay buttons
	    		 hitB.setDisable(false);
	    		 stayB.setDisable(false);
	    		 
	    		 //Dealing Cards
	    		 game.deal();
	    		 
	    		 //Updating the top left
	    		 banklb.setText("Bank: $"+game.getPlayer().getMoney());
	    		 betlb.setText("Bet: $"+game.getBet());
	    		 
	    		 //Create images
	    		 for(int x=0; x< game.getPlayer().getHand().getLength();x++){
	    			// if(game.getPlayer().getHand().getCard(x).isFaceDown())
	    			 playerC.getChildren().add(new ImageView(game.getPlayer().getHand().getCard(x).getCardFace()));
	    			 
	    		 }
	    		 for(int x=0; x< game.getDealer().getHand().getLength();x++){
		    			 if(game.getDealer().getHand().getCard(x).isFaceDown()){
		    				 
			    			 dealerC.getChildren().add(new ImageView(game.getDealer().getHand().getCard(x).getCardBack()));

		    			 }
		    			 else{
		    				  dealerC.getChildren().add(new ImageView(game.getDealer().getHand().getCard(x).getCardFace()));
		    			 
		    			 }
		    			
		    		 }
	    	 }
	    	 
	     });
	     
	     
	     hitB = new Button("Hit");
	     //Disabling the hit button upon creation
	     hitB.setDisable(true);
	     
	     // Event handler for the hit button
	     hitB.setOnAction(e->{
	    	 game.getPlayer().getHand().addCard(false);
	    	 playerC.getChildren().add(new ImageView(game.getPlayer().getHand().getCard(game.getPlayer().getHand().getLength()-1).getCardFace()));
	     });
	     
	     stayB = new Button("Stay");
	     //Disabling the stay button upon creation
	     stayB.setDisable(true);
	     
	     //Event handler for the stay button
	     stayB.setOnAction(e->{
	    	 while(game.dealerHit()== true){
	    		 game.getDealer().getHand().addCard(false);
	    		 dealerC.getChildren().add(new ImageView(game.getDealer().getHand().getCard(game.getDealer().getHand().getLength()-1).getCardFace()));
	    	 }
	    	 
				roundOver();
			
	    	 
				//Clearing the cards
		   		 dealerC.getChildren().clear();
		   		 playerC.getChildren().clear();
		   		 game.getPlayer().getHand().clearHand();
		   		 game.getDealer().getHand().clearHand();
				
	     });
	     
	     HSsect.getChildren().addAll(hitB,stayB, wagertf, wagerB);

	     //Setting up the cards in the center
	     VBox cardSect = new VBox(200);
	     cardSect.setAlignment(Pos.CENTER);
	    
	     cardSect.getChildren().addAll(dealerC,playerC);
	     
	     
	     
	     
	     
	     
	     
	     tablePane.setTop(infoSect);
	     tablePane.setBottom(HSsect);
	     tablePane.setCenter(cardSect); 
		 tableScene = new Scene(tablePane,1023,669);
		 
		 window.setScene(tableScene);
		 window.setResizable(false);
		 window.showAndWait();
	     
	}

	private static void roundOver()  {
		
		//Re-Enabling the wager button
		wagerB.setDisable(false);
		
		//Re-Disabling the hit and stay buttons
		stayB.setDisable(true);
		hitB.setDisable(true);
		
		//Determining Winner
		
		if(game.getDealer().getScore()==21||game.getPlayer().getScore()>21||game.getDealer().getScore()==game.getPlayer().getScore()
				||(game.getDealer().getScore()<21 && game.getDealer().getScore() > game.getPlayer().getScore())){
			
			//Display alert box
			WinLossBox.display("You Lost. Dealer Score: "+game.getDealer().getScore()+" "+game.getPlayer().getName()+
					"'s Score: "+game.getPlayer().getScore());
			
			//Incrementing the hand count
			game.getPlayer().incrementCount();
			
		}else if(game.getPlayer().getScore()==21){
			game.blackJack();
			
			//Display alert box
			WinLossBox.display("BLACKJACK!!!  Dealer Score: "+game.getDealer().getScore()+" "+game.getPlayer().getName()+
					"'s Score: "+game.getPlayer().getScore());
			
			//Incrementing the hand count
			game.getPlayer().incrementCount();
			
		}else if(game.getDealer().getScore()>21||game.getPlayer().getScore()>game.getDealer().getScore()){
			game.regWin();
			//Display alert box
			WinLossBox.display("You Won!! Dealer Score: "+game.getDealer().getScore()+" "+game.getPlayer().getName()+
					"'s Score: "+game.getPlayer().getScore());
			
			//Incrementing the hand count
			game.getPlayer().incrementCount();
		}
		
		if(game.getPlayer().getMoney()<=0||game.getPlayer().getMoney()>=2000){
			WinLossBox.display("GAME OVER:  THANKS FOR PLAYING!");
			addScoreToFile();
			window.close();
			
			
		}
		 //Updating the top left and the bet
		 game.betReset();
   		 banklb.setText("Bank: $"+game.getPlayer().getMoney());
   		 betlb.setText("Bet: $"+game.getBet());
   		 
   		 
		
		
	}

	//Supposed to write to scores.txt but file never updates
	public static void addScoreToFile() {
		  try (BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt", true))) {
		        bw.write(game.getPlayer().toString());
		        bw.newLine();
		    } catch (IOException e) {
		        e.printStackTrace();

		    }
		}
	
}
