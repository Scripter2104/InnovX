package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyCart extends DisplayPage implements Initializable
{

	@FXML
	VBox cartVBox;
	@FXML
	Label thankLabel;
	@FXML
	TextField address;
	@FXML
	Label cost;
	@FXML
	Label tax;
	@FXML
	Label payment;
	@FXML
	Button orderButton;

	double totalPrize=0;
	ArrayList<Double> prize;
	Thread threadForCart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		if(!cartItems.isEmpty())
		{
			cartVBox.getChildren().addAll(cartItems);
		}
		orderButton.getStyleClass().add("button-style");
		
		try
		{
			for(int i=0; i<cartItems.size(); i++)
			{
				StringTokenizer temp = new StringTokenizer(mrpInCart.get(i));
				temp.nextToken();
				String tempString="";
				while(temp.hasMoreTokens())
				{
					tempString += temp.nextToken(",");
				}
				tempString = tempString.substring(1);
				totalPrize += (Double.parseDouble(tempString))*quantityInCart.get(i);
			}
		}
		catch(Exception e)
		{}
		orderButton.setOnMouseEntered(event ->{
			changeStyleOnMouseEnter();
		});
		orderButton.setOnMouseExited(event ->{
			changeStyleOnMouseExit();
		});
		cost.setText(cost.getText()+(int)totalPrize+"/-");
		tax.setText(tax.getText()+(int)(totalPrize*0.18)+"/-");
		payment.setText(payment.getText()+(int)(totalPrize*1.18)+"/-");
	}
	
	public void purchaseDone()
	{
		if(address.getText().isEmpty())
		{
			thankLabel.setText("Please insert address");
		}
		else
		{
			thankLabel.setText("Thank you for shoping with InnovX...!");
		}
	}
	public void changeStyleOnMouseEnter()
	{
		orderButton.getStyleClass().clear();
		orderButton.getStyleClass().add("button-change-style");
	}
	public void changeStyleOnMouseExit()
	{
		orderButton.getStyleClass().clear();
		orderButton.getStyleClass().add("button-style");	
	}
}
