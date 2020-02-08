package prac_16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Dot {
		int r, c;
		int cnt;

		public Dot(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int fromR, fromC, toR, toC;
	static int[][] go = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		String[] tmp = br.readLine().split(" ");

		fromR = Integer.parseInt(tmp[0]);
		fromC = Integer.parseInt(tmp[1]);

		toR = Integer.parseInt(tmp[2]);
		toC = Integer.parseInt(tmp[3]);

		bfs();
		br.close();
	}

	public static void bfs() {
		Queue<Dot> q = new LinkedList<Main.Dot>();
		q.add(new Dot(fromR, fromC, 0));
		visited[fromR][fromC] = true;

		while (!q.isEmpty()) {
			Dot pos = q.poll();
			int nowR = pos.r, nowC = pos.c, nowCnt = pos.cnt;
			int nextR, nextC;

			if (nowR == toR && nowC == toC) {
				System.out.println(nowCnt);
				return;
			}

			for (int i = 0; i < 6; i++) {
				nextR = nowR + go[i][0];
				nextC = nowC + go[i][1];

				if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
					if (visited[nextR][nextC] == false) {
						visited[nextR][nextC] = true;
						q.add(new Dot(nextR, nextC, nowCnt + 1));
					}
				}
			}

		}
		System.out.println(-1);
	}
}
