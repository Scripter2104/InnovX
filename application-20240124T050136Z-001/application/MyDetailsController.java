package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Driver;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class MyDetailsController extends DisplayPage implements Initializable
{
	@FXML
	private Label username;
	@FXML 
	private Label password;
	@FXML
	private Label email_id;
	@FXML
	private ImageView imageOfDell;
    @FXML
    private ImageView search;
    @FXML
    private TextField text_Search;
    
    public static String rs1, rs2, rs3;
    
    void setDetails(String username, String password, String email_id){
    	rs1 = username;
    	rs2 = password;
    	rs3 = email_id;
    }
        
    @FXML
    void logoutAll(MouseEvent event) throws IOException {
        System.out.println("Clicked");

        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
    }
    
    @FXML
    void addAccount(MouseEvent event) throws IOException {
        System.out.println("Clicked");

        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
    }
    
    // Close all open stages (windows)
    // Window window = new Stage(...);
    private void closeAllStages() {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.username.setText(rs1);
		this.password.setText(rs2);
		this.email_id.setText(rs3);
		
	}
    

}
