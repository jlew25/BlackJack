package BlackJackPack;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WinLossBox {
	
	 public static void display(String message) {
	        Stage window = new Stage();

	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle("Hand Results");
	        window.setMinWidth(250);
	        window.setMinHeight(250);
	        

	        Label messagelb = new Label();
	        messagelb.setText(message);

	        VBox layout = new VBox(10);
	        layout.getChildren().add(messagelb);
	        layout.setAlignment(Pos.CENTER);

	       
	        Scene scene = new Scene(layout);
	        window.setScene(scene);
	        window.showAndWait();
	    }

}
