package prac_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	static class Dot {
		int x, y, cnt, drill;

		public Dot(int drill, int y, int x, int cnt) {
			this.drill = drill;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // y,����
		M = Integer.parseInt(tmp[1]); // x,����
		map = new int[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		dfs();
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

		br.close();
	}

	public static void dfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0, 0, 0, 1)); // drill, x, y, cnt

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int drill = dot.drill;
			int x = dot.x;
			int y = dot.y;
			int cnt = dot.cnt;

			if (x == M - 1 && y == N - 1) {
				min = Math.min(min, cnt);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (drill == 1) { // �� �μ� ���� �ִ� ���
						if (!visited[drill][ny][nx] && map[ny][nx] == 0) { // ���� �ƴϰ�, Ž�� ���� ������ �̵�
							visited[drill][ny][nx] = true;
							q.add(new Dot(drill, ny, nx, cnt + 1));
						}
					} else { // �� �μ��� ���� ���
						if (map[ny][nx] == 1) { // ���� ������ �� �μ��� ���� �� Ž�� �� �̵�
							if (!visited[drill + 1][ny][nx]) {
								visited[drill + 1][ny][nx] = true;
								q.add(new Dot(drill + 1, ny, nx, cnt + 1)); // �� �μ��� (drill +1)
							}
						} else if (map[ny][nx] == 0) { // �� �ȸ����� Ž�� �� �̵�
							if (!visited[drill][ny][nx]) {
								visited[drill][ny][nx] = true;
								q.add(new Dot(drill, ny, nx, cnt + 1));
							}
						}
					}
				}
			}
		}
	}
}
