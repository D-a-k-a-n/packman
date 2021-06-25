public class Position{
	protected int x = 0;
	protected int y = 0;

	Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	int getX(){
		return x;
	}

	int getY(){
		return y;
	}

	void setX(int x){
		this.x = x;
	}

	void setY(int y){
		this.y = y;
	}

	boolean equals(Position first){
		return first.getX() == this.getX() && first.getY() == this.getY() ? true : false;
	}
}