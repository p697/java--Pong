package game;


public class Player{

	public int x;
	public int y;
	public int id;

	public Player(int id) {
		this.id = id;
		if(id == 1) {
			x = 50;
		}else {
			x = 740;
		}
		y = 235; 
	}

}
