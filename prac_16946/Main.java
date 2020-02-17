package prac_16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // y,세로
		M = Integer.parseInt(tmp[1]); // x,가로

		map = new int[N][M];
		visited = new boolean[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}
		print(result);

		br.close();
	}

	public static void bfs(int y, int x) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(y, x, 1, 0));

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int px = dot.x;
			int py = dot.y;
			int cnt = dot.cnt;
			int drill = dot.drill;

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (drill >= 1 && map[ny][nx] == 1)
					continue;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					cnt++;
					q.add(new Dot(ny, nx, cnt, drill + 1));
					result[py][px] = cnt;
				}

			}
		}

	}

	public static void print(int[][] result) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				System.out.print(result[i][j]);
			System.out.println();
		}
	}
}

class Dot {
	int x, y, cnt = 1, drill = 1;

	public Dot(int y, int x, int cnt, int drill) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.drill = drill;
	}
}