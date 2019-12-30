package game;

import java.util.Random;

public class Ball extends Thread{
	public int x;
	public int y;
	public int x_speed;
	public int y_speed;
	public int hz;
	int bounce_time = 0;
	Panel panel;
	Player player1;
	Player player2;
	Score score1;
	Score score2;
	
	Ball(Panel panel_){
		panel = panel_;
		player1 = panel_.player1;
		player2 = panel_.player2;
		score1 = panel_.score1;
		score2 = panel_.score2;
	}
	public void run() {
		ballStart();
		while(true) {
			x += x_speed;
			y += y_speed;
			if(x >= 730) {  									// 当小球触及右边界
				if(y >= player2.y-10 && y <= (player2.y+60)) {  // 判断玩家2有没有接住
					ballBounce("x");							// 接住了，弹
					x = 729;
				}else {											// 没接住
					score1.add(1);								// 玩家1加分
					ballStart();								// 重新发球
				}
			}
			if(x <= 60) {										// 当小球触及左边界
				if(y >= player1.y-10 && y <= (player1.y+60)) {  // 判断玩家1有没有接住
					ballBounce("x");							// 接住了，弹
					x = 61;
				}else {											// 没接住
					score2.add(2);								// 玩家2加分
					ballStart();								// 重新发球
				}
			}
			if(y <= 15 || y >= 495) {							// 小球撞到上下边界。弹
				ballBounce("y");
			}
			try {
				Thread.sleep(hz);								// 刷新，hz为初始值17ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	发球
	void ballStart() {
		hz = 17;  // 初始刷新速度为17ms， 之后这个数值会原来越小，球速越来越快
		x = 387;  // 中心x位置 
		y = 255;  // 中心y位置 
		x_speed = 3;  // x方向初始速度
		y_speed = 1 + (int)(Math.random()*1);  // y方向初始随机速度
		if(Math.random() <= 0.5) {
			y_speed *= -1;}			// 小球y方向速度方向随机
		if(Math.random() <= 0.5) {
			x_speed *= -1;}			// 小球x方向速度方向随机
		try {
			Thread.sleep(1000);  // 停顿1秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	弹球，为了更好的游戏体验，设计稍为复杂
	void ballBounce(String id) {
		// x代表撞到玩家了
		if(id == "x") {
			x_speed *= -1;   // 改变x速度方向
			bounce_time ++;  // 记录弹了多少次
			if(hz > 11) {	 // 刷新值小于11ms时，每次撞击都减1
				hz --;
			}
			if(bounce_time%9 == 0) {  // 当弹了9的倍数次后减1
				hz --;
			}
			if(Math.random() < 0.4) {  						// y方向速度随机改变
				int y_change = (int)(1+Math.random()*3);
				if(Math.random() < 0.5) {
					y_change *= -1;}
				y_speed += y_change;
			}
			if(Math.abs(y_speed) > Math.abs(x_speed)) {		// 限制y速率小于x速率
				if(y_speed*x_speed > 0) {
					y_speed = x_speed;
				}else {
					y_speed = -1*x_speed;
				}
				
			}
		}else {
			y_speed *= -1;
		}
	}
		
//	得分
//	void getScore(int id) {
//		if(id == 1) {
//			System.out.println("玩家1得分");
//		}else {
//			System.out.println("玩家2得分");
//		}
//		ballStart();
//	}
}
