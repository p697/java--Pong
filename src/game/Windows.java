package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Windows extends JFrame{
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	Panel panel = new Panel(this);
	
	
	
	Windows(){
		this.add(panel);
		this.setSize(816 ,560);  // 游戏窗口大小
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}


class Panel extends JPanel{
	Player player1;
	Player player2;
	Police police1;
	Police police2;
	Ball ball;
	Score score1;
	Score score2;
	;
	int step = 10;
	
	Panel(Windows windows){
		this.setBackground(Color.black);
		player1 = windows.player1;
		player2 = windows.player2;
		police1 = new Police(player1);
		police2 = new Police(player2);
		score1 = new Score();
		score2 = new Score();
		ball = new Ball(this);
		ball.start();  // 开启ball线程
	
		windows.addKeyListener(police1);
		windows.addKeyListener(police2);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);  // 默认颜色设为纯白
		for(var i=0; i<=19; i++) {
			g.fillRect(391, 15+i*25, 3, 15);
		}  // 这个for循环画中间的虚线
		g.fillRect(player1.x,player1.y,10,50);  // 玩家1（左边）
		g.fillRect(player2.x,player2.y,10,50);  // 玩家2（右边）
		g.fillRect(ball.x, ball.y, 10, 10);     // 小球
		Font font=new Font("Courier New",Font.PLAIN,62);  // 设置记分牌字体
        g.setFont(font); 
		g.drawString(score1.player_score, 75, 75);  //两个玩家的记分牌
		g.drawString(score2.player_score, 690, 75);
		repaint();
		run();
		try {
			Thread.sleep(20);  // 刷新率
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		if(player1.y <= 15) {
			police1.up_move = false;
		}else if(player1.y >= 455) {
			police1.down_move = false;
		}
		if(player2.y <= 15) {
			police2.up_move = false;
		}else if(player2.y >= 455) {
			police2.down_move = false;
		}
		
		if(police1.down_move) {
			player1.y += step;
		} 
		if(police1.up_move) {
			player1.y -= step;
		}
		if(police2.down_move) {
			player2.y += step;
		}
		if(police2.up_move) {
			player2.y -= step;
		}
		
		
	}

}

