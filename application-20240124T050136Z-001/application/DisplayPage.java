package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class DisplayPage
{
	@FXML
	public ImageView search;
	@FXML
	public ImageView apple;
	@FXML
	public Label apple_Label;
	@FXML
	public ImageView hp;
	@FXML
	public Label hp_Label;
	@FXML
	public ImageView dell;
	@FXML
	public Label dell_Label;
	@FXML
	public ImageView asus;
	@FXML
	public Label asus_Label;
	@FXML
	public TextField text_Search;
	@FXML
	public Hyperlink reviews;

	static ArrayList<HBox> cartItems = new ArrayList<HBox>();
	static ArrayList<Integer> quantityInCart =  new ArrayList<Integer>();
	static ArrayList<String> mrpInCart = new ArrayList<String>();
	static HBox tempForCart;
	static String mrpOfLaptop;
	static int quantityOfCheckBox;
	
	public void searchContent()
	{
		String store = null;
		store = text_Search.getText();
		
		if(store.indexOf("Apple")!=-1 || store.indexOf("apple")!=-1 || store.indexOf("APPLE")!=-1)
		{
			showApple();
		}
		else if(store.indexOf("Dell")!=-1 || store.indexOf("dell")!=-1 || store.indexOf("DELL")!=-1)
		{
			showDell();
		}
		else if(store.indexOf("Hp")!=-1 || store.indexOf("hp")!=-1 || store.indexOf("HP")!=-1)
		{
			showHp();
		}
		else if(store.indexOf("Asus")!=-1 || store.indexOf("ASUS")!=-1 || store.indexOf("asus")!=-1)
		{
			showAsus();
		}
	}
	
	public void on_Enter_In_Apple()
	{
		apple_Label.setText("Mac");
	}
	public void on_Exit_From_Apple()
	{
		apple_Label.setText("");
	}
	public void on_Enter_In_Hp()
	{
		hp_Label.setText("hp");
	}
	public void on_Exit_From_Hp()
	{
		hp_Label.setText("");
	}
	public void on_Enter_In_Dell()
	{
		dell_Label.setText("Dell");
	}
	public void on_Exit_From_Dell()
	{
		dell_Label.setText("");
	}
	public void on_Enter_In_Asus()
	{
		asus_Label.setText("Asus");
	}
	public void on_Exit_From_Asus()
	{
		asus_Label.setText("");
	}
	public void showApple()
	{
	    try
	    {
	        Stage appleStage = new Stage(); 
	        Parent appleRoot = FXMLLoader.load(getClass().getResource("AppleStore.fxml"));
	        Scene appleScene = new Scene(appleRoot, 650, 600);
	        appleScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        appleStage.setScene(appleScene);
	        appleStage.setTitle("Apple Store");
	        appleStage.setResizable(false);
	        appleStage.show();
	    }
	    catch (Exception e){}
	}
	public void showDell()
	{
	    try
	    {
	        Stage dellStage = new Stage(); 
	        Parent dellRoot = FXMLLoader.load(getClass().getResource("DellStore.fxml"));
	        Scene dellScene = new Scene(dellRoot, 650, 600);
	        dellScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        dellStage.setScene(dellScene);
	        dellStage.setTitle("Dell Store");
	        dellStage.setResizable(false);
	        dellStage.show();
	    }
	    catch (Exception e){}
	}
	public void showHp()
	{
	    try
	    {
	        Stage hpStage = new Stage(); 
	        Parent hpRoot = FXMLLoader.load(getClass().getResource("HpStore.fxml"));
	        Scene hpScene = new Scene(hpRoot, 650, 600);
	        hpScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        hpStage.setScene(hpScene);
	        hpStage.setTitle("Hp Store");
	        hpStage.setResizable(false);
	        hpStage.show();
	    }
	    catch (Exception e){}
	}	
	public void showAsus()
	{
	    try
	    {
	        Stage asusStage = new Stage(); 
	        Parent asusRoot = FXMLLoader.load(getClass().getResource("AsusStore.fxml"));
	        Scene asusScene = new Scene(asusRoot, 650, 600);
	        asusScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        asusStage.setScene(asusScene);
	        asusStage.setTitle("Asus Store");
	        asusStage.setResizable(false);
	        asusStage.show();
	    }
	    catch (Exception e){}
	}	
	public void viewCart()
	{
	    try
	    {
	        Stage cartStage = new Stage(); 	
	        Parent cartRoot = FXMLLoader.load(getClass().getResource("MyCart.fxml"));
	        Scene cartScene = new Scene(cartRoot, 650, 600);
	        cartScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        cartStage.setScene(cartScene);
	        cartStage.setTitle("InnovX");  
	        cartStage.show();
	    }
	    catch (Exception e){}
	}
	public void removeCart()
	{
		cartItems.clear();
		quantityInCart.clear();
		mrpInCart.clear();
	    try
	    {
	        Stage cartStage = new Stage(); 	
	        Parent cartRoot = FXMLLoader.load(getClass().getResource("MyCart.fxml"));
	        Scene cartScene = new Scene(cartRoot, 650, 600);
	        cartScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        cartStage.setScene(cartScene);
	        cartStage.setTitle("InnovX");  
	        cartStage.show();
	    }
	    catch (Exception e){}	
	}
	public void reviewScene()
	{
		try {
			Stage primaryStage = new Stage();

			Parent root = FXMLLoader.load(getClass().getResource("Review.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Review");
			primaryStage.setResizable(false);
			primaryStage.getOnCloseRequest();
			primaryStage.show();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	public void myDetails() throws IOException 
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("MyDetails.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Review");
		primaryStage.setResizable(false);
		primaryStage.getOnCloseRequest();
		primaryStage.show();
	}	
	public void addAccount() throws IOException 
	{
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}
	public void loginScene() throws IOException 
	{
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}
	public void infoAboutUs(ActionEvent ae) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("InfoAboutUs.fxml"));
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		Stage newStage = new Stage();
		newStage.setScene(scene);
		newStage.show();
	}
    private void closeAllStages() 
    {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }

}
