package application;
/**
* Description: create a flag raising animation while the national anthem plays
* Created by: Michael O Stewart
* Created date: 4/3/2022
*/

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class flagRaise extends Application {
	private final static String URLBase = "https://liveexample.pearsoncmg.com/common";

	public void start(Stage primaryStage) {

		Pane pane = new Pane();

		// ImageView imageV = new
		// ImageView("https://cdn.countryflags.com/thumbs/united-states-of-america/flag-wave-250.png");
		ImageView imageV = new ImageView(URLBase + "/image/flag6.gif");
		Line flagPole = new Line(25, 400, 25, 25);
		flagPole.setStrokeWidth(3);
		imageV.setFitWidth(150);
		imageV.setFitHeight(100);
		pane.getChildren().addAll(imageV, flagPole);

		PathTransition pt = new PathTransition(Duration.millis(10000), new Line(100, 350, 100, 80), imageV);

		pt.setCycleCount(1);
		pt.play();

		Media media = new Media(URLBase + "/audio/anthem/anthem6.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);
		mediaPlayer.play();
		pane.getChildren().add(mediaView);

		Scene scene = new Scene(pane, 500, 400);

		primaryStage.setTitle("Flag Animation with Anthem");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
