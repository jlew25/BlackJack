package practice;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class practice01 extends Application {

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage stage) throws Exception {
		TextField height = new TextField();
		height.setPromptText("Height");
		TextField width = new TextField();
		width.setPromptText("Width");
		//TextField area = new TextField();
		//area.setPromptText("Area");
		Button calc = new Button();
		calc.setText("Calculate");
		
		calc.setOnAction(e -> {
			Integer value1 = Integer.valueOf(height.getText());
			Integer value2 = Integer.valueOf(width.getText());
			Integer total = (int) ((value1*value2)*.5);
	        String val = total.toString();
	        separateWin.display("Area of the Triangle", val);
		});
		
		VBox root1 = new VBox();
		HBox height1 = new HBox();
		HBox width1 = new HBox();
		//HBox area1 = new HBox();
		//height1.getChildren().add(height);
		//width1.getChildren().add(width);
		//area1.getChildren().add(area1)
		root1.getChildren().add(height);
		root1.getChildren().add(width);
		root1.getChildren().add(calc);

		
		////
		//FlowPane root = new FlowPane();
		//root.getChildren().add(calc);
		//root.getChildren().add(width);
		//root.getChildren().add(height);
		
		Scene s1 = new Scene(root1,300,500);
		
		stage.setTitle("Hello World!!");
		stage.setScene(s1);
		stage.show();
		
		
		
	}


}
