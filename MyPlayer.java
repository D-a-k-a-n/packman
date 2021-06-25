import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;


public class MyPlayer implements Player{
	protected Circle ball;
	protected Map map;
	protected Position position;
	protected ImageView imageView;

	MyPlayer(Map map){
		this.map = map;
		position = map.getStartPosition();

		// this.ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2.0, position.getY() * map.getUnit() + map.getUnit() / 2.0, map.getUnit()/2.0f);
		// this.ball.setFill(Color.RED);
		// this.ball.setStroke(Color.BLACK);
		//map.getChildren().add(this.ball);
		String path = "gun.png";
		Image image = new Image(new File(path).toURI().toString());
		imageView = new ImageView(image);
		imageView.setX(position.getX()); 
      	imageView.setY(position.getY());
      	imageView.setFitHeight(map.getUnit()); 
      	imageView.setFitWidth(map.getUnit());
      	map.getChildren().add(imageView);

	}

	@Override
	public Position getPosition(){
		return position;
	}

	@Override
	public void moveRight(){
		try{
			if(map.getValue(position.getY(), position.getX() + 1) == 0 || map.getValue(position.getY(), position.getX() + 1) == 2){
				position.setX(position.getX() + 1);
			}
			// map.getChildren().remove(this.ball);
			// this.ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2.0, position.getY() * map.getUnit() + map.getUnit() / 2.0, map.getUnit()/2.0f);
			// this.ball.setFill(Color.RED);
			// this.ball.setStroke(Color.BLACK);
			// map.getChildren().add(this.ball);
			map.getChildren().remove(this.imageView);
			imageView.setX(position.getX() * map.getUnit()); 
      		imageView.setY(position.getY() * map.getUnit());
			map.getChildren().add(imageView);
		}catch(Exception ex){System.out.println("Invalid position");}
	}

	@Override
	public void moveLeft(){
		try{
			if(map.getValue(position.getY(), position.getX() - 1) == 0 || map.getValue(position.getY(), position.getX() - 1) == 2){
				position.setX(position.getX() - 1);
			}
			// map.getChildren().remove(this.ball);
			// this.ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2.0, position.getY() * map.getUnit() + map.getUnit() / 2.0, map.getUnit()/2.0f);
			// this.ball.setFill(Color.RED);
			// this.ball.setStroke(Color.BLACK);
			// map.getChildren().add(this.ball);
			map.getChildren().remove(this.imageView);
			imageView.setX(position.getX() * map.getUnit()); 
      		imageView.setY(position.getY() * map.getUnit());
			map.getChildren().add(imageView);
		}catch(Exception ex){System.out.println("Invalid position");}
	}

	@Override
	public void moveUp(){
		try{
			if(map.getValue(position.getY() - 1, position.getX()) == 0 || map.getValue(position.getY() - 1, position.getX()) == 2){
				position.setY(position.getY() - 1);
			}
			// map.getChildren().remove(this.ball);
			// this.ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2.0, position.getY() * map.getUnit() + map.getUnit() / 2.0, map.getUnit()/2.0f);
			// this.ball.setFill(Color.RED);
			// this.ball.setStroke(Color.BLACK);
			// map.getChildren().add(this.ball);
			map.getChildren().remove(this.imageView);
			imageView.setX(position.getX() * map.getUnit()); 
      		imageView.setY(position.getY() * map.getUnit());
			map.getChildren().add(imageView);
		}catch(Exception ex){System.out.println("Invalid position");}
	}

	@Override 
	public void moveDown(){
		try{
			if(map.getValue(position.getY() + 1, position.getX()) == 0 || map.getValue(position.getY() + 1, position.getX()) == 2){
				position.setY(position.getY() + 1);
			}
			// map.getChildren().remove(this.ball);
			// this.ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2.0, position.getY() * map.getUnit() + map.getUnit() / 2.0, map.getUnit()/2.0f);
			// this.ball.setFill(Color.RED);
			// this.ball.setStroke(Color.BLACK);
			// map.getChildren().add(this.ball);
			map.getChildren().remove(this.imageView);
			imageView.setX(position.getX() * map.getUnit()); 
      		imageView.setY(position.getY() * map.getUnit());
			map.getChildren().add(imageView);
		}catch(Exception ex){System.out.println("Invalid position");}
	}
}