package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Police extends KeyAdapter {
	Player player;
	int id;  // 判断是哪个玩家，id=1为玩家1
	Boolean up_move = false;  // 当up_move为true时，玩家向上持续移动
	Boolean down_move = false;
	
	public Police(Player player_){
		// 传入player对象
		id = player_.id;  
		player = player_;
	}

	public void keyPressed(KeyEvent e) {
		if(id == 1) {						// 玩家1按下了按键
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				up_move = true;
				break;
			case KeyEvent.VK_S:
				down_move = true;
				break;
			}
		}
		else if(id == 2) {					// 玩家2按下了按键
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				up_move = true;
				break;
			case KeyEvent.VK_DOWN:
				down_move = true;
				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if(id == 1) {						// 玩家1松开了按键
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				up_move = false;
			case KeyEvent.VK_S:
				down_move = false;
			}
		}
		else if(id == 2) {					// 玩家1松开了按键
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				up_move = false;
			case KeyEvent.VK_DOWN:
				down_move = false;
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	
}


