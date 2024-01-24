package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage stage) {
		try {
//			BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(true);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
			stage.setOnCloseRequest(event -> {			
				event.consume();
				logout(stage);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Do you want to exit?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
		System.out.println("You successfully logged out!");
		stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
