package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ReviewController implements Initializable {
	int flag = 0;

	@FXML
	private Slider mySlider;

	double rating;

	@FXML
	private Button mySubmit;
	@FXML
	private TextArea ta;

	@FXML
	private ImageView myWorst, myPoor, myAverage, myGood, myExcellent;

	int initialRating;

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
	
    private void closeAllStages() {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }

	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			initialRating = (int) mySlider.getValue();

			mySlider.valueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
					flag = 1;
					rating = mySlider.getValue();
					if (rating >= 1.1 && rating <= 1.9) {
						rating = (int) 2.0;

					}
					if (rating >= 2.1 && rating <= 2.9) {
						rating = (int) 3.0;

					}
					if (rating >= 3.1 && rating <= 3.9) {
						rating = (int) 4.0;

					}
					if (rating >= 4.1 && rating <= 4.9) {
						rating = (int) 5.0;

					}

				}

			});

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public void submit(ActionEvent ae) {
		try {
			if (ae.getSource() == mySubmit) {
				Alert a = new Alert(AlertType.INFORMATION);
				DialogPane dialogPane = a.getDialogPane();
				dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				a.setTitle("Review");
				if (flag == 0) {
					a.setHeaderText("Rating:" + (int) initialRating);
				} else {
					a.setHeaderText("Rating:" + (int) rating);
				}
				a.setContentText("Review has been submitted\n\n\n\n\t\t\tThank you");
				a.show();
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void colorChange(MouseEvent me) {
		mySubmit.setStyle("-fx-background-color: #45a29e; -fx-background-radius: 20;-fx-text-fill:black;");
	}

	public void colorNormal(MouseEvent me) {

		mySubmit.setStyle(
				"-fx-background-color: #0b0c10; -fx-background-radius: 20; -fx-border-width: 2; -fx-border-color: #66fcf1; -fx-border-radius: 20;");
	}

}
