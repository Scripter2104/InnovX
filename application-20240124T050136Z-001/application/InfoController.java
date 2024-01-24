
package application;

import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class InfoController implements Initializable {
	@FXML
	private TextFlow myText;
	
	

	public void homeScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void addAccount(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void loginScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void mainScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}
	
	public void reviewScene(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Review.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
	}
	
    private void closeAllStages() {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Text text=new Text("\"We have dedicated a significant amount of our time and effort to create the innovative project named InnovX. It stands as a comprehensive one-stop destination for laptop comparison and purchases.\r\n"
				+ "\r\n"
				+ "Maiita Patel played a crucial role by designing our user-friendly login page and establishing the robust database. Yash Solanki's contribution is evident in the well-crafted laptop comparison page, which includes an extensive selection of over 350 different laptops, each detailed with specifications. Khushi Patel's expertise shines through in the purchase section, which features laptops from four different companies, encompassing all available models. Bhargavi's insightful design of the review section ensures that our project will become even more convenient for users in the future.\"");
		Font f=new Font("Arial",15);

		text.setFill(Color.rgb(197, 198, 199));


		text.setFont(f);
		
		myText.getChildren().add(text);
		
	}

}