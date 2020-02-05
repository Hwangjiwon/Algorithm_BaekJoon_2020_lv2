package prac_13460;

import java.io.*;
import java.util.*;

public class Main {
	static class Dot {
		int rx, ry;
		int bx, by;
		int cnt;

		Dot(int ry, int rx, int by, int bx, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}

		Dot() {

		}
	}

	static int N, M;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][][][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // ����y
		M = Integer.parseInt(tmp[1]); // ����x

		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		Dot dot = new Dot();
		dot.cnt = 0;

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j].charAt(0);
				if (map[i][j] == 'R') {
					dot.rx = j;
					dot.ry = i;
				}
				if (map[i][j] == 'B') {
					dot.bx = j;
					dot.by = i;
				}
			}
		}

		System.out.println(bfs(dot));
		br.close();
	}

	public static int bfs(Dot dot) {
		Queue<Dot> q = new LinkedList<>();
		q.add(dot);

		while (!q.isEmpty()) {
			Dot point = q.poll();
			visited[point.ry][point.rx][point.by][point.bx] = true;

			if (point.cnt > 10)
				continue;
			if (map[point.by][point.bx] == 'O')
				continue;
			if (map[point.ry][point.rx] == 'O')
				return point.cnt;

			for (int i = 0; i < 4; i++) {
				// ���� ���� �����¿� ������ �̵�
				int next_rx = point.rx, next_ry = point.ry;
				while (true) {
					// ���� ������ ���̶� ������ �ƴϸ�
					if (map[next_ry][next_rx] != '#' && map[next_ry][next_rx] != 'O') {
						next_rx += dx[i];
						next_ry += dy[i];
					} else {
						// ���� ������ ���̸�
						if (map[next_ry][next_rx] == '#') {
							next_rx -= dx[i];
							next_ry -= dy[i];
						}
						break;
					}
				}

				// �Ķ� ���� �����¿� ������ �̵�
				int next_bx = point.bx, next_by = point.by;
				while (true) {
					// ���� ������ ���̶� ������ �ƴϸ�
					if (map[next_by][next_bx] != '#' && map[next_by][next_bx] != 'O') {
						next_bx += dx[i];
						next_by += dy[i];
					} else {
						// ���� ������ ���̸�
						if (map[next_by][next_bx] == '#') {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
						break;
					}
				}

				// ���� Red, Blue �� ���� ���� ������ 'O'�� �ƴ� ���
				// �� ������ ������ dx[i], dy[i]�� ���ش�
				if (next_rx == next_bx && next_ry == next_by) {
					if (map[next_ry][next_rx] != 'O') {
						int red_cost = Math.abs(next_rx - point.rx) + Math.abs(next_ry - point.ry);
						int blue_cost = Math.abs(next_bx - point.bx) + Math.abs(next_by - point.by);
						if (red_cost > blue_cost) {
							next_rx -= dx[i];
							next_ry -= dy[i];
						} else {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
					}
				}

				// next ���� �湮���� ���ٸ� ť�� �߰�
				if (!visited[next_ry][next_rx][next_by][next_bx]) {
					visited[next_ry][next_rx][next_by][next_bx] = true;
					q.add(new Dot(next_ry, next_rx, next_by, next_bx, point.cnt + 1));
				}
			}
		}
		return -1;
	}
}
