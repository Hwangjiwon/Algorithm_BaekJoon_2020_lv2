package prac_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int r, c;
	static int[][] board;
	static boolean[] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		r = Integer.parseInt(tmp[0]);
		c = Integer.parseInt(tmp[1]);

		board = new int[r][c];
		visited = new boolean[26];

		for (int i = 0; i < r; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				board[i][j] = (int) tmp[j].charAt(0) - (int) 'A';
			}
		}

		dfs(0, 0, 0);
		System.out.println(max);

		br.close();
	}

	public static void dfs(int y, int x, int cnt) {
		visited[board[y][x]] = true;
		max = Math.max(max, cnt + 1);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < c && ny < r) {
				if (!visited[board[ny][nx]]) {
					visited[board[ny][nx]] = true;
					dfs(ny, nx, cnt + 1);
					visited[board[ny][nx]] = false;
				}
			}
		}
	}
}
