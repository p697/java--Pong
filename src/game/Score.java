package game;

public class Score {
	public String player_score= "0";
	int score_mid;

	public void add(int id) {
		score_mid = Integer.parseInt(player_score);
		score_mid ++;
		player_score = String.valueOf(score_mid);
		if(id == 1) {
			System.out.println("玩家1得分");
		}
		else {
			System.out.println("玩家2得分");
		}
		
	}
}
