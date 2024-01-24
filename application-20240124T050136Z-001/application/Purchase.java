package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Purchase extends DisplayPage implements Initializable
{
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
	@FXML
	Label quant;
	@FXML
	VBox purchaseBox;

	double totalPrize;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		purchaseBox.getChildren().setAll(tempForCart);
		orderButton.getStyleClass().add("button-style");
		StringTokenizer temp = new StringTokenizer(mrpOfLaptop);
		temp.nextToken();
		String tempString="";
		orderButton.setOnMouseEntered(event ->{
			changeStyleOnMouseEnter();
		});
		orderButton.setOnMouseExited(event ->{
			changeStyleOnMouseExit();
		});
		while(temp.hasMoreTokens())
		{
			tempString += temp.nextToken(",");
		}
		tempString = tempString.substring(1);
		totalPrize = (Double.parseDouble(tempString))*quantityOfCheckBox;
		quant.setText(quant.getText()+quantityOfCheckBox);
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
