package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignupController {

	@FXML
	private Button cancelButton;
	@FXML
	private Button signupButton;
	@FXML
	private TextField myTextField;
	@FXML
	private PasswordField myPasswordField;
	@FXML
	private TextField emailTextField;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private Hyperlink loginHyperlink;

	private Parent root;
	private Scene scene;
	private Stage stage;
	
	
	public void signup(ActionEvent event) throws Exception {
	
		String username = myTextField.getText();
		String password = myPasswordField.getText();
		String email_id = emailTextField.getText();
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(email_id);

		if(username.isBlank()||password.trim().isEmpty()||email_id.trim().isEmpty())
		{
			showAlert("Blank fields encountered","Please enter correct credentials and try again.");
			System.out.println("\nBlank fields encountered");
		}
		
		else if(!isValidEmail(email_id))
		{
			System.out.println("Invalid email");
			showAlert("Invalid email address","Please enter a valid email address and try again.");
		}
		
		else 
		{
		String query = "INSERT INTO login VALUES (?,?,?)";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_login", "root", "Maiitra@09");
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, password);
		st.setString(3, email_id);
		int count = st.executeUpdate();
		
		st.close();
		con.close();
	
		if(count!=0){
			System.out.println(count+"\nSignup successful");
			changetologin(event);
		}
		else{
			System.out.println("\nSignup unsuccessful");
		}
		
		}
	}
	
	public boolean isValidEmail(String email_id)
	{
		String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailmatcher = emailPattern.matcher(email_id);
		return emailmatcher.matches();
	}
	public void showAlert(String headtxt, String contxt)
	{
		Alert alert = new Alert(AlertType.ERROR, contxt, ButtonType.OK);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		alert.setTitle("Error");
		alert.setHeaderText(headtxt);
		alert.showAndWait();
		
	}
	
	public void logout(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Do you want to exit?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
		stage = (Stage)scenePane.getScene().getWindow();
		System.out.println("\nYou logged out successfully!");
		stage.close();
		}
	}
	
	
	public void changetologin(ActionEvent event) throws Exception {
		
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
}
