package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class Controller implements Initializable {

	@FXML
	private ComboBox<String> combobox1;
	@FXML
	private ComboBox<String> combobox2;
	@FXML
	private ImageView imageview1;
	@FXML
	private ImageView imageview2;
	@FXML
	private Label modelLabel1, myPrice1, myProcessor, myGpu, myMemory, myStorage, myOs, myResolution, myDimension,
			myCamera, myRefreshRate, mySize, myRatio, myWeight;
	@FXML
	private Label modelLabel2, myPrice2, myProcessor2, myGpu2, myMemory2, myStorage2, myOs2, myResolution2,
			myDimension2, myRatio2, myWeight2, myCamera2, myRefreshRate2, mySize2;

	int rating;
	public static String information1, information2;

	String laptop_info[] = new String[325];

	public void homeScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void addAccount(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void loginScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void mainScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void infoAboutUs(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InfoAboutUs.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
	}

	@SuppressWarnings("static-access")
	public void setInfo(String information1, String information2) {
		this.information1 = information1;
		this.information2 = information2;
	}

	public void reviewScene(ActionEvent ae) {

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

	public void choice(ActionEvent ae) {

		try {

			String info1 = combobox1.getValue();
			String info2 = combobox2.getValue();

			String imageUrl1 = null;
			String imageUrl2 = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/croma_info", "root",
					"Maiitra@09");

			PreparedStatement pst = con.prepareStatement(
					"select laptop,Price,Image,Processor,gpu,Memory,Storage,Osys,Resolution,Ratio,Weight,Dimensions,Camera,Size,Refresh from croma_updated2 where laptop=?;");

			PreparedStatement pst2 = con.prepareStatement(
					"select laptop,Price,Image,Processor,gpu,Memory,Storage,Osys,Resolution,Ratio,Weight,Dimensions,Camera,Size,Refresh from croma_updated2 where laptop=?;");

			pst.setString(1, info1);
			pst2.setString(1, info2);

			ResultSet rs = pst.executeQuery();	
			ResultSet rs2 = pst2.executeQuery();

			if (info1 != null) {
				while (rs.next()) {
					imageUrl1 = rs.getString("Image");

					URL url = new URL(imageUrl1);
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();
					Image image = new Image(is);
					imageview1.setImage(image);

					modelLabel1.setText("-> " + rs.getString("laptop"));

					myPrice1.setText("-> ₹ " + rs.getString("Price") + "/-");

					myProcessor.setText("-> " + "Processor: " + rs.getString("Processor"));
					myGpu.setText("-> " + "Gpu: " + rs.getString("gpu"));
					myMemory.setText("-> " + "Memory: " + rs.getString("Memory"));
					myStorage.setText("-> " + "Storage: " + rs.getString("Storage"));
					myOs.setText("-> " + "Operating Sys: " + rs.getString("Osys"));
					myResolution.setText("-> " + "Resolution: " + rs.getString("Resolution"));

					myRatio.setText("-> " + "Ratio: " + rs.getString("Ratio"));
					myWeight.setText("-> " + "Weight: " + rs.getString("Weight"));
					myDimension.setText("-> " + "Dimensions: " + rs.getString("Dimensions"));

					myCamera.setText("-> " + "Camera: " + rs.getString("Camera"));
					myRefreshRate.setText("-> " + "Refresh Rate: " + rs.getString("Refresh"));
					mySize.setText("-> " + "Size: " + rs.getString("Size"));

				}
			}

			if (info2 != null) {
				while (rs2.next()) {

					imageUrl2 = rs2.getString("Image");

					URL url = new URL(imageUrl2);
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();

					Image image = new Image(is);
					imageview2.setImage(image);

					modelLabel2.setText("-> " + rs2.getString("laptop"));
					// myPrice2.setText("->" + rs2.getString("Price"));
					myPrice2.setText("-> ₹ " + rs2.getString("Price") + "/-");

					myProcessor2.setText("-> " + "Processor: " + rs2.getString("Processor"));
					myGpu2.setText("-> " + "Gpu: " + rs2.getString("gpu"));
					myMemory2.setText("-> " + "Memory: " + rs2.getString("Memory"));
					myStorage2.setText("-> " + "Storage: " + rs2.getString("Storage"));
					myOs2.setText("-> " + "Operating Sys: " + rs2.getString("Osys"));
					myResolution2.setText("-> " + "Resolution: " + rs2.getString("Resolution"));

					myRatio2.setText("-> " + "Ratio: " + rs2.getString("Ratio"));
					myWeight2.setText("-> " + "Weight: " + rs2.getString("Weight"));
					myDimension2.setText("-> " + "Dimensions: " + rs2.getString("Dimensions"));

					myCamera2.setText("-> " + "Camera: " + rs2.getString("Camera"));
					myRefreshRate2.setText("-> " + "Refresh Rate: " + rs2.getString("Refresh"));
					mySize2.setText("-> " + "Size: " + rs2.getString("Size"));

				}
			}

			rs2.close();
			rs.close();
			pst2.close();
			pst.close();
			con.close();
		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}
	
    private void closeAllStages() {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.print("\n DRIVER ACTIVATED..... ");

			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/croma_info", "root",
					"Maiitra@09");
			System.out.print("\n DATABASE CONNNECTED.... ");

			Statement st2 = con2.createStatement();

			ResultSet rs2 = st2.executeQuery("select laptop from croma_updated2;");

			int i = 0;
			while (rs2.next()) {
				laptop_info[i] = rs2.getString("laptop");
				i++;
			}
			rs2.close();
			st2.close();
			con2.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}

		combobox1.getItems().addAll(laptop_info);
		combobox2.getItems().addAll(laptop_info);


		try {

			String imageUrl1 = null;
			String imageUrl2 = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/croma_info", "root", "Maiitra@09");

			PreparedStatement pst = con.prepareStatement(
					"select laptop,Price,Image,Processor,gpu,Memory,Storage,Osys,Resolution,Ratio,Weight,Dimensions,Camera,Size,Refresh from croma_updated2 where laptop=?;");

			PreparedStatement pst2 = con.prepareStatement(
					"select laptop,Price,Image,Processor,gpu,Memory,Storage,Osys,Resolution,Ratio,Weight,Dimensions,Camera,Size,Refresh from croma_updated2 where laptop=?;");

			pst.setString(1, information1);
			pst2.setString(1, information2);

			ResultSet rs = pst.executeQuery();

			ResultSet rs2 = pst2.executeQuery();
			if (information1 != null) {
				while (rs.next()) {
					imageUrl1 = rs.getString("Image");

					URL url = new URL(imageUrl1);
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();
					Image image = new Image(is);
					imageview1.setImage(image);
					
					modelLabel1.setText("-> " + rs.getString("laptop"));

					myPrice1.setText("-> ₹ " + rs.getString("Price") + "/-");

					myProcessor.setText("-> " + "Processor: " + rs.getString("Processor"));
					myGpu.setText("-> " + "Gpu: " + rs.getString("gpu"));
					myMemory.setText("-> " + "Memory: " + rs.getString("Memory"));
					myStorage.setText("-> " + "Storage: " + rs.getString("Storage"));
					myOs.setText("-> " + "Operating Sys: " + rs.getString("Osys"));
					myResolution.setText("-> " + "Resolution: " + rs.getString("Resolution"));

					myRatio.setText("-> " + "Ratio: " + rs.getString("Ratio"));
					myWeight.setText("-> " + "Weight: " + rs.getString("Weight"));

					myDimension.setText("-> " + "Dimensions: " + rs.getString("Dimensions"));

					myCamera.setText("-> " + "Camera: " + rs.getString("Camera"));
					myRefreshRate.setText("-> " + "Refresh Rate: " + rs.getString("Refresh"));
					mySize.setText("-> " + "Size: " + rs.getString("Size"));

				}
			}

			if (information2 != null) {
				while (rs2.next()) {

					imageUrl2 = rs2.getString("Image");

					URL url = new URL(imageUrl2);
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();

					Image image = new Image(is);
					imageview2.setImage(image);

					modelLabel2.setText("-> " + rs2.getString("laptop"));
					// myPrice2.setText("->" + rs2.getString("Price"));
					myPrice2.setText("-> ₹ " + rs2.getString("Price") + "/-");

					myProcessor2.setText("-> " + "Processor: " + rs2.getString("Processor"));
					myGpu2.setText("-> " + "Gpu: " + rs2.getString("gpu"));
					myMemory2.setText("-> " + "Memory: " + rs2.getString("Memory"));
					myStorage2.setText("-> " + "Storage: " + rs2.getString("Storage"));
					myOs2.setText("-> " + "Operating Sys: " + rs2.getString("Osys"));
					myResolution2.setText("-> " + "Resolution: " + rs2.getString("Resolution"));

					myRatio2.setText("-> " + "Ratio: " + rs2.getString("Ratio"));
					myWeight2.setText("-> " + "Weight: " + rs2.getString("Weight"));
					myDimension2.setText("-> " + "Dimensions: " + rs2.getString("Dimensions"));

					myCamera2.setText("-> " + "Camera: " + rs2.getString("Camera"));
					myRefreshRate2.setText("-> " + "Refresh Rate: " + rs2.getString("Refresh"));
					mySize2.setText("-> " + "Size: " + rs2.getString("Size"));

				}
			}

			rs2.close();
			rs.close();
			pst2.close();
			pst.close();
			con.close();

		} catch (Exception e) {
//			e.printStackTrace();
		}

	}

}
