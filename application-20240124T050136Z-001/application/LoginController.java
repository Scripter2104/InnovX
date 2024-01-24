package application;

import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Button logoutButton;
	@FXML
	private Button loginButton;
	@FXML
	private TextField myTextField;
	@FXML
	private PasswordField myPasswordField;
	@FXML
	private AnchorPane scenePane;
	@FXML 
	private Label errorLabel;
	@FXML
	private Hyperlink signupHyperlink;

	private Parent root;
	private Scene scene;
	private Stage stage;
	
	public void login(ActionEvent event) throws Exception {

		String username = myTextField.getText();
		String password = myPasswordField.getText();
		String query = "SELECT * FROM login WHERE username=? AND password=?";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_login", "root", "Maiitra@09");
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
	
		if(!rs.next())
		{
			errorLabel.setText("Enter correct credentials!");
			myTextField.setText(null);
			myPasswordField.setText(null);
			System.out.println("Login Failed!");
		}
		else
		{
//		String username = "Root";

		MyDetailsController mydetailscontroller = new MyDetailsController();
		mydetailscontroller.setDetails(rs.getString(1), rs.getString(2), rs.getString(3));


		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		root = loader.load();
		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayName(username);
		st.close();	con.close();
		
		
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
		
		}
	}
	
	
	public void logout(ActionEvent event) {
		
		logoutButton.setText("NOOO! DON'T");//THIS
		loginButton.setText("LEAVE ME");	//THIS
		Alert alert = new Alert(AlertType.CONFIRMATION);	
		
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Do you want to exit?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
		stage = (Stage)scenePane.getScene().getWindow();
		System.out.println("You logged out successfully!");
		stage.close();
		}
		else {								//THIS
		logoutButton.setText("logout"); //THIS
		loginButton.setText("login");	//THIS
		}									//THIS
	}
	
	
	public void changetosignup(ActionEvent event) throws Exception {
		
		root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
}
