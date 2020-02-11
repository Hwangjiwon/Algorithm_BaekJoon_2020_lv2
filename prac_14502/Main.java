package prac_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Dot {
		int x;
		int y;

		Dot(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] map, copy;
	static boolean[][] visited;
	static List<Dot> virus = new LinkedList<Main.Dot>();
	static int safeCnt, result;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // 세로, y
		M = Integer.parseInt(tmp[1]); // 가로, x

		map = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				copy[i][j] = map[i][j];
				if (map[i][j] == 2)
					virus.add(new Dot(i, j));
			}
		}
		result = 0;
		wall(0);
		System.out.println(safeCnt);

		br.close();
	}

	public static void wall(int cnt) {
		if (cnt == 3) {

			worm();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 0)
						result++;
				}
			}
			safeCnt = Math.max(safeCnt, result);

			cnt = 0;
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					map[i][j] = 1;
					copy[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
					copy[i][j] = 0;
				}
			}
		}
	}

	public static void worm() {
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(new Dot(virus.get(i).y, virus.get(i).x));
			visited[virus.get(i).y][virus.get(i).x] = true;
		}

		while (!q.isEmpty()) {
			Dot pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (!visited[ny][nx]) {
						if (copy[ny][nx] == 0) {
							visited[ny][nx] = true;
							copy[ny][nx] = 2;
							q.add(new Dot(ny, nx));
							visited[ny][nx] = false;
						}
					}
				}
			}
		}
	}
}
