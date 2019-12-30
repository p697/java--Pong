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
			if(x >= 730) {  									// ��С�򴥼��ұ߽�
				if(y >= player2.y-10 && y <= (player2.y+60)) {  // �ж����2��û�н�ס
					ballBounce("x");							// ��ס�ˣ���
					x = 729;
				}else {											// û��ס
					score1.add(1);								// ���1�ӷ�
					ballStart();								// ���·���
				}
			}
			if(x <= 60) {										// ��С�򴥼���߽�
				if(y >= player1.y-10 && y <= (player1.y+60)) {  // �ж����1��û�н�ס
					ballBounce("x");							// ��ס�ˣ���
					x = 61;
				}else {											// û��ס
					score2.add(2);								// ���2�ӷ�
					ballStart();								// ���·���
				}
			}
			if(y <= 15 || y >= 495) {							// С��ײ�����±߽硣��
				ballBounce("y");
			}
			try {
				Thread.sleep(hz);								// ˢ�£�hzΪ��ʼֵ17ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	����
	void ballStart() {
		hz = 17;  // ��ʼˢ���ٶ�Ϊ17ms�� ֮�������ֵ��ԭ��ԽС������Խ��Խ��
		x = 387;  // ����xλ�� 
		y = 255;  // ����yλ�� 
		x_speed = 3;  // x�����ʼ�ٶ�
		y_speed = 1 + (int)(Math.random()*1);  // y�����ʼ����ٶ�
		if(Math.random() <= 0.5) {
			y_speed *= -1;}			// С��y�����ٶȷ������
		if(Math.random() <= 0.5) {
			x_speed *= -1;}			// С��x�����ٶȷ������
		try {
			Thread.sleep(1000);  // ͣ��1��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	����Ϊ�˸��õ���Ϸ���飬�����Ϊ����
	void ballBounce(String id) {
		// x����ײ�������
		if(id == "x") {
			x_speed *= -1;   // �ı�x�ٶȷ���
			bounce_time ++;  // ��¼���˶��ٴ�
			if(hz > 11) {	 // ˢ��ֵС��11msʱ��ÿ��ײ������1
				hz --;
			}
			if(bounce_time%9 == 0) {  // ������9�ı����κ��1
				hz --;
			}
			if(Math.random() < 0.4) {  						// y�����ٶ�����ı�
				int y_change = (int)(1+Math.random()*3);
				if(Math.random() < 0.5) {
					y_change *= -1;}
				y_speed += y_change;
			}
			if(Math.abs(y_speed) > Math.abs(x_speed)) {		// ����y����С��x����
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
		
//	�÷�
//	void getScore(int id) {
//		if(id == 1) {
//			System.out.println("���1�÷�");
//		}else {
//			System.out.println("���2�÷�");
//		}
//		ballStart();
//	}
}
