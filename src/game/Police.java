package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Police extends KeyAdapter {
	Player player;
	int id;  // �ж����ĸ���ң�id=1Ϊ���1
	Boolean up_move = false;  // ��up_moveΪtrueʱ��������ϳ����ƶ�
	Boolean down_move = false;
	
	public Police(Player player_){
		// ����player����
		id = player_.id;  
		player = player_;
	}

	public void keyPressed(KeyEvent e) {
		if(id == 1) {						// ���1�����˰���
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				up_move = true;
				break;
			case KeyEvent.VK_S:
				down_move = true;
				break;
			}
		}
		else if(id == 2) {					// ���2�����˰���
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
		if(id == 1) {						// ���1�ɿ��˰���
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				up_move = false;
			case KeyEvent.VK_S:
				down_move = false;
			}
		}
		else if(id == 2) {					// ���1�ɿ��˰���
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


