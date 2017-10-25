package practice;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class separateWin {

    public static void display(String title, String message) {
        Stage window = new Stage();

        Label label = new Label(message);  

        VBox layout = new VBox();
        layout.getChildren().add(label);
        layout.setAlignment(Pos.CENTER);

        
        Scene scene1 = new Scene(layout,600,400);
        window.setScene(scene1);
        window.setTitle(title);
        window.show();
    }

}
