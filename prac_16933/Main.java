package prac_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // y, ¼¼·Î
		M = Integer.parseInt(tmp[1]); // x, °¡·Î
		K = Integer.parseInt(tmp[2]);

		map = new int[N][M];
		visited = new boolean[K + 1][N][M]; // ¹ã³·, ºÎ¼ö±â, ¼¼·Î, °¡·Î

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		bfs();
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

		br.close();
	}

	public static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(false, 0, 0, 0, 1));

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			boolean night = dot.night;
			int drill = dot.drill;
			int y = dot.y;
			int x = dot.x;
			int cnt = dot.cnt;

			if (x == M - 1 && y == N - 1) {
				min = Math.min(min, cnt);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (map[ny][nx] == 1) {
					if (night == false) { // ³·
						if (drill + 1 <= K) {
							if (!visited[drill + 1][ny][nx]) {
								visited[drill + 1][ny][nx] = true;
								q.add(new Dot(!night, drill + 1, ny, nx, cnt + 1));
							}
						}
					} else { // ¹ã
						if (drill + 1 <= K) {
							q.add(new Dot(!night, drill, y, x, cnt + 1)); // ÀÌµ¿ ¾øÀÌ, ¹ã->³·, cnt+1
						}
					}
				} else {
					if (!visited[drill][ny][nx]) {
						visited[drill][ny][nx] = true;
						q.add(new Dot(!night, drill, ny, nx, cnt + 1));
					}
				}
			}
		}
	}
}

class Dot {
	boolean night;
	int drill, x, y, cnt;

	public Dot(boolean night, int drill, int y, int x, int cnt) {
		this.night = night;
		this.drill = drill;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
