package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HpLaptop extends HpStore implements Initializable,Runnable
{
	@FXML
	Text info;
	@FXML
	Label mrp;
	@FXML
	ImageView imageOfHp;
	@FXML
	Label brand;
	@FXML
	Label model;
	@FXML
	Label os;
	@FXML
	Label dimension;
	@FXML
	Label weight;
	@FXML
	Label ratio;
	@FXML
	Label resolution;
	@FXML
	Label size;
	@FXML
	Label refresh;
	@FXML
	Label processor;
	@FXML
	Label memory;
	@FXML
	Label storage;
	@FXML
	Label gpu;
	@FXML
	VBox details;
	@FXML
	Label warning;
	@FXML
	Button addToCart;
	@FXML
	Button buyNow;
	@FXML
	Button remove;
	static boolean flag;
	@FXML
	ChoiceBox<Integer> quantity;
	
	ArrayList<Integer> quantArray;
	Thread thread;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		flag = false;
		addToCart.getStyleClass().add("button-style");
		buyNow.getStyleClass().add("button-style");
		remove.getStyleClass().add("button-style");
		details.getStyleClass().add("hbox-style");
		info.setText(text[index]);
		mrp.setText(mrpOfHp[index]);
		brand.setText(brand.getText()+"Hp");
		model.setText(model.getText()+modelOfHp[index]);
		gpu.setText(gpu.getText()+gpuOfHp[index]);
		resolution.setText(resolution.getText()+refreshOfHp[index]);
		os.setText(os.getText()+osOfHp[index]);
		dimension.setText(dimension.getText()+dimensionOfHp[index]);
		weight.setText(weight.getText()+weightOfHp[index]);
		refresh.setText(refresh.getText()+refreshOfHp[index]);
		ratio.setText(ratio.getText()+ratioOfHp[index]);
		size.setText(size.getText()+sizeOfHp[index]);
		processor.setText(processor.getText()+processorOfHp[index]);
		memory.setText(memory.getText()+memoryOfHp[index]);
		storage.setText(storage.getText()+storageOfHp[index]);
		
		addToCart.setOnMouseEntered(event ->{
			changeStyleOnMouseEnter(event);
		});
		buyNow.setOnMouseEntered(event ->{
			changeStyleOnMouseEnter(event);
		});
		remove.setOnMouseEntered(event ->{
			changeStyleOnMouseEnter(event);
		});
		addToCart.setOnMouseExited(event ->{
			changeStyleOnMouseExit(event);
		});
		buyNow.setOnMouseExited(event ->{
			changeStyleOnMouseExit(event);
		});
		remove.setOnMouseExited(event ->{
			changeStyleOnMouseExit(event);
		});
		
		quantArray = new ArrayList<Integer>();
		for(int i=0; i<6; i++)
		{
			quantArray.add(i+1);
		}
		quantity.getItems().addAll(quantArray);
		thread = new Thread(this);
		thread.start();
	}
	
	private void changeStyleOnMouseEnter(Event e)
	{
		if(e.getSource()==addToCart)
		{
			addToCart.getStyleClass().clear();
			addToCart.getStyleClass().add("button-change-style");
		}
		else if(e.getSource()==buyNow)
		{
			buyNow.getStyleClass().clear();
			buyNow.getStyleClass().add("button-change-style");			
		}
		else
		{
			remove.getStyleClass().clear();
			remove.getStyleClass().add("button-change-style");
		}
	}
	private void changeStyleOnMouseExit(Event e)
	{
		if(e.getSource()==addToCart)
		{
			addToCart.getStyleClass().clear();
			addToCart.getStyleClass().add("button-style");
		}
		else if(e.getSource()==buyNow)
		{
			buyNow.getStyleClass().clear();
			buyNow.getStyleClass().add("button-style");			
		}
		else
		{
			remove.getStyleClass().clear();
			remove.getStyleClass().add("button-style");
		}
	}

	@Override
	public void run()
	{		
		try
		{
			Image tempImage = new Image(imageURL[index]);
			Platform.runLater(() -> 
			{
				setImageOnImageView(tempImage);
			});
		}
		catch(Exception e) {}
	}
	private void setImageOnImageView(Image image)
	{       
		try
		{
			imageOfHp.setImage(image);
		}
        catch(Exception e) {}
	}    
	public void purchaseProduct()
	{   
		if(quantity.getValue()==null)
		{
			warning.setText("Please select quantity.");
		}
		else
		{
			warning.setText("");
			try
		    {
				quantityOfCheckBox = quantity.getValue();
		        Stage purchaseStage = new Stage(); 
		        Parent purchaseRoot = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
		        Scene purchaseScene = new Scene(purchaseRoot, 650, 600);
		        purchaseScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        purchaseStage.setScene(purchaseScene);
		        purchaseStage.setTitle("Purchase Laptop");
		        purchaseStage.setResizable(false);
		        purchaseStage.show();
		    }
		    catch (Exception e){}
		}
	}
	public void addToMyCart()
	{
		if(quantity.getValue()==null)
		{
			warning.setText("Please select quantity.");
		}
		else if(!flag)
		{
			flag=true;
			warning.setText("Laptop has been added to cart...!");
			cartItems.add(tempForCart);
			warning.setTextFill(Color.ALICEBLUE);
			quantityInCart.add(quantity.getValue());
			mrpInCart.add(mrpOfLaptop);
		}
	}
	public void removeFromCart()
	{
		if(flag)
		{
			warning.setText("Item has been removed from the cart...!");
			warning.setTextFill(Color.ALICEBLUE);
			cartItems.remove(tempForCart);
			quantityInCart.remove(quantityInCart.size()-1);
			mrpInCart.remove(mrpOfLaptop);
			flag=false;
		}
		else
		{
			warning.setText("Item is not added to the cart...!");
		}
	}
}
