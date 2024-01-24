package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Scene2Controller {

	@FXML
	Label nameLabel;
	@FXML
	private Button purchaseButton;
	@FXML 
	private Button compareButton;
	@FXML
	private AnchorPane scenePane;
	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	public void displayName(String username) {
		nameLabel.setText("Welcome " + username+",");
	}
	
	
    public void compareProduct(ActionEvent event) throws IOException {
    	
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CompareScene.fxml"));
		root = loader.load();
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		stage = new Stage();
		stage.setTitle("Laptop Comparision");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();

    }

    public void purchase(ActionEvent event) throws IOException {
    	
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayAllLaptop.fxml"));
		root = loader.load();
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		stage = new Stage();
		stage.setTitle("Laptop Comparision");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();

    }
	

}
