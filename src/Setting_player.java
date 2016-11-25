
public class Setting_player {
	private String player1, player2;

	public Setting_player() {}

	public Setting_player(String player1, String player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

}
