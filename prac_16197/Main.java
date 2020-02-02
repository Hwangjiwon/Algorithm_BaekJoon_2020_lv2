package prac_16197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	static class Dot {
		int x;
		int y;
		int cnt;

		public Dot(int y, int x, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]); // 세로(y)
		M = Integer.parseInt(input[1]); // 가로(x)

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j].charAt(0);
			}
		}

		bfs();

		br.close();
	}

	public static void bfs() {
		Queue<Dot> coin = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'o') {
					coin.add(new Dot(i, j, 0));
				}
			}
		}

		while (!coin.isEmpty()) {
			if (coin.size() < 2)
				break;

			Dot coin1 = coin.poll();
			Dot coin2 = coin.poll();
			int cnt1 = coin1.cnt;
			int cnt2 = coin2.cnt;

			for (int i = 0; i < 4; i++) {
				int nx1 = coin1.x + dx[i];
				int ny1 = coin1.y + dy[i];

				int nx2 = coin2.x + dx[i];
				int ny2 = coin2.y + dy[i];

				if (nx1 >= 0 && ny1 >= 0 && nx1 < M && ny1 < N) {
					if (map[ny1][nx1] != '#') {
						coin.add(new Dot(ny1, nx1, cnt1 + 1));
					}
				}
				if (nx1 < 0 || ny1 < 0 || nx1 >= M || ny1 >= N) {
					if (nx2 >= 0 && ny2 >= 0 && nx2 < M && ny2 < N) {
						min = Math.min(cnt1 + 1, min);
						break;
					}
				}

				if (nx2 >= 0 && ny2 >= 0 && nx2 < M && ny2 < N) {
					if (map[ny2][nx2] != '#') {
						coin.add(new Dot(ny2, nx2, cnt2 + 1));
					}
				}
				if (nx2 < 0 || ny2 < 0 || nx2 >= M || ny2 >= N) {
					if (nx1 >= 0 && ny1 >= 0 && nx1 < M && ny1 < N) {
						min = Math.min(cnt2 + 1, min);
						break;
					}
				}
			}

			if (min > 10) {
				System.out.println(-1);
				return;
			} else
				System.out.println(min);

		}
	}
}
