package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DellStore extends DisplayPage implements Initializable,Runnable,DellProducts
{
	@FXML
	VBox mainVBox;
	
	@FXML
	HBox h0;	
	@FXML
	HBox h1;
	@FXML
	HBox h2;
	@FXML
	HBox h3;
	@FXML
	HBox h4;
	@FXML
	HBox h5;
	@FXML
	HBox h6;
	@FXML
	HBox h7;
	@FXML
	HBox h8;
	@FXML
	HBox h9;
	@FXML
	HBox h10;
	@FXML
	HBox h11;
	@FXML
	HBox h12;
	@FXML
	HBox h13;
	@FXML
	HBox h14;
	@FXML
	HBox h15;
	@FXML
	HBox h16;
	@FXML
	HBox h17;
	@FXML
	HBox h18;
	@FXML
	HBox h19;
	@FXML
	HBox h20;
	@FXML
	HBox h21;
	@FXML
	HBox h22;
	@FXML
	HBox h23;
	@FXML
	HBox h24;
	
	
	@FXML
	Text text0;
	@FXML
	Text text1;
	@FXML
	Text text2;
	@FXML
	Text text3;
	@FXML
	Text text4;
	@FXML
	Text text5;
	@FXML
	Text text6;
	@FXML
	Text text7;
	@FXML
	Text text8;
	@FXML
	Text text9;
	@FXML
	Text text10;
	@FXML
	Text text11;
	@FXML
	Text text12;
	@FXML
	Text text13;
	@FXML
	Text text14;
	@FXML
	Text text15;
	@FXML
	Text text16;
	@FXML
	Text text17;
	@FXML
	Text text18;
	@FXML
	Text text19;
	@FXML
	Text text20;
	@FXML
	Text text21;
	@FXML
	Text text22;
	@FXML
	Text text23;
	@FXML
	Text text24;
	
	
	@FXML
	ImageView image0;
	@FXML
	ImageView image1;
	@FXML
	ImageView image2;
	@FXML
	ImageView image3;
	@FXML
	ImageView image4;
	@FXML
	ImageView image5;
	@FXML
	ImageView image6;
	@FXML
	ImageView image7;
	@FXML
	ImageView image8;
	@FXML
	ImageView image9;
	@FXML
	ImageView image10;
	@FXML
	ImageView image11;
	@FXML
	ImageView image12;
	@FXML
	ImageView image13;
	@FXML
	ImageView image14;
	@FXML
	ImageView image15;
	@FXML
	ImageView image16;
	@FXML
	ImageView image17;
	@FXML
	ImageView image18;
	@FXML
	ImageView image19;
	@FXML
	ImageView image20;
	@FXML
	ImageView image21;
	@FXML
	ImageView image22;
	@FXML
	ImageView image23;
	@FXML
	ImageView image24;
	
		
	@FXML
	Label mrp0;
	@FXML
	Label mrp1;
	@FXML
	Label mrp2;
	@FXML
	Label mrp3;
	@FXML
	Label mrp4;
	@FXML
	Label mrp5;
	@FXML
	Label mrp6;
	@FXML
	Label mrp7;
	@FXML
	Label mrp8;
	@FXML
	Label mrp9;
	@FXML
	Label mrp10;
	@FXML
	Label mrp11;
	@FXML
	Label mrp12;
	@FXML
	Label mrp13;
	@FXML
	Label mrp14;
	@FXML
	Label mrp15;
	@FXML
	Label mrp16;
	@FXML
	Label mrp17;
	@FXML
	Label mrp18;
	@FXML
	Label mrp19;
	@FXML
	Label mrp20;
	@FXML
	Label mrp21;
	@FXML
	Label mrp22;
	@FXML
	Label mrp23;
	@FXML
	Label mrp24;
	
	
	Thread th;
	static int index=0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
	    for (int i = 0; i < 25; i++) 
	    {
	        HBox currentHBox = (HBox) mainVBox.lookup("#h" + i); 
	        currentHBox.getStyleClass().add("hbox-style");
	        Text currentText = (Text) currentHBox.lookup("#text"+i);
	        currentText.getStyleClass().add("text1-style");
	        Label currentMRP = (Label) currentHBox.lookup("#mrp"+i);
	        currentMRP.getStyleClass().add("mrp-style");
	        currentText.setText(text[i]);
	        currentMRP.setText(mrpOfDell[i]);

	        if (currentHBox != null)
	        {
	        	final int currentIndex = i;
	        	final HBox tempBox=currentHBox;
	            currentHBox.setOnMousePressed(new EventHandler<MouseEvent>()
	            {   	
	                @Override
	                public void handle(MouseEvent event)
	                {
	                    displayDellLaptop(currentIndex,tempBox);
	                }
	            });
	        }
	    }
		
		th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < imageURL.length; i++)
		{
			Image tempImage = new Image(imageURL[i]);
			final int indexOfImage = i;
			Platform.runLater(() -> 
			{
				setImageOnImageView(indexOfImage, tempImage);
			});
		}
	}
	
	protected void displayDellLaptop(int indexOfHBox,HBox tempBox) 
	{
		index = indexOfHBox;
		mrpOfLaptop = mrpOfDell[index];
	    try
	    {
	    	tempForCart = tempBox;
	        Stage dellStage = new Stage(); 
	        Parent dellRoot = FXMLLoader.load(getClass().getResource("DellLaptop.fxml"));
	        Scene dellScene = new Scene(dellRoot, 650, 600);
	        dellScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        dellStage.setScene(dellScene);
	        dellStage.setTitle("Dell Store");
	        dellStage.show();
	    }
	    catch (Exception e){}		
	}
	
	private void setImageOnImageView(int indexOfImage, Image image)
	{       
        HBox currentHBox = (HBox) mainVBox.lookup("#h" + indexOfImage);
        if(currentHBox!=null)
        {
            ImageView currentImage = (ImageView) currentHBox.lookup("#image"+indexOfImage);
            currentImage.setImage(image);
            currentImage.getStyleClass().add("image-style");
        }
	}    
}