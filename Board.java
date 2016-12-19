public class Board {
	int[][] board;
	public Board() {
		board = new int[3][3];
	}
	public int[][] getBoard() {
		return board;
	}
	public int isTie() {
		if (checkColumn() == 0 && checkRow() == 0 && checkDiagonal() == 0) return 0;
		if (checkColumn() == 1 || checkRow() == 1 || checkDiagonal() == 1) return 1;
		return 2;
	}
	private int checkColumn() {
		for (int i = 0; i < 3; i++) {
			int count = 1;
			for (int j = 1; j < 3; j++) {
				if (board[j][i] == board[j-1][i]) count++;
			}
			if (count == 3) return board[0][i];
		}
		return 0;
	}
	private int checkRow() {
		for (int i = 0; i < 3; i++) {
			int count = 1;
			for (int j = 1; j < 3; j++) {
				if (board[i][j] == board[i][j-1]) count++;
			}
			if (count == 3) return board[i][0];
		}
		return 0;
	}
	private int checkDiagonal() {
		int count = 1;
		for (int i = 1; i < 3; i++) {
			if (board[i][i] == board[i-1][i-1]) count++;
		}
		if (count == 3) return board[0][0];
		int count1 = 1;
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
		return 0;
	}
	public boolean go(int player, int x, int y) {
		if (x < 0 || x > 2 || y < 0 || y > 2) return false;
		else {
			if (board[x][y] != 0) return false;
			else { 
				board[x][y] = player;
				return true;
			}
		}
	}
	public boolean isNotFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}
}