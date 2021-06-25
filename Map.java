import javafx.scene.layout.Pane;

public class Map extends Pane{
	protected int UNIT = 50;
	protected int size = 0;
	protected int[][] map;
	protected Position start;

	Map(String text){
		map = new int[Integer.parseInt(text.charAt(0) + "")][Integer.parseInt(text.charAt(0) + "")];
		size = Integer.parseInt(text.charAt(0) + "");
		int current = 1;
		for(int i =0; i < map[0].length; i++){
			for(int j = 0; j < map[0].length; j++){

				boolean isWhat = true;
				while(isWhat){
					if(Character.isDigit(text.charAt(current))){
						map[i][j] = Integer.parseInt(text.charAt(current) + "");
						current++;
						isWhat = false;
						continue;

					}
					current++;
				}
				if(map[i][j] == 2){
					start = new Position(j,i);
				}
			}
		}

	}

	int getUnit(){
		return UNIT;
	}

	int getSize(){
		return size;
	}

	int getValue(int x, int y){
		return map[x][y];
	}

	Position getStartPosition(){
		return start;
	}

}