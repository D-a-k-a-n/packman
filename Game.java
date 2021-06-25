import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.event.*;
import java.io.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;
import java.util.Scanner;

public class Game extends Application{
	protected static Map map;
	protected static Player player;
	protected static Food food;
	//protected BotPlayer bot;

	public static void main(String[] args) throws Exception{
		String fileMap = "";
		try{
			File file = new File(args[0]);
			Scanner in = new Scanner(file);

			while(in.hasNextLine()){
				fileMap += in.nextLine();
			}
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}

		map = new Map(fileMap);
		getMap();
		player = new MyPlayer(map);
		food = new Food(map, player);
		System.out.println("Size is: " + map.getSize());

		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Scene scene = new Scene(map, 500,500);
		//System.out.println(food.getPosition().getX() + " " + food.getPosition().getY() );

		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				player.moveUp();
				if(player.getPosition().equals(food.getPosition())){
					try{getShot();}catch(Exception ex){}
				}
			}
			else if (e.getCode() == KeyCode.DOWN) {
				player.moveDown();
				if(player.getPosition().equals(food.getPosition())){
					try{getShot();}catch(Exception ex){}
				}
			}
			else if(e.getCode() == KeyCode.LEFT){
				player.moveLeft();
				if(player.getPosition().equals(food.getPosition())){
					try{getShot();}catch(Exception ex){}
				}
			}
			else if(e.getCode() == KeyCode.RIGHT){
				player.moveRight();
				if(player.getPosition().equals(food.getPosition())){
					try{getShot();}catch(Exception ex){}
				}
			}
			else if(e.getCode() == KeyCode.E){
				System.out.println("E (eat) key pressed");
				//try{
					//bot = new MyBotPlayer(player, food);
					//bot.eat();
				//}catch(Exception ex){}
				
			}
			else if(e.getCode() == KeyCode.F){
				System.out.println("F (find) key pressed");
				//try{
					//bot = new MyBotPlayer(player, food, map);
					//bot.find();
				//}catch(Exception ex){}
			}
		});
		getMusic(); // for music!
		primaryStage.setScene(scene);
		primaryStage.setTitle("Project_3");
		primaryStage.show();
	}

	static void getMap() throws Exception{
		String scenePath = "galactic.png";
		ImageView sceneImage = new ImageView(new Image(new File(scenePath).toURI().toString()));
		sceneImage.setFitHeight(500);
		sceneImage.setFitWidth(500);
		map.getChildren().add(sceneImage);

		//Rectangle[][] rectangle = new Rectangle[map.getSize()][map.getSize()];
		String pathSky = "sky.png";
		String pathBlue = "blue.png";
		ImageView[][] imageView = new ImageView[map.getSize()][map.getSize()];
		

		for(int i = 0; i < map.getSize(); i++){
			for(int j = 0; j < map.getSize(); j++){
				if(map.getValue(i,j) == 0 || map.getValue(i,j) == 2){
					// rectangle[i][j] = new Rectangle(j * map.getUnit(), i * map.getUnit(), map.getUnit(), map.getUnit());
					// rectangle[i][j].setFill(Color.WHITE);
					// rectangle[i][j].setStroke(Color.BLACK);
					// map.getChildren().add(rectangle[i][j]);
					imageView[i][j] = new ImageView(new Image(new File(pathSky).toURI().toString()));
					imageView[i][j].setX(j * map.getUnit()); 
      				imageView[i][j].setY(i * map.getUnit());
      				imageView[i][j].setFitHeight(map.getUnit()); 
      				imageView[i][j].setFitWidth(map.getUnit());
      				map.getChildren().add(imageView[i][j]);
				}
				else{
					// rectangle[i][j] = new Rectangle(j * map.getUnit(), i * map.getUnit(), map.getUnit(), map.getUnit());
					// rectangle[i][j].setFill(Color.BLACK);
					// rectangle[i][j].setStroke(Color.BLACK);
					// map.getChildren().add(rectangle[i][j]);
					imageView[i][j] = new ImageView(new Image(new File(pathBlue).toURI().toString()));
					imageView[i][j].setX(j * map.getUnit()); 
      				imageView[i][j].setY(i * map.getUnit());
      				imageView[i][j].setFitHeight(map.getUnit()); 
      				imageView[i][j].setFitWidth(map.getUnit());
      				map.getChildren().add(imageView[i][j]);
				}
			}
		}
	}

	static void getMusic() throws Exception{
		String musicFile = "music.mp3";
		Media media = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

	}

	static void getShot() throws Exception{
		String musicShots = "shotGun.mp3";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(musicShots).toURI().toString()));
		mediaPlayer.setAutoPlay(true);
	}
}